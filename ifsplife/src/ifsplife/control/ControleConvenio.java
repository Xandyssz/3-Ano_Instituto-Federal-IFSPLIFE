package ifsplife.control;

import ifsplife.model.Convenios;
import ifsplife.model.exceptions.ConvenioException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class ControleConvenio {

    public void adicionar(Convenios convenios) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(convenios);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Convenios convenios) throws ConvenioException {
        EntityManager gerente = GerenciadorConexao.getGerente();

        try {
            Convenios convenioExcluir = gerente.find(Convenios.class, convenios.getCodigo_convenio());

            if (convenioExcluir != null) {
                if (convenioExcluir.getVendas()!= null && !convenioExcluir.getVendas().isEmpty()) {
                    throw new ConvenioException("Não é possível excluir o convênio, pois existem vendas relacionadas.");
                } else {
                    gerente.getTransaction().begin();
                    gerente.remove(convenioExcluir);
                    gerente.getTransaction().commit();
                }
            } else {
                throw new ConvenioException("Convênio não encontrado para exclusão.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Este Convênio está relacionado à alguma venda. Não é possível excluí-lo.");
        }
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
