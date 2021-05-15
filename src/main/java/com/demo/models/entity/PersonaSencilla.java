package com.demo.models.entity;

public class PersonaSencilla {
    private Long documento;

    private Tipo tipo;

    private Programa programa;

    private Estado estado;

    public PersonaSencilla(Long documento, Tipo tipo, Programa programa, Estado estado) {
        this.documento = documento;
        this.tipo = tipo;
        this.programa = programa;
        this.estado = estado;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
