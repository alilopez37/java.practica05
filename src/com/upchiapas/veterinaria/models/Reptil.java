package com.upchiapas.veterinaria.models;

import java.time.LocalDate;

public class Reptil extends Mascota{
    private String tipoPiel;
    public Reptil(int id, String nombre, LocalDate fechaNacimiento) {
        super(nombre, fechaNacimiento);
    }

    public String getTipoPiel() {
        return tipoPiel;
    }

    public void setTipoPiel(String tipoPiel) {
        this.tipoPiel = tipoPiel;
    }
}
