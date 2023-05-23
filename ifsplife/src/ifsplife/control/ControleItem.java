package ifsplife.control;

import ifsplife.model.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControleItem {


    // adiciona um materiaprima
    public void adicionar(Item item) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(item);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Item Item) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Item itemExcluir = gerente.find(Item.class,
                Item.getCodigo_item());

        gerente.getTransaction().begin();

        gerente.remove(itemExcluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Item item) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(item);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<Item> getTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Item> consulta
                = gerente.createNamedQuery("Item.findAll", Item.class);

        return consulta.getResultList();

    }

    public List<Item> getPorNome(String nomePesquisar) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Item> consulta
                = gerente.createNamedQuery("Item.findByNomeEspecifico", Item.class);

        consulta.setParameter("nome", "%" + nomePesquisar + "%");

        return consulta.getResultList();

    }

    public List<Item> buscarPorCategoria(String categoriaPesquisar) {
        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Item> consulta
                = gerente.createNamedQuery("Item.findByCategoria", Item.class);

        consulta.setParameter("categoria", categoriaPesquisar);

        return consulta.getResultList();
    }
}
