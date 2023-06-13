package ifsplife.control;

import ifsplife.model.Fornecedores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControleFornecedor {

    public void adicionar(Fornecedores fornecedores) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(fornecedores);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Fornecedores Fornecedor) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Fornecedores fornecedorExcluir = gerente.find(Fornecedores.class,
                Fornecedor.getCodigo_fornecedor());

        gerente.getTransaction().begin();

        gerente.remove(fornecedorExcluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Fornecedores fornecedores) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(fornecedores);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<Fornecedores> getTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Fornecedores> consulta
                = gerente.createNamedQuery("Fornecedores.findAll", Fornecedores.class);

        return consulta.getResultList();

    }

    public List<Fornecedores> getPorNome(String nomePesquisar) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Fornecedores> consulta
                = gerente.createNamedQuery("Fornecedores.findByNome", Fornecedores.class);

        consulta.setParameter("nome", "%" + nomePesquisar + "%");

        return consulta.getResultList();

    }
}