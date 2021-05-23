package com.demo.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long documento;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private String sangre;

    @Column(nullable = false,unique = true)
    private String correo;

    @Column(nullable = false)
    private long celular;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "tipo_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Tipo tipo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "convenios",
    joinColumns = @JoinColumn(name = "persona_id"),inverseJoinColumns = @JoinColumn(name = "eps_id"),
    uniqueConstraints = {@UniqueConstraint(columnNames = {"persona_id","eps_id"})})
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<Eps> eps;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "controles",
            joinColumns = @JoinColumn(name = "persona_id"),inverseJoinColumns = @JoinColumn(name = "control_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"persona_id","control_id"})})
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<Dosis> dosis;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "estado_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "programa_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Programa programa;

    public Persona() {
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSangre() {
        return sangre;
    }

    public void setSangre(String sangre) {
        this.sangre = sangre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<Eps> getEps() {
        return eps;
    }

    public void setEps(List<Eps> eps) {
        this.eps = eps;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public List<Dosis> getDosis() {
        return dosis;
    }

    public void setDosis(List<Dosis> dosis) {
        this.dosis = dosis;
    }

    public static class PersonaSencilla {
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
}