package ifsplife.control;

import ifsplife.model.Caixa;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControleCaixa {

    private static Caixa caixa = null;

    public void adicionar(Caixa caixa) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(caixa);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Caixa Caixa) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Caixa funcionarioExcluir = gerente.find(Caixa.class,
                Caixa.getCodigo_caixa());

        gerente.getTransaction().begin();

        gerente.remove(funcionarioExcluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Caixa caixa) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(caixa);

        gerente.getTransaction().commit();

        gerente.close();
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static Caixa abrirCaixa(Date abertura) {

        Caixa caixa = new Caixa();

        caixa.setAbertura(abertura);
        caixa.setValorabertura(0);

        EntityManager gerente = GerenciadorConexao.getGerente();
        gerente.find(Caixa.class, caixa);

        ControleCaixa.caixa = caixa;

        return caixa;
    }

    public static void fecharCaixa() {
        if (caixa != null) {
            caixa.setFechamento(new Date());

            EntityManager gerente = GerenciadorConexao.getGerente();
            gerente.merge(caixa);

        }

        ControleCaixa.caixa = null;
    }

    public static boolean caixaAberto() {
        return caixa != null;
    }

    public static Caixa getCaixaAberto() {
        return caixa;
    }

}
