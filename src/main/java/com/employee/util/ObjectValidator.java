package com.employee.util;

import com.employee.dto.EmployeeDto;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
public class ObjectValidator {

    private ObjectValidator(){

    }
    public static void validateEmployeeDto(EmployeeDto employeeDto) {
        log.debug("In ObjectValidator -> validateEmployeeDto() Called");
        if (isStringOnlyAlphabet(employeeDto.getEmployeeName())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "EmployeeName cannot contain Alphanumeric Characters");
        }
        if (isStringOnlyAlphabet(employeeDto.getEmployeeLastName())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "EmployeeLastName cannot contain Alphanumeric Characters");
        }
        if (isStringAlphanumeric(employeeDto.getEmployeeAddress())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "EmployeeAddress cannot contain Alphanumeric Characters");
        }
        if (isHairColorPresent(employeeDto.getEmployeeHairColor().name()) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "EmployeeHairColor cannot contain Alphanumeric Characters");

        }

    }

    private static boolean isStringOnlyAlphabet(String str) {
        return !Objects.nonNull(str) || (!str.matches("^[a-zA-Z]*$"));
    }

    private static boolean isStringAlphanumeric(String str) {
        return Objects.nonNull(str) && (str.matches("[a-zA-Z0-9]+"));
    }

    private static HairColor isHairColorPresent(String hairColor) {
        log.debug("In ObjectValidator -> isHairColorPresent() hairColor{}", hairColor);
        for (HairColor hc : HairColor.values()) {
            if (hc.name().equalsIgnoreCase(hairColor))
                return hc;
        }
        return null;
    }
}
