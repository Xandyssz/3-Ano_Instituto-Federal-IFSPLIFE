/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsplife.control;

import java.util.ArrayList;
import ifsplife.model.Fornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author xandy
 */
public class ControleFornecedor {
    
        private static final ArrayList<Fornecedor> listaFornecedor = new ArrayList<>();

    // adiciona um materiaprima
    public void adicionar(Fornecedor fornecedor) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(fornecedor);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Fornecedor Fornecedor) {
     
        EntityManager gerente = GerenciadorConexao.getGerente();

        Fornecedor fornecedorExcluir = gerente.find(Fornecedor.class,
                Fornecedor.getCodigo());

        gerente.getTransaction().begin();

        gerente.remove(fornecedorExcluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Fornecedor fornecedor) {
      
        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(fornecedor);

        gerente.getTransaction().commit();

        gerente.close();
    }

        public List<Fornecedor> getTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Fornecedor> consulta
                = gerente.createNamedQuery("Fornecedor.todos", Fornecedor.class);

        return consulta.getResultList();

    }
        
    public List<Fornecedor> getPorNome(String nomePesquisar) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Fornecedor> consulta
                = gerente.createNamedQuery("Fornecedor.porNome", Fornecedor.class);

        consulta.setParameter("nomequalquer", "%" + nomePesquisar + "%");

        return consulta.getResultList();

    }
}
