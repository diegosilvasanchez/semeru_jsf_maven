package br.com.semeru.suport;

import br.com.semeru.dao.HibernateDAO;
import br.com.semeru.dao.InterfaceDAO;
import br.com.semeru.entities.Cidade;
import br.com.semeru.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bbCidade")
@RequestScoped
public class BbCidade implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public List<Cidade> getCidades() {
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDAO.getEntities();
    }
}
