/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArqSwLab1.entitties;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John David Rodriguez
 */
@Entity
@Table(name = "CEREMONIAGRADOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ceremoniagrados.findAll", query = "SELECT c FROM Ceremoniagrados c")
    , @NamedQuery(name = "Ceremoniagrados.findByCeremoniagradoid", query = "SELECT c FROM Ceremoniagrados c WHERE c.ceremoniagradoid = :ceremoniagradoid")
    , @NamedQuery(name = "Ceremoniagrados.findByFechaceremonia", query = "SELECT c FROM Ceremoniagrados c WHERE c.fechaceremonia = :fechaceremonia")
    , @NamedQuery(name = "Ceremoniagrados.findByLimiteinscripcion", query = "SELECT c FROM Ceremoniagrados c WHERE c.limiteinscripcion = :limiteinscripcion")
    , @NamedQuery(name = "Ceremoniagrados.findByLugar", query = "SELECT c FROM Ceremoniagrados c WHERE c.lugar = :lugar")})
public class Ceremoniagrados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEREMONIAGRADOID")
    private Integer ceremoniagradoid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACEREMONIA")
    @Temporal(TemporalType.DATE)
    private Date fechaceremonia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LIMITEINSCRIPCION")
    @Temporal(TemporalType.DATE)
    private Date limiteinscripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LUGAR")
    private String lugar;

    public Ceremoniagrados() {
    }

    public Ceremoniagrados(Integer ceremoniagradoid) {
        this.ceremoniagradoid = ceremoniagradoid;
    }

    public Ceremoniagrados(Integer ceremoniagradoid, Date fechaceremonia, Date limiteinscripcion, String lugar) {
        this.ceremoniagradoid = ceremoniagradoid;
        this.fechaceremonia = fechaceremonia;
        this.limiteinscripcion = limiteinscripcion;
        this.lugar = lugar;
    }

    public Integer getCeremoniagradoid() {
        return ceremoniagradoid;
    }

    public void setCeremoniagradoid(Integer ceremoniagradoid) {
        this.ceremoniagradoid = ceremoniagradoid;
    }

    public Date getFechaceremonia() {
        return fechaceremonia;
    }

    public void setFechaceremonia(Date fechaceremonia) {
        this.fechaceremonia = fechaceremonia;
    }

    public Date getLimiteinscripcion() {
        return limiteinscripcion;
    }

    public void setLimiteinscripcion(Date limiteinscripcion) {
        this.limiteinscripcion = limiteinscripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ceremoniagradoid != null ? ceremoniagradoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ceremoniagrados)) {
            return false;
        }
        Ceremoniagrados other = (Ceremoniagrados) object;
        if ((this.ceremoniagradoid == null && other.ceremoniagradoid != null) || (this.ceremoniagradoid != null && !this.ceremoniagradoid.equals(other.ceremoniagradoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ArqSwLab1.entitties.Ceremoniagrados[ ceremoniagradoid=" + ceremoniagradoid + " ]";
    }
    
}
