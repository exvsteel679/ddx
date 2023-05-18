/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daw.finalchallenge;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Alumnado
 */
@Entity
@Table(name = "Especies")
@NamedQueries({
    @NamedQuery(name = "Especies.findAll", query = "SELECT e FROM Especies e"),
    @NamedQuery(name = "Especies.findByNombre", query = "SELECT e FROM Especies e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Especies.findByFamilia", query = "SELECT e FROM Especies e WHERE e.familia = :familia"),
    @NamedQuery(name = "Especies.findByAlimentacion", query = "SELECT e FROM Especies e WHERE e.alimentacion = :alimentacion"),
    @NamedQuery(name = "Especies.findByTipo", query = "SELECT e FROM Especies e WHERE e.tipo = :tipo")})
public class Especies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Familia")
    private String familia;
    @Basic(optional=false)
    @Column(name = "Alimentacion")
    private String alimentacion;
    @Basic(optional = false)
    @Column(name = "Tipo")
    private String tipo;
    @ManyToOne
    @JoinColumn(name = "Alimentacion", referencedColumnName = "Alimentacion", insertable=false, updatable=false)
    private Alimentacion alimento;


    public Especies() {
    }

    public Especies(String nombre) {
        this.nombre = nombre;
    }

    public Especies(String nombre,String alimentacion, String tipo) {
        this.nombre = nombre;
        this.alimentacion = alimentacion;
        this.tipo = tipo;
    }
    public Especies(String nombre, String familia, String alimentacion, String tipo){
        this.nombre= nombre;
        this.familia=familia;
        this.alimentacion=alimentacion;
        this.tipo=tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especies)) {
            return false;
        }
        Especies other = (Especies) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.finalchallenge.Especies[ nombre=" + nombre + " ]";
    }

    /**
     * @return the alimento
     */
    public Alimentacion getAlimento() {
        return alimento;
    }

    /**
     * @param alimento the alimento to set
     */
    public void setAlimento(Alimentacion alimento) {
        this.alimento = alimento;
    }
    
}
