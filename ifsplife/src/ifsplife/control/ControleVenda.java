package ifsplife.control;

import ifsplife.model.Vendas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControleVenda {

    // adiciona um materiaprima
    public void adicionar(Vendas vendas) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(vendas);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Vendas Vendas) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Vendas vendaExcluir = gerente.find(Vendas.class,
                Vendas.getCodigo_venda());

        gerente.getTransaction().begin();

        gerente.remove(vendaExcluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Vendas vendas) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(vendas);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<Vendas> getTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Vendas> consulta
                = gerente.createNamedQuery("Vendas.findAll", Vendas.class);

        return consulta.getResultList();

    }
    
}
