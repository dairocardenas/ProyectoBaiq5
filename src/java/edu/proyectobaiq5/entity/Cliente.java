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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_cliente")
    private Integer idcliente;
    @OneToMany(mappedBy = "idcliente", fetch = FetchType.LAZY)
    private Collection<OrdenServicio> ordenServicioCollection;
    @OneToMany(mappedBy = "idcliente", fetch = FetchType.LAZY)
    private Collection<Venta> ventaCollection;
    @OneToMany(mappedBy = "idcliente", fetch = FetchType.LAZY)
    private Collection<Fidelizacion> fidelizacionCollection;
    @JoinColumn(name = "Id_tarjeta_puntos", referencedColumnName = "Id_tarjeta_puntos")
    @ManyToOne(fetch = FetchType.LAZY)
    private TarjetaPuntos idtarjetapuntos;
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario idusuario;

    public Cliente() {
    }

    public Cliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    @XmlTransient
    public Collection<OrdenServicio> getOrdenServicioCollection() {
        return ordenServicioCollection;
    }

    public void setOrdenServicioCollection(Collection<OrdenServicio> ordenServicioCollection) {
        this.ordenServicioCollection = ordenServicioCollection;
    }

    @XmlTransient
    public Collection<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(Collection<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
    }

    @XmlTransient
    public Collection<Fidelizacion> getFidelizacionCollection() {
        return fidelizacionCollection;
    }

    public void setFidelizacionCollection(Collection<Fidelizacion> fidelizacionCollection) {
        this.fidelizacionCollection = fidelizacionCollection;
    }

    public TarjetaPuntos getIdtarjetapuntos() {
        return idtarjetapuntos;
    }

    public void setIdtarjetapuntos(TarjetaPuntos idtarjetapuntos) {
        this.idtarjetapuntos = idtarjetapuntos;
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
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.proyectobaiq5.entity.Cliente[ idcliente=" + idcliente + " ]";
    }
    
}
