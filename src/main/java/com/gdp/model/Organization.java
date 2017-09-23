package com.gdp.model;

import static com.gdp.model.ContentFormat.JSON;
import java.util.Arrays;

public enum Organization {

    IMF("INTERNATIONAL MONETARY FUND (IMF)"),
    WB("WORLD BANK"),
    UN("UNITED NATIONS");
    
    private final String value;
    
    Organization(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public Organization get(String value) {
        return Arrays.stream(Organization.values())
                .filter(format -> format.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElse(IMF);
    }
    
}
