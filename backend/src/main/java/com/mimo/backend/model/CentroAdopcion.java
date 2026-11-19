package com.mimo.backend.model;

public class CentroAdopcion {

    private Long idCentroAdopcion;
    private String nombre;
    private Direccion direccion;
    private String emailContacto;
    private String telefono1;
    private String telefono2;                 // opcional
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
