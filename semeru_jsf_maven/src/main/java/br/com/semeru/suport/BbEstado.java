package br.com.semeru.suport;

import br.com.semeru.dao.HibernateDAO;
import br.com.semeru.dao.InterfaceDAO;
import br.com.semeru.entities.Estado;
import br.com.semeru.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bbEstado")
@RequestScoped
public class BbEstado implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public List<Estado> getEstados() {
        InterfaceDAO<Estado> estadoDAO = new HibernateDAO<Estado>(Estado.class, FacesContextUtil.getRequestSession());
        return estadoDAO.getEntities();
    }
}
