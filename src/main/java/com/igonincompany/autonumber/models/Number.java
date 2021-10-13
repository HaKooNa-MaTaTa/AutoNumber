package com.igonincompany.autonumber.models;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Number {
    private static Number instance;
    public static final String REGION = " 116 RUS";
    private String number;
    private Set<String> numbers = new HashSet<>();


    private Number() {};
    public static Number getInstance() {
        if (instance == null) {
            instance = new Number();
        }
        return instance;
    }
}
