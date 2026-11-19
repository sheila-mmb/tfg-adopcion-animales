package com.mimo.backend.model;

import com.mimo.backend.model.enums.Tamano;

public class Perro extends Animal {

    private String raza;
    private Tamano tamano;

    public Perro() {
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Tamano getTamano() {
        return tamano;
    }

    public void setTamano(Tamano tamano) {
        this.tamano = tamano;
    }
}
