package com.mimo.backend.model;

import com.mimo.backend.model.enums.EstadoTransaccion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransaccionPago {

    private Long idTransaccion;
    private String tokenConfirmacion;    // Null mientras el pago no este completado
    private BigDecimal importe;

    private LocalDateTime fechaCobro;    // null hasta que se cobra
    private EstadoTransaccion estado;    // En la BBDD empieza en PENDIENTE

    private Persona persona;
    private Animal animal;

    public TransaccionPago() {
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getTokenConfirmacion() {
        return tokenConfirmacion;
    }

    public void setTokenConfirmacion(String tokenConfirmacion) {
        this.tokenConfirmacion = tokenConfirmacion;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public LocalDateTime getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(LocalDateTime fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public EstadoTransaccion getEstado() {
        return estado;
    }

    public void setEstado(EstadoTransaccion estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
