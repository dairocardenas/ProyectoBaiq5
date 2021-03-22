/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dairo
 */
@Entity
@Table(name = "soporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soporte.findAll", query = "SELECT s FROM Soporte s")})
public class Soporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_soporte")
    private Integer idsoporte;
    @Column(name = "Sueldo")
    private Integer sueldo;
    @OneToMany(mappedBy = "idsoporte", fetch = FetchType.LAZY)
    private Collection<OrdenServicio> ordenServicioCollection;
    @JoinColumn(name = "Id_rol", referencedColumnName = "Id_rol")
    @ManyToOne(fetch = FetchType.LAZY)
    private Rol idrol;
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario idusuario;

    public Soporte() {
    }

    public Soporte(Integer idsoporte) {
        this.idsoporte = idsoporte;
    }

    public Integer getIdsoporte() {
        return idsoporte;
    }

    public void setIdsoporte(Integer idsoporte) {
        this.idsoporte = idsoporte;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    @XmlTransient
    public Collection<OrdenServicio> getOrdenServicioCollection() {
        return ordenServicioCollection;
    }

    public void setOrdenServicioCollection(Collection<OrdenServicio> ordenServicioCollection) {
        this.ordenServicioCollection = ordenServicioCollection;
    }

    public Rol getIdrol() {
        return idrol;
    }

    public void setIdrol(Rol idrol) {
        this.idrol = idrol;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsoporte != null ? idsoporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soporte)) {
            return false;
        }
        Soporte other = (Soporte) object;
        if ((this.idsoporte == null && other.idsoporte != null) || (this.idsoporte != null && !this.idsoporte.equals(other.idsoporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.proyectobaiq5.entity.Soporte[ idsoporte=" + idsoporte + " ]";
    }
    
}
