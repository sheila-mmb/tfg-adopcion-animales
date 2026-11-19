package com.mimo.backend.model;

import com.mimo.backend.model.enums.TipoVivienda;

import java.time.LocalDateTime;

public class Cuestionario {

    private Long idCuestionario;
    private LocalDateTime fechaActualizacion;
    // Se actualiza sola: hay un trigger en Postgres (trg_cuestionario_fecha_actualizacion)
    // que la cambia en cada UPDATE. Desde Java no la tocamos.

    private TipoVivienda tipoVivienda;
    private int horasSolo;
    private boolean tieneOtrosAnimales;
    private boolean aceptaAnimalEnfermedad;
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
