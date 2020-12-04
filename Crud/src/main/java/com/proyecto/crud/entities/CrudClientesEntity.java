package com.proyecto.crud.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "CRUD_CLIENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrudClientesEntity.findAll", query = "SELECT c FROM CrudClientesEntity c")
    , @NamedQuery(name = "CrudClientesEntity.findByNumIdCliente", query = "SELECT c FROM CrudClientesEntity c WHERE c.numIdCliente = :numIdCliente")
    , @NamedQuery(name = "CrudClientesEntity.findByStrNombre", query = "SELECT c FROM CrudClientesEntity c WHERE c.strNombre = :strNombre")
    , @NamedQuery(name = "CrudClientesEntity.findByStrIdentificacion", query = "SELECT c FROM CrudClientesEntity c WHERE c.strIdentificacion = :strIdentificacion")
    , @NamedQuery(name = "CrudClientesEntity.findByStrNumeroTelefono", query = "SELECT c FROM CrudClientesEntity c WHERE c.strNumeroTelefono = :strNumeroTelefono")})
public class CrudClientesEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_ID_CLIENTE")
    private Short numIdCliente;
    @Size(max = 50)
    @Column(name = "STR_NOMBRE")
    private String strNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "STR_IDENTIFICACION")
    private String strIdentificacion;
    @Size(max = 10)
    @Column(name = "STR_NUMERO_TELEFONO")
    private String strNumeroTelefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numIdCliente")
    private List<CrudTarjetasCreditoEntity> crudTarjetasCreditoEntityList;

    public CrudClientesEntity() {
    }

    public CrudClientesEntity(Short numIdCliente) {
        this.numIdCliente = numIdCliente;
    }

    public CrudClientesEntity(Short numIdCliente, String strIdentificacion) {
        this.numIdCliente = numIdCliente;
        this.strIdentificacion = strIdentificacion;
    }

    public Short getNumIdCliente() {
        return numIdCliente;
    }

    public void setNumIdCliente(Short numIdCliente) {
        this.numIdCliente = numIdCliente;
    }

    public String getStrNombre() {
        return strNombre;
    }

    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    public String getStrIdentificacion() {
        return strIdentificacion;
    }

    public void setStrIdentificacion(String strIdentificacion) {
        this.strIdentificacion = strIdentificacion;
    }

    public String getStrNumeroTelefono() {
        return strNumeroTelefono;
    }

    public void setStrNumeroTelefono(String strNumeroTelefono) {
        this.strNumeroTelefono = strNumeroTelefono;
    }

    @XmlTransient
    public List<CrudTarjetasCreditoEntity> getCrudTarjetasCreditoEntityList() {
        return crudTarjetasCreditoEntityList;
    }

    public void setCrudTarjetasCreditoEntityList(List<CrudTarjetasCreditoEntity> crudTarjetasCreditoEntityList) {
        this.crudTarjetasCreditoEntityList = crudTarjetasCreditoEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numIdCliente != null ? numIdCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrudClientesEntity)) {
            return false;
        }
        CrudClientesEntity other = (CrudClientesEntity) object;
        if ((this.numIdCliente == null && other.numIdCliente != null) || (this.numIdCliente != null && !this.numIdCliente.equals(other.numIdCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.crud.entities.CrudClientesEntity[ numIdCliente=" + numIdCliente + " ]";
    }
    
}
