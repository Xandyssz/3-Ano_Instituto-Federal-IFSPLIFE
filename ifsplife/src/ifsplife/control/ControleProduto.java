package ifsplife.control;

import ifsplife.model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControleProduto {

    private static final ArrayList<Produto> listaProduto = new ArrayList<>();

    // adiciona um materiaprima
    public void adicionar(Produto produto) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(produto);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Produto Produto) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Produto produtoExcluir = gerente.find(Produto.class,
                Produto.getCodigo());

        gerente.getTransaction().begin();

        gerente.remove(produtoExcluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Produto produto) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(produto);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<Produto> getTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Produto> consulta
                = gerente.createNamedQuery("Produto.todos", Produto.class);

        return consulta.getResultList();

    }

    public List<Produto> getPorNome(String nomePesquisar) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Produto> consulta
                = gerente.createNamedQuery("Produto.porNome", Produto.class);

        consulta.setParameter("nomequalquer", "%" + nomePesquisar + "%");

        return consulta.getResultList();

    }
}
