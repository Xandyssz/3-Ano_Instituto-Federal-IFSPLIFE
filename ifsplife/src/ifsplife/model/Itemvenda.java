package ifsplife.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itemvenda", catalog = "ifsplife", schema = "")
public class Itemvenda implements Serializable {

    
    @EmbeddedId
    protected ItemvendaId itemvendaPK;
    
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    
    @Column(name = "preco", nullable = false)
    private float preco;
    
    @JoinColumn(name = "codigo_produto", referencedColumnName = "codigo_produto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;
    
    @JoinColumn(name = "codigo_venda", referencedColumnName = "codigo_venda", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vendas vendas;

    public Itemvenda() {
    }

    public Itemvenda(ItemvendaId itemvendaPK) {
        this.itemvendaPK = itemvendaPK;
    }

    public Itemvenda(ItemvendaId itemvendaPK, int quantidade, float preco) {
        this.itemvendaPK = itemvendaPK;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Itemvenda(int codigoVenda, int codigoProduto) {
        this.itemvendaPK = new ItemvendaId(codigoVenda, codigoProduto);
    }

    public ItemvendaId getItemvendaPK() {
        return itemvendaPK;
    }

    public void setItemvendaPK(ItemvendaId itemvendaPK) {
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
