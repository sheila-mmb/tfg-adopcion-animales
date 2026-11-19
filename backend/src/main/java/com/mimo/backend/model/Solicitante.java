package com.mimo.backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "solicitante")
public class Solicitante {

    @Id
    @Column(name = "id_persona")
    private Long idPersona;
    // La clave primaria de SOLICITANTE es id_persona (la misma que la de su Persona).
    // No se genera aquí: se copia de la persona gracias a @MapsId (ver más abajo).

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "id_persona")
    private Persona persona;
    // @OneToOne: un solicitante es exactamente una persona.
    // @MapsId: "el id de este solicitante es el id de esa persona".
    // LAZY: no cargo la Persona de la BBDD hasta que de verdad la pido (más eficiente).

    @Column(name = "id_referencia_salesforce", length = 18, unique = true)
    private String idReferenciaSalesforce;     // Puede ser null

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_cuestionario", nullable = false, unique = true)
    private Cuestionario cuestionario;
    // cascade PERSIST y MERGE: al guardar el solicitante, se guarda también su cuestionario.
    // NO pongo REMOVE a propósito: al borrar un solicitante, el trigger de Postgres
    // ya borra su cuestionario, y si Hibernate lo intentara también daría error.

    public Solicitante() {
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getIdReferenciaSalesforce() {
        return idReferenciaSalesforce;
    }

    public void setIdReferenciaSalesforce(String idReferenciaSalesforce) {
        this.idReferenciaSalesforce = idReferenciaSalesforce;
    }

    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }
}
