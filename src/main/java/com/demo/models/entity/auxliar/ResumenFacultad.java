package com.demo.models.entity.auxliar;

public class ResumenFacultad
{
    private String tipo;
    private long cantidad;
    private String programa;
    private String facultad;

    public ResumenFacultad(String tipo, long cantidad, String programa, String facultad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.programa = programa;
        this.facultad = facultad;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String value) { this.tipo = value; }

    public long getCantidad() { return cantidad; }
    public void setCantidad(long value) { this.cantidad = value; }

    public String getPrograma() { return programa; }
    public void setPrograma(String value) { this.programa = value; }

    public String getFacultad() { return facultad; }
    public void setFacultad(String value) { this.facultad = value; }
}
