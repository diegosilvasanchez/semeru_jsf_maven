package br.com.semeru.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipologadouro")
public class TipoLogradouro implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="idTipoLogadouro", nullable = false, unique = true)
    private Integer idTipoLogadouro;
    
    @Column(name="DescricaoTipoLogadouro", nullable = false, length = 40)
    private String descricaoTipoLogadouro;

    public TipoLogradouro() {
    }

    public Integer getIdTipoLogadouro() {
        return idTipoLogadouro;
    }

    public void setIdTipoLogadouro(Integer idTipoLogadouro) {
        this.idTipoLogadouro = idTipoLogadouro;
    }

    public String getDescricaoTipoLogadouro() {
        return descricaoTipoLogadouro;
    }

    public void setDescricaoTipoLogadouro(String descricaoTipoLogadouro) {
        this.descricaoTipoLogadouro = descricaoTipoLogadouro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.idTipoLogadouro != null ? this.idTipoLogadouro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoLogradouro other = (TipoLogradouro) obj;
        if (this.idTipoLogadouro != other.idTipoLogadouro && (this.idTipoLogadouro == null || !this.idTipoLogadouro.equals(other.idTipoLogadouro))) {
            return false;
        }
        return true;
    }    
}
