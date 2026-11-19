package com.mimo.backend.model;

import com.mimo.backend.model.enums.Tamano;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "perro")
@PrimaryKeyJoinColumn(name = "id_animal")
public class Perro extends Animal {

    // Perro tiene su propia tabla (perro), unida a animal por id_animal.
    // No repito el id aquí: lo heredo de Animal (por eso @PrimaryKeyJoinColumn).
    // Con "extends Animal" ya tengo nombre, sexo, estado... y aquí solo añado lo propio del perro.

    @Column(name = "raza", nullable = false, length = 100)
    private String raza;

    @Enumerated(EnumType.STRING)
    @Column(name = "tamano", nullable = false, length = 10)
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
