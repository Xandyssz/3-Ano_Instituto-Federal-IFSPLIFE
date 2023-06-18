package ifsplife.control;

import ifsplife.model.Compras;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControleCompra {

    public void adicionar(Compras compras) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(compras);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Compras Compras) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Compras compraExcluir = gerente.find(Compras.class,
                Compras.getCodigo_compra());

        gerente.getTransaction().begin();

        gerente.remove(compraExcluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Compras compras) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(compras);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<Compras> getTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Compras> consulta
                = gerente.createNamedQuery("Compras.findAll", Compras.class);

        return consulta.getResultList();

    }

}
