package com.mimo.backend.model;

import com.mimo.backend.model.enums.EstadoAnimal;
import com.mimo.backend.model.enums.Nivel;
import com.mimo.backend.model.enums.Sexo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_animal")
    private Long idAnimal;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false, length = 10)
    private Sexo sexo;

    @Column(name = "esterilizado", nullable = false)
    private boolean esterilizado;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;
    // columnDefinition = "TEXT": en la tabla es TEXT (texto largo), no un VARCHAR(255) normal.

    @Enumerated(EnumType.STRING)
    @Column(name = "sociabilidad", nullable = false, length = 10)
    private Nivel sociabilidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_energia", nullable = false, length = 10)
    private Nivel nivelEnergia;
    // sociabilidad y nivelEnergia usan el mismo enum (Nivel): ALTO, MEDIO o BAJO.

    @Column(name = "tiene_enfermedad", nullable = false)
    private boolean tieneEnfermedad;

    @Column(name = "enfermedad", length = 500)
    private String enfermedad;
    // Solo tiene valor si tieneEnfermedad es true; si no, null (lo exige un CHECK de la tabla).

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoAnimal estado = EstadoAnimal.DISPONIBLE;
    // Empieza en DISPONIBLE. Lo pongo aquí a mano porque Hibernate manda null si no hay valor
    // y el DEFAULT de la BBDD no se aplicaría (la columna es NOT NULL).

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;
    // Esta sí hay que rellenarla desde Java: la tabla no tiene valor por defecto.

    @Column(name = "es_urgente", nullable = false)
    private boolean esUrgente;

    @Column(name = "id_referencia_salesforce", length = 18, unique = true)
    private String idReferenciaSalesforce;    // Puede ser null

    @Column(name = "fecha_sincronizacion")
    private LocalDateTime fechaSincronizacion; // Puede ser null (aún no sincronizado)

    @Column(name = "foto_url", nullable = false, length = 500)
    private String fotoUrl;
    // Guardo la URL de la foto, no la imagen en sí.

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_centro_adopcion", nullable = false)
    private CentroAdopcion centroAdopcion;
    // @ManyToOne: muchos animales pertenecen a un mismo centro. Es el lado "muchos",
    // y por eso es el que lleva la columna id_centro_adopcion (la clave foránea).

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
