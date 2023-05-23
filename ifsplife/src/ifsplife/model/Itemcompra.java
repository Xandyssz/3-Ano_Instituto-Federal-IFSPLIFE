package ifsplife.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "itemcompra")
@NamedQueries({
    @NamedQuery(name = "Itemcompra.findAll", query = "SELECT i FROM Itemcompra i"),
    @NamedQuery(name = "Itemcompra.findByPreco", query = "SELECT i FROM Itemcompra i WHERE i.preco = :preco"),
    @NamedQuery(name = "Itemcompra.findByQuantidade", query = "SELECT i FROM Itemcompra i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "Itemcompra.findByCodigoCompra", query = "SELECT i FROM Itemcompra i WHERE i.codigo_compra = :codigoCompra"),
    @NamedQuery(name = "Itemcompra.findByCodigoItem", query = "SELECT i FROM Itemcompra i WHERE i.codigo_item = :codigoItem")})

@IdClass(ItemcompraId.class)
public class Itemcompra implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "codigo_compra", referencedColumnName = "codigo_compra")
    private Compras codigo_compra;

    @Id
    @ManyToOne
    @JoinColumn(name = "codigo_item", referencedColumnName = "codigo_item")
    private Item codigo_item;

    @Column(name = "preco", nullable = false)
    private float preco;

    @Column(name = "subtotal", nullable = false)
    private float subtotal;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    public Itemcompra() {
    }

    public Itemcompra(float preco, float subtotal, int quantidade, Compras codigo_compra) {
        this.preco = preco;
        this.subtotal = subtotal;
        this.quantidade = quantidade;
        this.codigo_compra = codigo_compra;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public Item getCodigo_item() {
        return codigo_item;
    }

    public void setCodigo_item(Item codigo_item) {
        this.codigo_item = codigo_item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Compras getCodigo_compra() {
        return codigo_compra;
    }

    public void setCodigo_compra(Compras codigo_compra) {
        this.codigo_compra = codigo_compra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codigo_compra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Itemcompra other = (Itemcompra) obj;
        return Objects.equals(this.codigo_compra, other.codigo_compra);
    }

}
