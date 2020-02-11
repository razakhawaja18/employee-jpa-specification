package com.employee.dto;

import com.employee.util.PaggingDefaults;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
public class PageDto<T> {

    @XmlElement(required = true)
    public int firstResult;
    @XmlElement(required = true)
    public int maxResults;
    @XmlElement(required = true)
    public Sort.Direction sortDirection;
    @XmlElement(required = true)
    public String sortColumn;
    @XmlElement(required = true)
    protected long totalElements;
    @XmlElement(required = true)
    private List<T> listObject;

    PageDto() {
        this.firstResult = PaggingDefaults.START_INDEX.getValue();
        this.maxResults = PaggingDefaults.END_INDEX.getValue();
        this.sortDirection = Sort.Direction.fromString("DESC");
    }

    public PageDto(List<T> listObject, long totalElements, int firstResult, int totalNumberOfElement, String sortColumn, Sort.Direction sortDirection) {
        this.totalElements = totalElements;
        this.firstResult = firstResult;
        this.maxResults = totalNumberOfElement;
        this.listObject = listObject;
        this.sortColumn = sortColumn;
        this.sortDirection = sortDirection;
    }

}
