package br.com.semeru.suport;

import br.com.semeru.dao.HibernateDAO;
import br.com.semeru.dao.InterfaceDAO;
import br.com.semeru.entities.TipoLogradouro;
import br.com.semeru.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bbTipoLogradouro")
@RequestScoped
public class BbTipoLogradouro implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public List<TipoLogradouro> getTipoLogradouros() {
        InterfaceDAO<TipoLogradouro> tipoLogradouroDAO = new HibernateDAO<TipoLogradouro>(TipoLogradouro.class, FacesContextUtil.getRequestSession());
        return tipoLogradouroDAO.getEntities();
    }
}