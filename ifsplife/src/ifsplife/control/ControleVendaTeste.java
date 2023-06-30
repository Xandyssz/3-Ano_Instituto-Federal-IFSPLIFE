package ifsplife.control;

import ifsplife.model.Produtovenda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControleVendaTeste {

    public void adicionar(Produtovenda produtovenda) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(produtovenda);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Produtovenda Produtovenda) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Produtovenda produtovendaExcluir = gerente.find(Produtovenda.class,
                Produtovenda.getCodigo_venda().getCodigo_venda());

        gerente.getTransaction().begin();

        gerente.remove(produtovendaExcluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Produtovenda produtovenda) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(produtovenda);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<Produtovenda> getTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Produtovenda> consulta
                = gerente.createNamedQuery("Produtovenda.findAll", Produtovenda.class);

        return consulta.getResultList();

    }

}
