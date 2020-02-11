package com.employee.util;

public enum PaggingDefaults {

    START_INDEX(1), END_INDEX(10);

    Integer value;

    PaggingDefaults(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
