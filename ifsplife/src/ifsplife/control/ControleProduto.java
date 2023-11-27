package ifsplife.control;

import ifsplife.model.Produto;
import ifsplife.model.exceptions.ProdutoException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class ControleProduto {

    public void adicionar(Produto produto) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(produto);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Produto produto) throws ProdutoException {
        EntityManager gerente = GerenciadorConexao.getGerente();

        try {
            Produto produtoExcluir = gerente.find(Produto.class, produto.getcodigo_produto());

            if (produtoExcluir != null) {
                if (temComprasRelacionadas(produtoExcluir) || temVendasRelacionadas(produtoExcluir)) {
                    throw new ProdutoException("Não é possível excluir o produto, pois existem compras/vendas relacionadas a ele.");
                } else {
                    gerente.getTransaction().begin();
                    gerente.remove(produtoExcluir);
                    gerente.getTransaction().commit();
                }
            } else {
                throw new ProdutoException("Produto não encontrado para exclusão.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Este Produto está relacionado à alguma compra/venda. Não é possível excluí-lo.");
        }
    }


    private boolean temComprasRelacionadas(Produto produto) {
        return produto.getProdutosCompra() != null && !produto.getProdutosCompra().isEmpty();
    }

    private boolean temVendasRelacionadas(Produto produto) {
        return produto.getProdutosVenda() != null && !produto.getProdutosVenda().isEmpty();
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

    public List<Produto> quantidadeProduto() {
        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Produto> consulta = gerente.createNamedQuery("Produto.findByQuantidade", Produto.class);

        return consulta.getResultList();
    }
}
