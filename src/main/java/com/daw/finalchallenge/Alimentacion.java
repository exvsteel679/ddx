/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daw.finalchallenge;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Alumnado
 */
@Entity
@Table(name = "Alimentacion")
@NamedQueries({
    @NamedQuery(name = "Alimentacion.findAll", query = "SELECT a FROM Alimentacion a"),
    @NamedQuery(name = "Alimentacion.findByAlimentacion", query = "SELECT a FROM Alimentacion a WHERE a.alimentacion = :alimentacion"),
    @NamedQuery(name = "Alimentacion.findByDescripcion", query = "SELECT a FROM Alimentacion a WHERE a.descripcion = :descripcion")})
public class Alimentacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Alimentacion")
    private String alimentacion;
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany
    @JoinColumn (name="Alimentacion", referencedColumnName="Alimentacion")
    private List<Especies> especie;

    public Alimentacion() {
    }

    public Alimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public Alimentacion(String alimentacion, String descripcion) {
        this.alimentacion = alimentacion;
        this.descripcion = descripcion;
    }
    
    

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alimentacion != null ? alimentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimentacion)) {
            return false;
        }
        Alimentacion other = (Alimentacion) object;
        if ((this.alimentacion == null && other.alimentacion != null) || (this.alimentacion != null && !this.alimentacion.equals(other.alimentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.finalchallenge.Alimentacion[ alimentacion=" + alimentacion + " ]";
    }

    /**
     * @return the especie
     */
    public List<Especies> getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(List<Especies> especie) {
        this.especie = especie;
    }
    
}
