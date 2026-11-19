package com.mimo.backend.model;

import com.mimo.backend.model.enums.EstadoSolicitud;
import com.mimo.backend.model.enums.TipoTramite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "solicitud", uniqueConstraints = @UniqueConstraint(columnNames = {"id_persona", "id_animal", "tipo_tramite"}))
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Long idSolicitud;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", nullable = false)
    private Solicitante solicitante;
    // En la tabla la columna es id_persona (apunta a SOLICITANTE, no a PERSONA).
    // Un solicitante puede hacer muchas solicitudes: por eso es @ManyToOne desde aquí.

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_animal", nullable = false)
    private Animal animal;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_tramite", nullable = false, length = 10)
    private TipoTramite tipoTramite;
    // Con uniqueConstraints en @Table documento lo que ya exige la BBDD: no se puede repetir
    // la misma combinación persona + animal + tipo de trámite.

    @CreationTimestamp
    @Column(name = "fecha_solicitud", nullable = false, updatable = false)
    private LocalDateTime fechaSolicitud;       // La rellena Hibernate al guardar (@CreationTimestamp)

    @Column(name = "porcentaje_compatibilidad", nullable = false)
    private int porcentajeCompatibilidad;       // De 0 a 100

    @Column(name = "motivos_compatibilidad", nullable = false, columnDefinition = "TEXT")
    private String motivosCompatibilidad;

    @Column(name = "id_referencia_salesforce", length = 18, unique = true)
    private String idReferenciaSalesforce;      // Puede ser null

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_solicitud", nullable = false, length = 10)
    private EstadoSolicitud estadoSolicitud = EstadoSolicitud.PENDIENTE;    // Empieza en PENDIENTE
    // Lo inicializo aquí porque Hibernate manda null si no hay valor y la columna es NOT NULL.

    @Column(name = "fecha_sincronizacion")
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
