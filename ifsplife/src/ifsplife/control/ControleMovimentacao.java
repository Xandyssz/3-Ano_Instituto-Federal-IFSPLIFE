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

    TypedQuery<Movimentacao> consulta = gerente.createNamedQuery("Movimentacao.findAll", Movimentacao.class);
    List<Movimentacao> movimentacoes = consulta.getResultList();

    double valorSuplementacao = 0.0;
    double valorSangria = 0.0;

    for (Movimentacao movimentacao : movimentacoes) {
        String tipo = movimentacao.getTipo();
        double valor = movimentacao.getValor();

        if (tipo.equals("Suplementação")) {
            valorSuplementacao += valor;
        } else if (tipo.equals("Sangria")) {
            valorSangria += valor;
        }
    }

    System.out.println("Valor de Suplementação: " + valorSuplementacao);
    System.out.println("Valor de Sangria: " + valorSangria);

    return movimentacoes;
}
    


}
