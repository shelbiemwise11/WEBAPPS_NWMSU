
package Manufacturer;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;


@Named(value = "manufacturerList")
@RequestScoped
public class ManufacturerList {

    @PersistenceUnit(unitName = "PU")
    private EntityManagerFactory enManFact = null;
    private String state = null;
    
    public ManufacturerList() {
        
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public List<Manufacturer> getManFacts(){
        EntityManager em = enManFact.createEntityManager();
        return em.createQuery("select m from Manufacturer m where m.state = '" + state + "'").getResultList();
    }
}
