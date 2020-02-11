package com.employee.service.specifications;


import com.employee.dto.BranchDto;
import com.employee.dto.CompanyDto;
import com.employee.dto.EmployeeDto;
import com.employee.dto.EmployeeRequestDto;
import com.employee.model.Branch;
import com.employee.model.Employee;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.Join;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

@SuppressWarnings({"unused"})
@Slf4j
public class EmployeeSpecificationFactory {

    private static final String BRANCH = "branch";
    private static final String COMPANY = "company";

    private EmployeeSpecificationFactory() {
    }

    private static Specification isEqual(String attribute, Object value) {
        return (root, query, cb) -> cb.equal(root.get(attribute), value);
    }

    private static Specification joinBranch(String attribute, Object value) {
        return (root, query, cb) -> {
            query.distinct(true);
            Join<Employee, Branch> join = root.join(BRANCH);
            return cb.equal(join.get(attribute), value);
        };
    }

    private static Specification joinCompany(String attribute, Object value) {
        return (root, query, cb) -> {
            Join<Employee, Branch> join = root.join(BRANCH);
            return cb.equal(join.get(COMPANY).get(attribute), value);
        };
    }

    private static List<Specification> createSpecificationList(Object objectType, List<Specification> specificationList) {
        List<Specification> specs = specificationList;
        if (specificationList == null) {
            specs = new ArrayList<>();
        }
        for (Field field : objectType.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object childObject = field.get(objectType);
                if (childObject != null) {
                    specs.addAll(getMemberSpecificationList(childObject));
                }
            } catch (IllegalAccessException ie) {
                log.error("Exception while fetching class attribute ", ie);
                log.debug("Exception while fetching class attribute ", ie);
            }
        }
        return specs;
    }

    private static List<Specification> getMemberSpecificationList(Object childObject) throws IllegalAccessException {
        List<Specification> specs = new ArrayList<>();
        Specification specification;
        for (Field memberField : childObject.getClass().getDeclaredFields()) {
            memberField.setAccessible(true);
            Object memberObject = memberField.get(childObject);
            if (memberObject != null && validate(memberObject)) {
                specification = createSpecification(
                        memberField.getName(), memberField.get(childObject))
                        .get(childObject.getClass());
                specs.add(specification);
            }
        }
        return specs;
    }

    private static boolean validate(Object object) {
        Class clazz = object.getClass();
        return (String.class.equals(clazz) || Long.class.equals(clazz) || Integer.class.equals(clazz)) && !StringUtils.isEmpty(object.toString());
    }

    private static Map<Class, Specification> createSpecification(String attribute, Object value) {
        Map<Class, Specification> specificationMap = new HashMap<>();
        specificationMap.put(EmployeeDto.class, isEqual(attribute, value.toString()));
        specificationMap.put(BranchDto.class, joinBranch(attribute, value.toString()));
        specificationMap.put(CompanyDto.class, joinCompany(attribute, value.toString()));
        return specificationMap;
    }

    public static Specification searchEmployeeWithSpecification(EmployeeRequestDto employeeRequestDto) {
        log.debug("In EmployeeSpecificationFactory -> searchEmployeeWithSpecification() Called | employeeRequestDto {}", employeeRequestDto);
        List<Specification> specs = createSpecificationList(employeeRequestDto, null);
        Specification result = null;
        if (!specs.isEmpty()) {
            result = specs.get(0);
            for (Specification spec : specs) {
                result = Specification.where(result).and(spec);
            }
        }
        return result;
    }
}