package ifsplife.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "produtocompra")
@NamedQueries({
    @NamedQuery(name = "Produtocompra.findAll", query = "SELECT pc FROM Produtocompra pc ORDER BY pc.codigo_compra"),
    
    
    @NamedQuery(name = "Produtocompra.findByPreco", query = "SELECT i FROM Produtocompra i WHERE i.preco = :preco"),
    @NamedQuery(name = "Produtocompra.findByQuantidade", query = "SELECT i FROM Produtocompra i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "Produtocompra.findByCodigoCompra", query = "SELECT i FROM Produtocompra i WHERE i.codigo_compra = :codigo_compra"),
    @NamedQuery(name = "Produtocompra.findByCodigoItem", query = "SELECT i FROM Produtocompra i WHERE i.codigo_produto = :codigo_produto")})

@IdClass(ProdutocompraId.class)
public class Produtocompra implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "codigo_compra", referencedColumnName = "codigo_compra")
    private Compras codigo_compra;

    @Id
    @ManyToOne
    @JoinColumn(name = "codigo_produto", referencedColumnName = "codigo_produto")
    private Produto codigo_produto;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    public Produtocompra() {
    }

    public Produtocompra(Double preco, Double subtotal, int quantidade, Compras codigo_compra) {
        this.preco = preco;
        this.subtotal = subtotal;
        this.quantidade = quantidade;
        this.codigo_compra = codigo_compra;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Produto getcodigo_produto() {
        return codigo_produto;
    }

    public void setcodigo_produto(Produto codigo_produto) {
        this.codigo_produto = codigo_produto;
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
        final Produtocompra other = (Produtocompra) obj;
        return Objects.equals(this.codigo_compra, other.codigo_compra);
    }

}
