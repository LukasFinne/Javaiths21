package se.iths.java21.lab2v2;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {
    FÄRSKVAROR("Färskvaror"),
    FRUKT("Frukt"),
    GRÖNSAKER("Grönsaker"),
    MEJERI("Mejeri"),
    TORRVAROR("Torrvaror");

    private String name;

    @JsonValue
    public String getName() {
        return name;
    }

    Category(String name) {
        this.name = name;
    }
}
