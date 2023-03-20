/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsplife.control;

import java.util.ArrayList;
import ifsplife.model.Convenio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author xandy
 */
public class ControleConvenio {

    private static final ArrayList<Convenio> listaConvenio = new ArrayList<>();

    // adiciona um materiaprima
    public void adicionar(Convenio convenio) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(convenio);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Convenio Convenio) {
     
        EntityManager gerente = GerenciadorConexao.getGerente();

        Convenio convenioExcluir = gerente.find(Convenio.class,
                Convenio.getCodigo());

        gerente.getTransaction().begin();

        gerente.remove(convenioExcluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Convenio convenio) {
      
        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(convenio);

        gerente.getTransaction().commit();

        gerente.close();
    }

        public List<Convenio> getTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Convenio> consulta
                = gerente.createNamedQuery("Convenio.todos", Convenio.class);

        return consulta.getResultList();

    }
        
    public List<Convenio> getPorNome(String nomePesquisar) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Convenio> consulta
                = gerente.createNamedQuery("Convenio.porNome", Convenio.class);

        consulta.setParameter("nomequalquer", "%" + nomePesquisar + "%");

        return consulta.getResultList();

    }
}
