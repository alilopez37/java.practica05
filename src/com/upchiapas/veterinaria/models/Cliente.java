package com.upchiapas.veterinaria.models;

import java.util.ArrayList;

public class Cliente {
    private static int index = 0;
    private int id;
    private String nombre;
    private ArrayList<Mascota> listaMascotas = new ArrayList<>();

    public Cliente(String nombre) {
        index++;
        this.id = index;
        this.nombre = nombre;
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

    public boolean addMascota(Mascota mascota){
        return listaMascotas.add(mascota);
    }

    public Mascota getFirstPet(){
        Mascota mascota = null;
        if (!listaMascotas.isEmpty())
            mascota = listaMascotas.get(0);
        return mascota;
    }

    public ArrayList<Mascota> getPets(){
        return listaMascotas;
    }
}
