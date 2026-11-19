package com.mimo.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "gato")
@PrimaryKeyJoinColumn(name = "id_animal")
public class Gato extends Animal {

    @Column(name = "raza", nullable = false, length = 100)
    private String raza;

    @Column(name = "test_leucemia")
    private Boolean testLeucemia;  // Puede ser null
    // Uso Boolean con mayúscula (no boolean) porque puede ser null, que significa
    // "todavía no se le ha hecho el test". Por eso no lleva nullable = false.

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
