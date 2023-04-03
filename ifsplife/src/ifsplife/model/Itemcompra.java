/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author xandy
 */
@Entity
@Table(name = "itemcompra", catalog = "ifsplife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Itemcompra.findAll", query = "SELECT i FROM Itemcompra i"),
    @NamedQuery(name = "Itemcompra.findByCodigoCompra", query = "SELECT i FROM Itemcompra i WHERE i.itemcompraPK.codigoCompra = :codigoCompra"),
    @NamedQuery(name = "Itemcompra.findByCodigoProduto", query = "SELECT i FROM Itemcompra i WHERE i.itemcompraPK.codigoProduto = :codigoProduto"),
    @NamedQuery(name = "Itemcompra.findByQuantidade", query = "SELECT i FROM Itemcompra i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "Itemcompra.findByPreco", query = "SELECT i FROM Itemcompra i WHERE i.preco = :preco")})
public class Itemcompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemcompraPK itemcompraPK;
    @Basic(optional = false)
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    @Basic(optional = false)
    @Column(name = "preco", nullable = false)
    private float preco;
    @JoinColumn(name = "codigo_compra", referencedColumnName = "codigo_compra", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compras compras;
    @JoinColumn(name = "codigo_produto", referencedColumnName = "codigo_produto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;

    public Itemcompra() {
    }

    public Itemcompra(ItemcompraPK itemcompraPK) {
        this.itemcompraPK = itemcompraPK;
    }

    public Itemcompra(ItemcompraPK itemcompraPK, int quantidade, float preco) {
        this.itemcompraPK = itemcompraPK;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Itemcompra(int codigoCompra, int codigoProduto) {
        this.itemcompraPK = new ItemcompraPK(codigoCompra, codigoProduto);
    }

    public ItemcompraPK getItemcompraPK() {
        return itemcompraPK;
    }

    public void setItemcompraPK(ItemcompraPK itemcompraPK) {
        this.itemcompraPK = itemcompraPK;
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

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }

    public Item getItem() {
        return item;
    }

    public void setProdutos(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemcompraPK != null ? itemcompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemcompra)) {
            return false;
        }
        Itemcompra other = (Itemcompra) object;
        if ((this.itemcompraPK == null && other.itemcompraPK != null) || (this.itemcompraPK != null && !this.itemcompraPK.equals(other.itemcompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.Itemcompra[ itemcompraPK=" + itemcompraPK + " ]";
    }

}
