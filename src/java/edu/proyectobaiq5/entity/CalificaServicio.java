/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dairo
 */
@Entity
@Table(name = "califica_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalificaServicio.findAll", query = "SELECT c FROM CalificaServicio c")})
public class CalificaServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_CalificaServicio")
    private Integer idCalificaServicio;
    @Column(name = "Puntaje")
    private Integer puntaje;
    @Size(max = 150)
    @Column(name = "Obeservaciones")
    private String obeservaciones;
    @JoinColumn(name = "Id_detalleOrdenPago", referencedColumnName = "Id_detalleOrdenPago")
    @ManyToOne(fetch = FetchType.LAZY)
    private DetalleOrdenPago iddetalleOrdenPago;
    @JoinColumn(name = "Id_OrdenServicio", referencedColumnName = "Id_OrdenServicio")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrdenServicio idOrdenServicio;
    @JoinColumn(name = "Id_Admin", referencedColumnName = "Id_Admin")
    @ManyToOne(fetch = FetchType.LAZY)
    private Administrador idAdmin;
    @JoinColumn(name = "Id_Encuesta", referencedColumnName = "Id_Encuesta")
    @ManyToOne(fetch = FetchType.LAZY)
    private Encuesta idEncuesta;

    public CalificaServicio() {
    }

    public CalificaServicio(Integer idCalificaServicio) {
        this.idCalificaServicio = idCalificaServicio;
    }

    public Integer getIdCalificaServicio() {
        return idCalificaServicio;
    }

    public void setIdCalificaServicio(Integer idCalificaServicio) {
        this.idCalificaServicio = idCalificaServicio;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public String getObeservaciones() {
        return obeservaciones;
    }

    public void setObeservaciones(String obeservaciones) {
        this.obeservaciones = obeservaciones;
    }

    public DetalleOrdenPago getIddetalleOrdenPago() {
        return iddetalleOrdenPago;
    }

    public void setIddetalleOrdenPago(DetalleOrdenPago iddetalleOrdenPago) {
        this.iddetalleOrdenPago = iddetalleOrdenPago;
    }

    public OrdenServicio getIdOrdenServicio() {
        return idOrdenServicio;
    }

    public void setIdOrdenServicio(OrdenServicio idOrdenServicio) {
        this.idOrdenServicio = idOrdenServicio;
    }

    public Administrador getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Administrador idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Encuesta getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Encuesta idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalificaServicio != null ? idCalificaServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalificaServicio)) {
            return false;
        }
        CalificaServicio other = (CalificaServicio) object;
        if ((this.idCalificaServicio == null && other.idCalificaServicio != null) || (this.idCalificaServicio != null && !this.idCalificaServicio.equals(other.idCalificaServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.proyectobaiq5.entity.CalificaServicio[ idCalificaServicio=" + idCalificaServicio + " ]";
    }
    
}
