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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dairo
 */
@Entity
@Table(name = "orden_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenServicio.findAll", query = "SELECT o FROM OrdenServicio o")})
public class OrdenServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_OrdenServicio")
    private Integer idOrdenServicio;
    @Column(name = "NumeroREquerimiento")
    private Integer numeroREquerimiento;
    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 150)
    @Column(name = "ReporteCliente")
    private String reporteCliente;
    @Size(max = 150)
    @Column(name = "Diagnostico")
    private String diagnostico;
    @Size(max = 150)
    @Column(name = "ComentariosCierre")
    private String comentariosCierre;
    @Size(max = 150)
    @Column(name = "Repuestos")
    private String repuestos;
    @Size(max = 50)
    @Column(name = "Garantia")
    private String garantia;
    @Column(name = "CostosServicio")
    private Integer costosServicio;
    @Size(max = 30)
    @Column(name = "Iva")
    private String iva;
    @Column(name = "TotalServicio")
    private Integer totalServicio;
    @JoinColumn(name = "Id_TipoServicio", referencedColumnName = "Id_TipoServicio")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoServicio idTipoServicio;
    @JoinColumn(name = "Id_soporte", referencedColumnName = "Id_soporte")
    @ManyToOne(fetch = FetchType.LAZY)
    private Soporte idsoporte;
    @JoinColumn(name = "Id_cliente", referencedColumnName = "Id_cliente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente idcliente;
    @OneToMany(mappedBy = "idOrdenServicio", fetch = FetchType.LAZY)
    private Collection<OrdenPago> ordenPagoCollection;
    @OneToMany(mappedBy = "idOrdenServicio", fetch = FetchType.LAZY)
    private Collection<CalificaServicio> calificaServicioCollection;

    public OrdenServicio() {
    }

    public OrdenServicio(Integer idOrdenServicio) {
        this.idOrdenServicio = idOrdenServicio;
    }

    public Integer getIdOrdenServicio() {
        return idOrdenServicio;
    }

    public void setIdOrdenServicio(Integer idOrdenServicio) {
        this.idOrdenServicio = idOrdenServicio;
    }

    public Integer getNumeroREquerimiento() {
        return numeroREquerimiento;
    }

    public void setNumeroREquerimiento(Integer numeroREquerimiento) {
        this.numeroREquerimiento = numeroREquerimiento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getReporteCliente() {
        return reporteCliente;
    }

    public void setReporteCliente(String reporteCliente) {
        this.reporteCliente = reporteCliente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getComentariosCierre() {
        return comentariosCierre;
    }

    public void setComentariosCierre(String comentariosCierre) {
        this.comentariosCierre = comentariosCierre;
    }

    public String getRepuestos() {
        return repuestos;
    }

    public void setRepuestos(String repuestos) {
        this.repuestos = repuestos;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public Integer getCostosServicio() {
        return costosServicio;
    }

    public void setCostosServicio(Integer costosServicio) {
        this.costosServicio = costosServicio;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public Integer getTotalServicio() {
        return totalServicio;
    }

    public void setTotalServicio(Integer totalServicio) {
        this.totalServicio = totalServicio;
    }

    public TipoServicio getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(TipoServicio idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public Soporte getIdsoporte() {
        return idsoporte;
    }

    public void setIdsoporte(Soporte idsoporte) {
        this.idsoporte = idsoporte;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @XmlTransient
    public Collection<OrdenPago> getOrdenPagoCollection() {
        return ordenPagoCollection;
    }

    public void setOrdenPagoCollection(Collection<OrdenPago> ordenPagoCollection) {
        this.ordenPagoCollection = ordenPagoCollection;
    }

    @XmlTransient
    public Collection<CalificaServicio> getCalificaServicioCollection() {
        return calificaServicioCollection;
    }

    public void setCalificaServicioCollection(Collection<CalificaServicio> calificaServicioCollection) {
        this.calificaServicioCollection = calificaServicioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenServicio != null ? idOrdenServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenServicio)) {
            return false;
        }
        OrdenServicio other = (OrdenServicio) object;
        if ((this.idOrdenServicio == null && other.idOrdenServicio != null) || (this.idOrdenServicio != null && !this.idOrdenServicio.equals(other.idOrdenServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.proyectobaiq5.entity.OrdenServicio[ idOrdenServicio=" + idOrdenServicio + " ]";
    }
    
}
