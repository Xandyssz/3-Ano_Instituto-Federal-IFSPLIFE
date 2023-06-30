package ifsplife.model;

import java.io.Serializable;
import java.util.Objects;
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
@Table(name = "produtovenda")
@NamedQueries({
    @NamedQuery(name = "Produtovenda.findAll", query = "SELECT i FROM Produtovenda i"),
    @NamedQuery(name = "Produtovenda.findByPreco", query = "SELECT i FROM Produtovenda i WHERE i.preco = :preco"),
    @NamedQuery(name = "Produtovenda.findByQuantidade", query = "SELECT i FROM Produtovenda i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "Produtovenda.findByCodigoItem", query = "SELECT i FROM Produtovenda i WHERE i.codigo_produto = :codigo_produto"),
    @NamedQuery(name = "Produtovenda.findByCodigoVenda", query = "SELECT i FROM Produtovenda i WHERE i.codigo_venda = :codigo_venda")})

@IdClass(ProdutovendaId.class)

public class Produtovenda implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "codigo_venda", referencedColumnName = "codigo_venda")
    private Vendas codigo_venda;

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

    public Produtovenda() {
    }

    public Produtovenda(Double preco, Double subtotal, int quantidade, Vendas codigo_venda) {
        this.preco = preco;
        this.subtotal = subtotal;
        this.quantidade = quantidade;
        this.codigo_venda = codigo_venda;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Vendas getCodigo_venda() {
        return codigo_venda;
    }

    public void setCodigo_venda(Vendas codigo_venda) {
        this.codigo_venda = codigo_venda;
    }

    public Produto getcodigo_produto() {
        return codigo_produto;
    }

    public void setcodigo_produto(Produto codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo_venda);
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
        final Produtovenda other = (Produtovenda) obj;
        return Objects.equals(this.codigo_venda, other.codigo_venda);
    }

}
