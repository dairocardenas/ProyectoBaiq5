/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dairo
 */
@Entity
@Table(name = "orden_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenPago.findAll", query = "SELECT o FROM OrdenPago o")})
public class OrdenPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_OrdenPago")
    private Integer idOrdenPago;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "Id_OrdenServicio", referencedColumnName = "Id_OrdenServicio")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrdenServicio idOrdenServicio;
    @JoinColumn(name = "Id_venta", referencedColumnName = "Id_venta")
    @ManyToOne(fetch = FetchType.LAZY)
    private Venta idventa;
    @OneToMany(mappedBy = "idOrdenPago", fetch = FetchType.LAZY)
    private Collection<DetalleOrdenPago> detalleOrdenPagoCollection;

    public OrdenPago() {
    }

    public OrdenPago(Integer idOrdenPago) {
        this.idOrdenPago = idOrdenPago;
    }

    public Integer getIdOrdenPago() {
        return idOrdenPago;
    }

    public void setIdOrdenPago(Integer idOrdenPago) {
        this.idOrdenPago = idOrdenPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public OrdenServicio getIdOrdenServicio() {
        return idOrdenServicio;
    }

    public void setIdOrdenServicio(OrdenServicio idOrdenServicio) {
        this.idOrdenServicio = idOrdenServicio;
    }

    public Venta getIdventa() {
        return idventa;
    }

    public void setIdventa(Venta idventa) {
        this.idventa = idventa;
    }

    @XmlTransient
    public Collection<DetalleOrdenPago> getDetalleOrdenPagoCollection() {
        return detalleOrdenPagoCollection;
    }

    public void setDetalleOrdenPagoCollection(Collection<DetalleOrdenPago> detalleOrdenPagoCollection) {
        this.detalleOrdenPagoCollection = detalleOrdenPagoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenPago != null ? idOrdenPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenPago)) {
            return false;
        }
        OrdenPago other = (OrdenPago) object;
        if ((this.idOrdenPago == null && other.idOrdenPago != null) || (this.idOrdenPago != null && !this.idOrdenPago.equals(other.idOrdenPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.proyectobaiq5.entity.OrdenPago[ idOrdenPago=" + idOrdenPago + " ]";
    }
    
}
