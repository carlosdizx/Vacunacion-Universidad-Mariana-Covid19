package com.demo.models.entity;

public class PersonaSencilla {
    private Long documento;

    private String tipo;

    private String programa;

    private String estado;

    public PersonaSencilla(Long documento, String tipo, String programa, String estado) {
        this.documento = documento;
        this.tipo = tipo;
        this.programa = programa;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "PersonaSencilla{" +
                "documento=" + documento +
                ", tipo='" + tipo + '\'' +
                ", programa='" + programa + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
