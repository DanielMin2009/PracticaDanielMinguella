package com.daniel.projectedanielminguella.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "pelicula")
public class Pelicula {

    @PrimaryKey
    @NonNull
    private String id;
    private String titol;
    private String descripcio;
    private int any;
    private int puntuacio;
    private String imatge;


    public Pelicula() {
        id = UUID.randomUUID().toString();
    }

    public Pelicula(String titol, String descripcio, int any, int puntuacio, String imatge) {
        id = UUID.randomUUID().toString();
        this.titol = titol;
        this.descripcio = descripcio;
        this.any = any;
        this.puntuacio = puntuacio;
        this.imatge = imatge;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }
}
