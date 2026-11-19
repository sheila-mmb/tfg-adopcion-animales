package com.mimo.backend.model;

import com.mimo.backend.model.enums.TipoEspecie;

public class Exotico extends Animal {

    private TipoEspecie tipoEspecie;
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
