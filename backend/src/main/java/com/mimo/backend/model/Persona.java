package com.mimo.backend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Persona {

    private Long idPersona;
    // Long con mayúscula porque puede valer null; un long no puede (Al guardar en la BBDD no tiene id).

    private String nombre;
    private String apellido1;
    private String apellido2;      // opcional: en la tabla permite NULL
    private String dni;
    private String email;
    private LocalDate fechaNacimiento;        // solo fecha (sin hora)
    private LocalDateTime fechaAltaCuenta;    // La BBDD la pone sola, no hay que rellenarla

    private String telefono1;
    private String telefono2;      // opcional
    private String passwordHash;

    private Direccion direccion;

    public Persona() {
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDateTime getFechaAltaCuenta() {
        return fechaAltaCuenta;
    }

    public void setFechaAltaCuenta(LocalDateTime fechaAltaCuenta) {
        this.fechaAltaCuenta = fechaAltaCuenta;
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
