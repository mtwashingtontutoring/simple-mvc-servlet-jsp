package com.example.simple_mvc.models;

import java.time.LocalDate;

public class Model {
    private Integer param1;
    private Character param2;
    private LocalDate param3;
    private String param4;

    public Model() {
    }

    public Model(Integer param1, Character param2, LocalDate param3, String param4) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
    }

    public Integer getParam1() {
        return param1;
    }

    public void setParam1(Integer param1) {
        this.param1 = param1;
    }

    public Character getParam2() {
        return param2;
    }

    public void setParam2(Character param2) {
        this.param2 = param2;
    }

    public LocalDate getParam3() {
        return param3;
    }

    public void setParam3(LocalDate param3) {
        this.param3 = param3;
    }

    public String getParam4() {
        return param4;
    }

    public void setParam4(String param4) {
        this.param4 = param4;
    }
}
