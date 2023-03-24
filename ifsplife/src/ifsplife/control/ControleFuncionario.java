package ifsplife.control;

import ifsplife.model.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControleFuncionario {

    private static final ArrayList<Funcionario> listaFuncionario = new ArrayList<>();

    public void adicionar(Funcionario funcionario) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(funcionario);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Funcionario Funcionario) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Funcionario funcionarioExcluir = gerente.find(Funcionario.class,
                Funcionario.getCodigo());

        gerente.getTransaction().begin();

        gerente.remove(funcionarioExcluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Funcionario funcionario) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(funcionario);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<Funcionario> getTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Funcionario> consulta
                = gerente.createNamedQuery("Funcionario.todos", Funcionario.class);

        return consulta.getResultList();

    }

    public List<Funcionario> getPorNome(String nomePesquisar) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Funcionario> consulta
                = gerente.createNamedQuery("Funcionario.porNome", Funcionario.class);

        consulta.setParameter("nomequalquer", "%" + nomePesquisar + "%");

        return consulta.getResultList();

    }
}
