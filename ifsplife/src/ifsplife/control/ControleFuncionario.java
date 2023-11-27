package ifsplife.control;

import ifsplife.model.Funcionarios;
import ifsplife.model.exceptions.FuncionarioException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControleFuncionario {

    private static Funcionarios funcionarioLogado = null;

    public void adicionar(Funcionarios funcionarios) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(funcionarios);

        gerente.getTransaction().commit();

        gerente.close();
    }

 public void remover(Funcionarios funcionarios) throws FuncionarioException {
        EntityManager gerente = GerenciadorConexao.getGerente();

        try {
            Funcionarios funcionarioExcluir = gerente.find(Funcionarios.class, funcionarios.getCodigo_funcionario());

            if (funcionarioExcluir != null) {
                gerente.getTransaction().begin();
                gerente.remove(funcionarioExcluir);
                gerente.getTransaction().commit();
            } else {
                throw new FuncionarioException("Funcionário não encontrado para exclusão.");
            }
        } catch (Exception e) {
            gerente.getTransaction().rollback();
            throw new FuncionarioException("Erro ao excluir o funcionário: " + e.getMessage());
        } finally {
            gerente.close();
        }
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

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static Funcionarios login(String login, String senha) throws FuncionarioOuSenhaIncorretaException {
        List<Funcionarios> funcionarios = null;

        EntityManager gerente = GerenciadorConexao.getGerente();
        TypedQuery<Funcionarios> consulta = gerente.createNamedQuery("Funcionarios.findByLogin", Funcionarios.class);

        consulta.setParameter("login", login);
        consulta.setParameter("senha", senha);

        funcionarios = consulta.getResultList();
        if (funcionarios.isEmpty()) {
            throw new FuncionarioOuSenhaIncorretaException("O usuario ou senha digitada está incorreta.");
        } else {
            ControleFuncionario.funcionarioLogado = funcionarios.get(0);
        }

        return funcionarios.get(0);
    }

    public static void logout() {
        ControleFuncionario.funcionarioLogado = null;
    }

    public static boolean isUsuarioLogado() {
        return funcionarioLogado != null;
    }

    public static Funcionarios getUsuarioLogado() {
        return funcionarioLogado;
    }

}
