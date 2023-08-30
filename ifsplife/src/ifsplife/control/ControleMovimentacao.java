package ifsplife.control;

import ifsplife.model.Caixa;
import ifsplife.model.Movimentacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControleMovimentacao {

    public void adicionar(Movimentacao movimentacao) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(movimentacao);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<Movimentacao> getTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Movimentacao> consulta
                = gerente.createNamedQuery("Movimentacao.findAll", Movimentacao.class);

        return consulta.getResultList();

    }

    public List<Movimentacao> getMovPorCaixa(Caixa caixa) {

        // criar uma conexao com o banco
        EntityManager gerente = GerenciadorConexao.getGerente();

        // criar um objeto do tipo Consulta
        TypedQuery<Movimentacao> consulta
                = gerente.createNamedQuery("Movimentacao.findByCodigoCaixa", Movimentacao.class);
        consulta.setParameter("codigoCaixa", caixa);

        // retorna a lista de objetos da consulta
        return consulta.getResultList();
    }

}
