package ifsplife.control;

import ifsplife.model.Caixa;
import ifsplife.model.Vendas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ControleVenda {

    // adiciona um materiaprima
    public void adicionar(Vendas vendas) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(vendas);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void remover(Vendas Vendas) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Vendas vendaExcluir = gerente.find(Vendas.class,
                Vendas.getCodigo_venda());

        gerente.getTransaction().begin();

        gerente.remove(vendaExcluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Vendas vendas) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(vendas);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<Vendas> getTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Vendas> consulta
                = gerente.createNamedQuery("Vendas.findAll", Vendas.class);

        return consulta.getResultList();

    }
    
    public double getTotalVendaPorCaixa(Caixa caixa){
        EntityManager gerente = GerenciadorConexao.getGerente();

        double total = 0;
        
        TypedQuery<Vendas> consulta
                = gerente.createNamedQuery("Vendas.findByCaixa", Vendas.class);
        consulta.setParameter("caixa", caixa);
        
        
        for(Vendas v: consulta.getResultList())
            total += v.getValor_venda();
            
        return total;
    }
    
}
