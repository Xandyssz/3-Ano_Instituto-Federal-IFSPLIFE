package ifsplife.control;

import ifsplife.model.Funcionarios;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControleFuncionario {

    private static final ArrayList<Funcionarios> listaFuncionario = new ArrayList<>();

    public void adicionar(Funcionarios funcionarios) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(funcionarios);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Funcionarios Funcionarios) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Funcionarios funcionarioExcluir = gerente.find(Funcionarios.class,
                Funcionarios.getCodigoFuncionario());

        gerente.getTransaction().begin();

        gerente.remove(funcionarioExcluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Funcionarios funcionarios) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(funcionarios);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<Funcionarios> getTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Funcionarios> consulta
                = gerente.createNamedQuery("Funcionarios.findAll", Funcionarios.class);

        return consulta.getResultList();

    }

    public List<Funcionarios> getPorNome(String nomePesquisar) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Funcionarios> consulta
                = gerente.createNamedQuery("Funcionarios.findByNome", Funcionarios.class);

        consulta.setParameter("nome", "%" + nomePesquisar + "%");

        return consulta.getResultList();

    }
}
