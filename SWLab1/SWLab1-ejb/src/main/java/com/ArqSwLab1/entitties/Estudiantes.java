/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArqSwLab1.entitties;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John David Rodriguez
 */
@Entity
@Table(name = "ESTUDIANTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e")
    , @NamedQuery(name = "Estudiantes.findByEstudianteid", query = "SELECT e FROM Estudiantes e WHERE e.estudianteid = :estudianteid")
    , @NamedQuery(name = "Estudiantes.findByNombreestudiante", query = "SELECT e FROM Estudiantes e WHERE e.nombreestudiante = :nombreestudiante")
    , @NamedQuery(name = "Estudiantes.findByEmail", query = "SELECT e FROM Estudiantes e WHERE e.email = :email")
    , @NamedQuery(name = "Estudiantes.findByTelefono", query = "SELECT e FROM Estudiantes e WHERE e.telefono = :telefono")})
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTUDIANTEID")
    private Integer estudianteid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBREESTUDIANTE")
    private String nombreestudiante;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELEFONO")
    private String telefono;

    public Estudiantes() {
    }

    public Estudiantes(Integer estudianteid) {
        this.estudianteid = estudianteid;
    }

    public Estudiantes(Integer estudianteid, String nombreestudiante, String email, String telefono) {
        this.estudianteid = estudianteid;
        this.nombreestudiante = nombreestudiante;
        this.email = email;
        this.telefono = telefono;
    }

    public Integer getEstudianteid() {
        return estudianteid;
    }

    public void setEstudianteid(Integer estudianteid) {
        this.estudianteid = estudianteid;
    }

    public String getNombreestudiante() {
        return nombreestudiante;
    }

    public void setNombreestudiante(String nombreestudiante) {
        this.nombreestudiante = nombreestudiante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudianteid != null ? estudianteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.estudianteid == null && other.estudianteid != null) || (this.estudianteid != null && !this.estudianteid.equals(other.estudianteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ArqSwLab1.entitties.Estudiantes[ estudianteid=" + estudianteid + " ]";
    }
    
}
