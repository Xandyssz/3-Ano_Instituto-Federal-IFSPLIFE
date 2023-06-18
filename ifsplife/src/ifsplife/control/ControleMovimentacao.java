package ifsplife.control;

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

}
