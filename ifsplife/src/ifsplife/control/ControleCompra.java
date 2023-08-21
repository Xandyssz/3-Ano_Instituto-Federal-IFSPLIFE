package ifsplife.control;

import ifsplife.model.Compras;
import ifsplife.model.Produto;
import ifsplife.model.Produtocompra;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControleCompra {

    public void adicionar(Compras compras) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(compras);

        for (Produtocompra pc : compras.getItemcompra()) {
            Produto p = pc.getcodigo_produto();
            p.atualizarEstoqueCompra(pc.getQuantidade());
            gerente.merge(p);
        }

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

    public List<Compras> getPorPeriodo(Date inicio, Date fim) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Compras> consulta
                = gerente.createNamedQuery("Compras.findByPeriodo", Compras.class);

        consulta.setParameter("datainicio", inicio);
        consulta.setParameter("datafim", fim);
        
        return consulta.getResultList();

    }

}
