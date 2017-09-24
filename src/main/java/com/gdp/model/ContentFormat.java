package com.gdp.model;

import java.util.Arrays;

public enum ContentFormat {
    
    JSON("json"),
    XML("xml");
    
    private final String value;
    
    ContentFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public ContentFormat get(String value) {
        return Arrays.stream(ContentFormat.values())
                .filter(format -> format.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElse(JSON);
    }

}
