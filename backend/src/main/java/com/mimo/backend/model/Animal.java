package com.mimo.backend.model;

import com.mimo.backend.model.enums.EstadoAnimal;
import com.mimo.backend.model.enums.Nivel;
import com.mimo.backend.model.enums.Sexo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Animal {

    private Long idAnimal;
    private String nombre;
    private LocalDate fechaNacimiento;
    private Sexo sexo;
    private boolean esterilizado;
    private String descripcion;
    private Nivel sociabilidad;
    private Nivel nivelEnergia;
    // sociabilidad y nivelEnergia usan el mismo enum.

    private boolean tieneEnfermedad;
    private String enfermedad;
    // Solo tiene valor si tieneEnfermedad es true; si no, null.

    private EstadoAnimal estado;
    // En la BBDD empieza en DISPONIBLE por defecto.

    private LocalDate fechaIngreso;
    private boolean esUrgente;
    private String idReferenciaSalesforce;    // Puede ser null
    private LocalDateTime fechaSincronizacion; // Puede ser null (aún no sincronizado)
    private String fotoUrl;

    private CentroAdopcion centroAdopcion;

    public Animal() {
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public boolean isEsterilizado() {
        return esterilizado;
    }

    public void setEsterilizado(boolean esterilizado) {
        this.esterilizado = esterilizado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Nivel getSociabilidad() {
        return sociabilidad;
    }

    public void setSociabilidad(Nivel sociabilidad) {
        this.sociabilidad = sociabilidad;
    }

    public Nivel getNivelEnergia() {
        return nivelEnergia;
    }

    public void setNivelEnergia(Nivel nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }

    public boolean isTieneEnfermedad() {
        return tieneEnfermedad;
    }

    public void setTieneEnfermedad(boolean tieneEnfermedad) {
        this.tieneEnfermedad = tieneEnfermedad;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public EstadoAnimal getEstado() {
        return estado;
    }

    public void setEstado(EstadoAnimal estado) {
        this.estado = estado;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isEsUrgente() {
        return esUrgente;
    }

    public void setEsUrgente(boolean esUrgente) {
        this.esUrgente = esUrgente;
    }

    public String getIdReferenciaSalesforce() {
        return idReferenciaSalesforce;
    }

    public void setIdReferenciaSalesforce(String idReferenciaSalesforce) {
        this.idReferenciaSalesforce = idReferenciaSalesforce;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public LocalDateTime getFechaSincronizacion() {
        return fechaSincronizacion;
    }

    public void setFechaSincronizacion(LocalDateTime fechaSincronizacion) {
        this.fechaSincronizacion = fechaSincronizacion;
    }

    public CentroAdopcion getCentroAdopcion() {
        return centroAdopcion;
    }

    public void setCentroAdopcion(CentroAdopcion centroAdopcion) {
        this.centroAdopcion = centroAdopcion;
    }
}
