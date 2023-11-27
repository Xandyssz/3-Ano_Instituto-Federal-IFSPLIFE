package ifsplife.control;

import ifsplife.model.Fornecedores;
import ifsplife.model.exceptions.FornecedorException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class ControleFornecedor {

    public void adicionar(Fornecedores fornecedores) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(fornecedores);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Fornecedores fornecedores) throws FornecedorException {
        EntityManager gerente = GerenciadorConexao.getGerente();

        try {
            Fornecedores fornecedorExcluir = gerente.find(Fornecedores.class, fornecedores.getCodigo_fornecedor());

            if (fornecedorExcluir != null) {
                if (fornecedorExcluir.getCompras() != null && !fornecedorExcluir.getCompras().isEmpty()) {
                    throw new FornecedorException("Não é possível excluir o fornecedor, pois existem compras relacionadas.");
                } else {
                    gerente.getTransaction().begin();
                    gerente.remove(fornecedorExcluir);
                    gerente.getTransaction().commit();
                }
            } else {
                throw new FornecedorException("Fornecedor não encontrado para exclusão.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Este Fornecedor está relacionado à alguma compra. Não é possível excluí-lo.");
        }
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
                = gerente.createNamedQuery("Fornecedores.findAll", Fornecedores.class
                );

        return consulta.getResultList();

    }

    public List<Fornecedores> getPorNome(String nomePesquisar) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Fornecedores> consulta
                = gerente.createNamedQuery("Fornecedores.findByNome", Fornecedores.class
                );

        consulta.setParameter("nome", "%" + nomePesquisar + "%");

        return consulta.getResultList();

    }
}
