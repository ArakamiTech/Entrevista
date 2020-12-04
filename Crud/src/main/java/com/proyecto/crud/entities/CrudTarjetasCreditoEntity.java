package com.proyecto.crud.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CRUD_TARJETAS_CREDITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrudTarjetasCreditoEntity.findAll", query = "SELECT c FROM CrudTarjetasCreditoEntity c")
    , @NamedQuery(name = "CrudTarjetasCreditoEntity.findByNumIdTarjeta", query = "SELECT c FROM CrudTarjetasCreditoEntity c WHERE c.numIdTarjeta = :numIdTarjeta")
    , @NamedQuery(name = "CrudTarjetasCreditoEntity.findByStrNumeroTarjeta", query = "SELECT c FROM CrudTarjetasCreditoEntity c WHERE c.strNumeroTarjeta = :strNumeroTarjeta")
    , @NamedQuery(name = "CrudTarjetasCreditoEntity.findByStrTipoTarjeta", query = "SELECT c FROM CrudTarjetasCreditoEntity c WHERE c.strTipoTarjeta = :strTipoTarjeta")
    , @NamedQuery(name = "CrudTarjetasCreditoEntity.findByDateFechaVencimiento", query = "SELECT c FROM CrudTarjetasCreditoEntity c WHERE c.dateFechaVencimiento = :dateFechaVencimiento")
    , @NamedQuery(name = "CrudTarjetasCreditoEntity.findByStrCvv", query = "SELECT c FROM CrudTarjetasCreditoEntity c WHERE c.strCvv = :strCvv")})
public class CrudTarjetasCreditoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_ID_TARJETA")
    private Short numIdTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "STR_NUMERO_TARJETA")
    private String strNumeroTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "STR_TIPO_TARJETA")
    private String strTipoTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "STR_CVV")
    private String strCvv;
    @JoinColumn(name = "NUM_ID_CLIENTE", referencedColumnName = "NUM_ID_CLIENTE")
    @ManyToOne(optional = false)
    private CrudClientesEntity numIdCliente;

    public CrudTarjetasCreditoEntity() {
    }

    public CrudTarjetasCreditoEntity(Short numIdTarjeta) {
        this.numIdTarjeta = numIdTarjeta;
    }

    public CrudTarjetasCreditoEntity(Short numIdTarjeta, String strNumeroTarjeta, String strTipoTarjeta, Date dateFechaVencimiento, String strCvv) {
        this.numIdTarjeta = numIdTarjeta;
        this.strNumeroTarjeta = strNumeroTarjeta;
        this.strTipoTarjeta = strTipoTarjeta;
        this.dateFechaVencimiento = dateFechaVencimiento;
        this.strCvv = strCvv;
    }

    public Short getNumIdTarjeta() {
        return numIdTarjeta;
    }

    public void setNumIdTarjeta(Short numIdTarjeta) {
        this.numIdTarjeta = numIdTarjeta;
    }

    public String getStrNumeroTarjeta() {
        return strNumeroTarjeta;
    }

    public void setStrNumeroTarjeta(String strNumeroTarjeta) {
        this.strNumeroTarjeta = strNumeroTarjeta;
    }

    public String getStrTipoTarjeta() {
        return strTipoTarjeta;
    }

    public void setStrTipoTarjeta(String strTipoTarjeta) {
        this.strTipoTarjeta = strTipoTarjeta;
    }

    public Date getDateFechaVencimiento() {
        return dateFechaVencimiento;
    }

    public void setDateFechaVencimiento(Date dateFechaVencimiento) {
        this.dateFechaVencimiento = dateFechaVencimiento;
    }

    public String getStrCvv() {
        return strCvv;
    }

    public void setStrCvv(String strCvv) {
        this.strCvv = strCvv;
    }

    public CrudClientesEntity getNumIdCliente() {
        return numIdCliente;
    }

    public void setNumIdCliente(CrudClientesEntity numIdCliente) {
        this.numIdCliente = numIdCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numIdTarjeta != null ? numIdTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrudTarjetasCreditoEntity)) {
            return false;
        }
        CrudTarjetasCreditoEntity other = (CrudTarjetasCreditoEntity) object;
        if ((this.numIdTarjeta == null && other.numIdTarjeta != null) || (this.numIdTarjeta != null && !this.numIdTarjeta.equals(other.numIdTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.crud.entities.CrudTarjetasCreditoEntity[ numIdTarjeta=" + numIdTarjeta + " ]";
    }
    
}
