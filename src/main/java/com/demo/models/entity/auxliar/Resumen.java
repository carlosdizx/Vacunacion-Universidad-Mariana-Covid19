package com.demo.models.entity.auxliar;

public class Resumen
{
    private String etiqueta;

    private long cantidad;

    public Resumen(String etiqueta, long cantidad) {
        this.etiqueta = etiqueta;
        this.cantidad = cantidad;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
}
