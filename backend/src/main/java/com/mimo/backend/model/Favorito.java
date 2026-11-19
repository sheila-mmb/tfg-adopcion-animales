package com.mimo.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "favorito", uniqueConstraints = @UniqueConstraint(columnNames = {"id_persona", "id_animal"}))
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favorito")
    private Long idFavorito;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_animal", nullable = false)
    private Animal animal;
    // Favorito es la tabla "puente" entre Persona y Animal: una persona puede marcar
    // muchos animales y un animal puede estar en los favoritos de muchas personas.
    // Lo resuelvo con dos @ManyToOne (uno hacia Persona y otro hacia Animal).
    // Con uniqueConstraints en @Table documento que la BBDD no deja marcar el mismo animal dos veces a la misma persona.

    @CreationTimestamp
    @Column(name = "fecha_marcado", nullable = false, updatable = false)
    private LocalDateTime fechaMarcado;    // La rellena Hibernate al guardar (@CreationTimestamp)

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
