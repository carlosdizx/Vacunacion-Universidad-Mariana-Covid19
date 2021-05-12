package com.demo.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "facultades")
public class Facultad implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    /**
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "facugrama",
            joinColumns = @JoinColumn(name = "facultad_id"),inverseJoinColumns = @JoinColumn(name = "programa_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"facultad_id","programa_id"})})
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
