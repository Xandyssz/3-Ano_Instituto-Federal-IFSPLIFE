package ifsplife.control;

import ifsplife.model.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControleProduto {

    public void adicionar(Produto produto) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(produto);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Produto produto) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Produto produtoExcluir = gerente.find(Produto.class,
                produto.getcodigo_produto());

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
                = gerente.createNamedQuery("Produto.findAll", Produto.class);

        return consulta.getResultList();

    }

    public List<Produto> getPorNome(String nomePesquisar) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Produto> consulta
                = gerente.createNamedQuery("Produto.findByNome", Produto.class);

        consulta.setParameter("nome", "%" + nomePesquisar + "%");

        return consulta.getResultList();

    }

    public List<Produto> buscarPorCategoria(String categoriaPesquisar) {
        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Produto> consulta
                = gerente.createNamedQuery("Produto.findByCategoria", Produto.class);

        consulta.setParameter("categoria", categoriaPesquisar);

        return consulta.getResultList();
    }
}
