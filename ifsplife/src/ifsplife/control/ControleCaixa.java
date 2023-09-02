package ifsplife.control;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import ifsplife.model.Caixa;

public class ControleCaixa {

    private static Caixa caixaAberto = null;

    public void abrir(Caixa caixa) {
        EntityManager gerente = GerenciadorConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.persist(caixa);
        gerente.getTransaction().commit();
        gerente.close();
        caixaAberto = caixa;
    }

    public void fechar(Caixa caixa) {
        EntityManager gerente = GerenciadorConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.merge(caixa);
        gerente.getTransaction().commit();
        gerente.close();
        caixaAberto = null;
    }

    public List<Caixa> getTodos() {
        EntityManager gerente = GerenciadorConexao.getGerente();
        TypedQuery<Caixa> consulta
                = gerente.createNamedQuery("Caixa.findAll", Caixa.class);
        return consulta.getResultList();

    }

    public List<Caixa> getPorPeriodo(Date inicio, Date fim) {
        EntityManager gerente = GerenciadorConexao.getGerente();
        TypedQuery<Caixa> consulta
                = gerente.createNamedQuery("Caixa.findByAbertura", Caixa.class);

        consulta.setParameter("inicio", inicio);
        consulta.setParameter("fim", fim);
        return consulta.getResultList();

    }

    private static Caixa verificarCaixaAbertoBanco() {
        List<Caixa> caixas;

        EntityManager gerente = GerenciadorConexao.getGerente();
        TypedQuery<Caixa> consulta
                = gerente.createNamedQuery("Caixa.findByFechamento", Caixa.class);

        caixas = consulta.getResultList();
        if (caixas.isEmpty()) {
            return null;
        } else {
            return caixas.get(0);
        }
    }

    public static boolean isCaixaAberto() {
        if (caixaAberto == null) {
            caixaAberto = verificarCaixaAbertoBanco();
        }
        return caixaAberto != null;
    }

    public static Caixa getCaixaAberto() {
        if (caixaAberto == null) {
            caixaAberto = verificarCaixaAbertoBanco();
        }
        return caixaAberto;
    }

    public static void atualizarCaixa() {
        caixaAberto = verificarCaixaAbertoBanco();
    }

}
