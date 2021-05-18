package com.demo.models.entity;

public class ResumenTipo {

    private long cantidad;

    private String estado;

    private String tipo;

    public ResumenTipo(long cantidad, String estado, String tipo) {
        this.cantidad = cantidad;
        this.estado = estado;
        this.tipo = tipo;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
