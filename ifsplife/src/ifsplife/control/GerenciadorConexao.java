package ifsplife.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenciadorConexao {
    
    private static EntityManagerFactory emf;
    
    public static EntityManagerFactory getFabrica()
    {
        if(emf == null)
        {
            emf = Persistence.createEntityManagerFactory("ifsplife_projetoPU");
        }
        return emf;
    }
    
    public static EntityManager getGerente()
    {
        return getFabrica().createEntityManager();
    }
    
}