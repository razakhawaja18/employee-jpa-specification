package com.employee.util;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginatedRequest implements Pageable {
    private int limit;
    private int offset; // offset for starting index always start with value: 1
    private Sort sort;

    public PaginatedRequest(int firstResult, int maxResults, Sort sort) {
        Integer offset = (firstResult - PaggingDefaults.START_INDEX.getValue());
        int limit = firstResult % 2 == 1 ? maxResults + 1 : maxResults;
        this.limit = (limit - firstResult);
        this.offset = offset;
        this.sort = sort;
    }

    @Override
    public int getPageNumber() {
        return Integer.MIN_VALUE;
    }

    @Override
    public int getPageSize() {
        return limit;
    }

    @Override
    public long getOffset() {
        return offset;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
