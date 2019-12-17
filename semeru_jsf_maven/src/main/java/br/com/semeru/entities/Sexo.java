package br.com.semeru.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="sexo")
public class Sexo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdSexo", nullable = false, unique = true)
    private Integer idSexo;
    
    @Column(name="Descricao", nullable = false, length = 10)
    private String descricao;
    
    @OneToMany(mappedBy = "sexo",fetch = FetchType.LAZY)
    @ForeignKey(name = "PessoaSexo")
    private List<Pessoa> pessoas;

    public Sexo() {
    }    

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }    

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.idSexo != null ? this.idSexo.hashCode() : 0);
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
        final Sexo other = (Sexo) obj;
        if (this.idSexo != other.idSexo && (this.idSexo == null || !this.idSexo.equals(other.idSexo))) {
            return false;
        }
        return true;
    }    
}