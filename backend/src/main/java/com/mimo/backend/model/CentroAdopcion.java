package com.mimo.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "centro_adopcion")
public class CentroAdopcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_centro_adopcion")
    private Long idCentroAdopcion;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Embedded
    private Direccion direccion;

    @Column(name = "email_contacto", nullable = false, length = 254, unique = true)
    private String emailContacto;

    @Column(name = "telefono1", nullable = false, length = 20)
    private String telefono1;

    @Column(name = "telefono2", length = 20)
    private String telefono2;                 // opcional

    @Column(name = "id_referencia_salesforce", length = 18, unique = true)
    private String idReferenciaSalesforce;    // opcional (null si no está sincronizado)

    public CentroAdopcion() {
    }

    public Long getIdCentroAdopcion() {
        return idCentroAdopcion;
    }

    public void setIdCentroAdopcion(Long idCentroAdopcion) {
        this.idCentroAdopcion = idCentroAdopcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getIdReferenciaSalesforce() {
        return idReferenciaSalesforce;
    }

    public void setIdReferenciaSalesforce(String idReferenciaSalesforce) {
        this.idReferenciaSalesforce = idReferenciaSalesforce;
    }
}
