package com.mimo.backend.model;

import java.time.LocalDateTime;

public class Favorito {

    private Long idFavorito;
    private Persona persona;
    private Animal animal;
    // Favorito es la tabla "puente" entre Persona y Animal: una persona puede marcar
    // muchos animales y un animal puede estar en los favoritos de muchas personas.
    // La BBDD no deja marcar el mismo animal dos veces a la misma persona.

    private LocalDateTime fechaMarcado;    // La BBDD la pone sola

    public Favorito() {
    }

    public Long getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(Long idFavorito) {
        this.idFavorito = idFavorito;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LocalDateTime getFechaMarcado() {
        return fechaMarcado;
    }

    public void setFechaMarcado(LocalDateTime fechaMarcado) {
        this.fechaMarcado = fechaMarcado;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
