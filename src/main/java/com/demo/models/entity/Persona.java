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
    private List<Eps> epss;

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

    public List<Eps> getEpss() {
        return epss;
    }

    public void setEpss(List<Eps> epss) {
        this.epss = epss;
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
}