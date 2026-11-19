package com.mimo.backend.model;

import com.mimo.backend.model.enums.TipoEspecie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "exotico")
@PrimaryKeyJoinColumn(name = "id_animal")
public class Exotico extends Animal {

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_especie", nullable = false, length = 10)
    private TipoEspecie tipoEspecie;

    @Column(name = "necesidades_clima", nullable = false, length = 255)
    private String necesidadesClima;

    public Exotico() {
    }

    public TipoEspecie getTipoEspecie() {
        return tipoEspecie;
    }

    public void setTipoEspecie(TipoEspecie tipoEspecie) {
        this.tipoEspecie = tipoEspecie;
    }

    public String getNecesidadesClima() {
        return necesidadesClima;
    }

    public void setNecesidadesClima(String necesidadesClima) {
        this.necesidadesClima = necesidadesClima;
    }
}
