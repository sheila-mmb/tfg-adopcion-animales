package com.mimo.backend.model;

public class Gato extends Animal {

    private String raza;
    private Boolean testLeucemia;  // Puede ser null

    public Gato() {
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Boolean getTestLeucemia() {
        return testLeucemia;
    }

    public void setTestLeucemia(Boolean testLeucemia) {
        this.testLeucemia = testLeucemia;
    }
}
