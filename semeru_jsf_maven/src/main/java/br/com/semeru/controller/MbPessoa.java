package br.com.semeru.controller;

import br.com.semeru.dao.HibernateDAO;
import br.com.semeru.dao.InterfaceDAO;
import br.com.semeru.entities.Endereco;
import br.com.semeru.entities.Pessoa;
import br.com.semeru.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class MbPessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Pessoa pessoa = new Pessoa();
    private Endereco endereco = new Endereco();
    private List<Pessoa> pessoas;    
    private List<Endereco> enderecos;    

    public MbPessoa() {
    }
    
    private InterfaceDAO<Pessoa> pessoaDAO(){
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession());
        return pessoaDAO;
    }  
    
    private InterfaceDAO<Endereco> enderecoDAO(){
        InterfaceDAO<Endereco> enderecoDAO = new HibernateDAO<Endereco>(Endereco.class, FacesContextUtil.getRequestSession());
        return enderecoDAO;
    }
    
    public String editPessoa(){
        return "/restrict/cadastrapessoa.faces";
    }
    
    public String addPessoa(){
        if (pessoa.getIdPessoa() == null || pessoa.getIdPessoa() == 0) {
            insertPessoa();
        } else {
            updatePessoa();
        }
        limpaPessoa();
        return null;
    }

    private void insertPessoa() {
        pessoaDAO().save(pessoa);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação Efetuada com Sucesso", ""));
    }

    private void updatePessoa() {
        pessoaDAO().update(pessoa);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização Efetuada com Sucesso", ""));
    }
    
    public void deletePessoa() {
        pessoaDAO().remove(pessoa);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão Efetuada com Sucesso", ""));
    }

    public String limpaPessoa() {
        pessoa = new Pessoa();
        endereco = new Endereco();
        return editPessoa();
    }    

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Pessoa> getPessoas() {
        pessoas = pessoaDAO().getEntities();
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Endereco> getEnderecos() {
        enderecos = enderecoDAO().getEntities();
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }    
}
