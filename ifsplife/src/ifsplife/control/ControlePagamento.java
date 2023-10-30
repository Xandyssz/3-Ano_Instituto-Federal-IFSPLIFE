package ifsplife.control;

import ifsplife.model.Pagamentocompra;
import ifsplife.model.Produto;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControlePagamento {

    public void realizarPagamento(Pagamentocompra pagamento) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(pagamento);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<Pagamentocompra> getTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Pagamentocompra> consulta
                = gerente.createNamedQuery("Pagamentocompra.findAll", Pagamentocompra.class);

        return consulta.getResultList();

    }

    public List<Pagamentocompra> getPorNome(String nomePesquisar) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Pagamentocompra> consulta
                = gerente.createNamedQuery("Pagamentocompra.findByNomeFornecedor", Pagamentocompra.class);

        consulta.setParameter("nome", "%" + nomePesquisar + "%");

        return consulta.getResultList();

    }

    public List<Pagamentocompra> getPorPeriodo(Date inicio, Date fim) {
        EntityManager gerente = GerenciadorConexao.getGerente();
        TypedQuery<Pagamentocompra> consulta
                = gerente.createNamedQuery("Pagamentocompra.findByPeriodo", Pagamentocompra.class);

        consulta.setParameter("inicio", inicio);
        consulta.setParameter("fim", fim);
        return consulta.getResultList();
    }

    public List<Pagamentocompra> getPorStatus(String status) {
        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Pagamentocompra> consulta = gerente.createNamedQuery("Pagamentocompra.findByStatus", Pagamentocompra.class);

        consulta.setParameter("status", status);

        return consulta.getResultList();
    }

}
