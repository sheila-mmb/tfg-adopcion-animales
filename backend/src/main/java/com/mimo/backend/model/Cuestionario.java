package com.mimo.backend.model;

import com.mimo.backend.model.enums.TipoVivienda;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "cuestionario")
public class Cuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuestionario")
    private Long idCuestionario;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;
    // La rellena Hibernate al crear y al modificar (@UpdateTimestamp).
    // El trigger de Postgres (trg_cuestionario_fecha_actualizacion) hace lo mismo en cada UPDATE y no estorba.

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_vivienda", nullable = false, length = 20)
    private TipoVivienda tipoVivienda;

    @Column(name = "horas_solo", nullable = false)
    private int horasSolo;

    @Column(name = "tiene_otros_animales", nullable = false)
    private boolean tieneOtrosAnimales;

    @Column(name = "acepta_animal_enfermedad", nullable = false)
    private boolean aceptaAnimalEnfermedad;

    @Column(name = "cerca_zonas_verdes", nullable = false)
    private boolean cercaZonasVerdes;
    // Aquí uso int y boolean en minúscula porque en la tabla son NOT NULL: siempre tienen valor, nunca null.

    public Cuestionario() {
    }

    public Long getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(Long idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public TipoVivienda getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(TipoVivienda tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public int getHorasSolo() {
        return horasSolo;
    }

    public void setHorasSolo(int horasSolo) {
        this.horasSolo = horasSolo;
    }

    public boolean isTieneOtrosAnimales() {
        return tieneOtrosAnimales;
    }

    public void setTieneOtrosAnimales(boolean tieneOtrosAnimales) {
        this.tieneOtrosAnimales = tieneOtrosAnimales;
    }

    public boolean isAceptaAnimalEnfermedad() {
        return aceptaAnimalEnfermedad;
    }

    public void setAceptaAnimalEnfermedad(boolean aceptaAnimalEnfermedad) {
        this.aceptaAnimalEnfermedad = aceptaAnimalEnfermedad;
    }

    public boolean isCercaZonasVerdes() {
        return cercaZonasVerdes;
    }

    public void setCercaZonasVerdes(boolean cercaZonasVerdes) {
        this.cercaZonasVerdes = cercaZonasVerdes;
    }
}
