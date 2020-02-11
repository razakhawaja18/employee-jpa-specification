package com.employee.util;
public enum HairColor {

    BLACK(1, "BLACK"),
    RED(2, "RED"),
    YELLOW(3, "YELLOW"),
    BROWN(4, "BROWN"),
    WHITE(5, "WHITE");

    Integer id;
    String value;

    HairColor(Integer id, String message) {
        this.id = id;
        this.value = message;
    }

}
