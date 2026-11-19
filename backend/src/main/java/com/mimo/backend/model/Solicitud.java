package com.mimo.backend.model;

import com.mimo.backend.model.enums.EstadoSolicitud;
import com.mimo.backend.model.enums.TipoTramite;

import java.time.LocalDateTime;

public class Solicitud {

    private Long idSolicitud;
    private Solicitante solicitante;

    private Animal animal;
    private TipoTramite tipoTramite;

    private LocalDateTime fechaSolicitud;       // La BBDD la pone sola
    private int porcentajeCompatibilidad;       // De 0 a 100
    private String motivosCompatibilidad;
    private String idReferenciaSalesforce;      // Puede ser null
    private EstadoSolicitud estadoSolicitud;    // En la BBDD empieza en PENDIENTE
    private LocalDateTime fechaSincronizacion;  // Puede ser null

    public Solicitud() {
    }

    public Long getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public int getPorcentajeCompatibilidad() {
        return porcentajeCompatibilidad;
    }

    public void setPorcentajeCompatibilidad(int porcentajeCompatibilidad) {
        this.porcentajeCompatibilidad = porcentajeCompatibilidad;
    }

    public String getMotivosCompatibilidad() {
        return motivosCompatibilidad;
    }

    public void setMotivosCompatibilidad(String motivosCompatibilidad) {
        this.motivosCompatibilidad = motivosCompatibilidad;
    }

    public String getIdReferenciaSalesforce() {
        return idReferenciaSalesforce;
    }

    public void setIdReferenciaSalesforce(String idReferenciaSalesforce) {
        this.idReferenciaSalesforce = idReferenciaSalesforce;
    }

    public EstadoSolicitud getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public LocalDateTime getFechaSincronizacion() {
        return fechaSincronizacion;
    }

    public void setFechaSincronizacion(LocalDateTime fechaSincronizacion) {
        this.fechaSincronizacion = fechaSincronizacion;
    }
}
