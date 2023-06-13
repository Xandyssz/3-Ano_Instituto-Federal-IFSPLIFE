package ifsplife.control;

import ifsplife.model.Convenios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControleConvenio {

    public void adicionar(Convenios convenios) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(convenios);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Convenios Convenios) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Convenios convenioExcluir = gerente.find(Convenios.class,
                Convenios.getCodigo_convenio());

        gerente.getTransaction().begin();

        gerente.remove(convenioExcluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Convenios convenios) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(convenios);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<Convenios> getTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Convenios> consulta
                = gerente.createNamedQuery("Convenios.findAll", Convenios.class);

        return consulta.getResultList();

    }

    public List<Convenios> getPorNome(String nomePesquisar) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Convenios> consulta
                = gerente.createNamedQuery("Convenios.findByNome", Convenios.class);

        consulta.setParameter("nome", "%" + nomePesquisar + "%");

        return consulta.getResultList();

    }
}