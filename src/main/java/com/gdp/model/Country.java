package com.gdp.model;

import java.util.Objects;

public class Country {

    private final String name;
    private final int gdp;

    public Country(String name, int gdp) {
        this.name = name;
        this.gdp = gdp;
    }

    public String getName() {
        return this.name;
    }

    public int getGdp() {
        return this.gdp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.gdp);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Country other = (Country) obj;
        return Objects.equals(this.name, other.name) &&
                Objects.equals(this.gdp, other.gdp);
    }

    @Override
    public String toString() {
        return "Country{" + "name=" + this.name + ", gdp=" + this.gdp + '}';
    }
    
}
