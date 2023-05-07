package ifsplife.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "itemvenda")
@NamedQueries({
    @NamedQuery(name = "Itemvenda.findAll", query = "SELECT i FROM Itemvenda i"),
    @NamedQuery(name = "Itemvenda.findByCodigoVenda", query = "SELECT i FROM Itemvenda i WHERE i.itemvendaPK.codigoVenda = :codigoVenda"),
    @NamedQuery(name = "Itemvenda.findByCodigoProduto", query = "SELECT i FROM Itemvenda i WHERE i.itemvendaPK.codigoProduto = :codigoProduto"),
    @NamedQuery(name = "Itemvenda.findByQuantidade", query = "SELECT i FROM Itemvenda i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "Itemvenda.findByPreco", query = "SELECT i FROM Itemvenda i WHERE i.preco = :preco")})
public class Itemvenda implements Serializable {

    @EmbeddedId
    protected ItemvendaPK itemvendaPK;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "preco")
    private float preco;
    @JoinColumn(name = "codigo_venda", referencedColumnName = "codigo_venda", insertable = false, updatable = false)
    @ManyToOne
    private Vendas vendas;

    public Itemvenda() {
    }

    public Itemvenda(ItemvendaPK itemvendaPK) {
        this.itemvendaPK = itemvendaPK;
    }

    public Itemvenda(ItemvendaPK itemvendaPK, int quantidade, float preco) {
        this.itemvendaPK = itemvendaPK;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Itemvenda(int codigoVenda, int codigoProduto) {
        this.itemvendaPK = new ItemvendaPK(codigoVenda, codigoProduto);
    }

    public ItemvendaPK getItemvendaPK() {
        return itemvendaPK;
    }

    public void setItemvendaPK(ItemvendaPK itemvendaPK) {
        this.itemvendaPK = itemvendaPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Vendas getVendas() {
        return vendas;
    }

    public void setVendas(Vendas vendas) {
        this.vendas = vendas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemvendaPK != null ? itemvendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Itemvenda)) {
            return false;
        }
        Itemvenda other = (Itemvenda) object;
        if ((this.itemvendaPK == null && other.itemvendaPK != null) || (this.itemvendaPK != null && !this.itemvendaPK.equals(other.itemvendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.Itemvenda[ itemvendaPK=" + itemvendaPK + " ]";
    }

}
