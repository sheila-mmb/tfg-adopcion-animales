package com.mimo.backend.model;

import com.mimo.backend.model.enums.EstadoTransaccion;

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

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaccion_pago")
public class TransaccionPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Long idTransaccion;

    @Column(name = "token_confirmacion", length = 100, unique = true)
    private String tokenConfirmacion;    // Null mientras el pago no este completado
    // Sin nullable = false porque al crear el pago todavía no tiene token.
    // La BBDD obliga a que lo tenga (y a que haya fechaCobro) cuando el estado pasa a COMPLETADO.

    @Column(name = "importe", nullable = false, precision = 10, scale = 2)
    private BigDecimal importe;
    // precision = 10 y scale = 2: hasta 10 cifras en total, 2 de ellas decimales (NUMERIC(10,2)).

    @Column(name = "fecha_cobro")
    private LocalDateTime fechaCobro;    // null hasta que se cobra

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 15)
    private EstadoTransaccion estado = EstadoTransaccion.PENDIENTE;    // Empieza en PENDIENTE
    // Lo inicializo aquí por lo mismo que en Solicitud: si no, Hibernate mandaría null.

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;
    // Apunta a Persona (no a Solicitante): para donar no hace falta haber rellenado el cuestionario.

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_animal", nullable = false)
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
