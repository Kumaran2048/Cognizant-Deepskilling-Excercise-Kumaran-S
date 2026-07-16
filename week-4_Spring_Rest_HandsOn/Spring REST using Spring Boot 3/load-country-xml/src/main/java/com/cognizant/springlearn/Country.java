package com.cognizant.springlearn;

public class Country {

    private String code;
    private String name;

    public Country() {
        System.out.println("Inside Country Constructor");
    }

    public String getCode() {
        System.out.println("Inside getCode() method");
        return code;
    }

    public void setCode(String code) {
        System.out.println("Inside setCode() method");
        this.code = code;
    }

    public String getName() {
        System.out.println("Inside getName() method");
        return name;
    }

    public void setName(String name) {
        System.out.println("Inside setName() method");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}