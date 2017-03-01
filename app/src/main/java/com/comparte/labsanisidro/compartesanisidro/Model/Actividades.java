package com.comparte.labsanisidro.compartesanisidro.Model;

/**
 * Created by root on 13/02/17.
 */

public class Actividades {
    String id;
    String topico;
    String nombre;
    int puntuacion;
    String fecha;
    String imageUrl;

    public Actividades(String id, String topico, String nombre, int puntuacion, String fecha, String imageUrl) {
        this.id = id;
        this.topico = topico;
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
        this.imageUrl = imageUrl;
    }

    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
