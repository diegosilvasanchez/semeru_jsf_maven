package br.com.semeru.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="idEndereco", nullable = false, unique = true)
    private Integer idEndereco;
    
    @Column(name="Bairro", length = 80)
    private String bairro;
    
    @Column(name="NomeLogradouro", length = 80)
    private String nomeLogradouro;
    
    @Column(name="CEP", length = 9)
    private String cep;
    
    @Column(name="Numero")
    private Integer numero;
    
    @Column(name="complemento")
    private String complemento;
    
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoPessoa")
    @JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
    private Pessoa pessoa;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoTipoLogradouro")
    @JoinColumn(name = "idTipoLogradouro", referencedColumnName = "idTipoLogradouro")
    private TipoLogradouro tipologradouro;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoTipoEndereco")
    @JoinColumn(name = "idTipoEndereco", referencedColumnName = "idTipoEndereco")
    private TipoEndereco tipoendereco;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoCidade")
    @JoinColumn(name = "idCidade", referencedColumnName = "idCidade")
    private Cidade cidade;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoEstado")
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado")
    private Estado estado;

    public Endereco() {
        this.cidade = new Cidade();
        this.pessoa = new Pessoa();
        this.tipologradouro = new TipoLogradouro();
        this.tipoendereco = new TipoEndereco();
        this.estado = new Estado();
        this.pessoa = new Pessoa();
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoLogradouro getTipologradouro() {
        return tipologradouro;
    }

    public void setTipologradouro(TipoLogradouro tipologradouro) {
        this.tipologradouro = tipologradouro;
    }

    public TipoEndereco getTipoendereco() {
        return tipoendereco;
    }

    public void setTipoendereco(TipoEndereco tipoendereco) {
        this.tipoendereco = tipoendereco;
    }   

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.idEndereco != null ? this.idEndereco.hashCode() : 0);
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
        final Endereco other = (Endereco) obj;
        if (this.idEndereco != other.idEndereco && (this.idEndereco == null || !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }    
}
