package com.demo.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long documento;

    @Column(nullable = false)
    private String nombre;

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

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "eps_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Eps eps;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "estado_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    public Estado estado;

    public Persona() {
    }


}