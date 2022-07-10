package com.upchiapas.veterinaria.models;

import java.time.LocalDate;

public class Mascota {
    private static int index = 0;
    protected int id;
    protected String nombre;
    protected LocalDate fechaNacimiento;

    public Mascota(String nombre, LocalDate fechaNacimiento) {
        index++;
        this.id = index;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
