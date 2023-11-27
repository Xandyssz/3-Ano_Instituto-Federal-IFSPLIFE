package ifsplife.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "produto")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT i FROM Produto i"),
    @NamedQuery(name = "Produto.findByCodigoProduto", query = "SELECT i FROM Produto i WHERE i.codigo_produto = :codigo_produto"),
    @NamedQuery(name = "Produto.findByCategoria", query = "SELECT i FROM Produto i WHERE i.categoria = :categoria"),
    @NamedQuery(name = "Produto.findByDataFabricacao", query = "SELECT i FROM Produto i WHERE i.data_fabricacao = :data_fabricacao"),
    @NamedQuery(name = "Produto.findByDataValidade", query = "SELECT i FROM Produto i WHERE i.data_validade = :data_validade"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT i FROM Produto i WHERE i.descricao = :descricao"),
    @NamedQuery(name = "Produto.findByDosagem", query = "SELECT i FROM Produto i WHERE i.dosagem = :dosagem"),
    @NamedQuery(name = "Produto.findByLote", query = "SELECT i FROM Produto i WHERE i.lote = :lote"),
    @NamedQuery(name = "Produto.findByNome", query = "SELECT i FROM Produto i WHERE i.nome like :nome"),
    
    
    @NamedQuery(name = "Produto.findByQuantidade", query = "SELECT i FROM Produto i WHERE i.quantidade < 10"),
    
    
    @NamedQuery(name = "Produto.findByValor", query = "SELECT i FROM Produto i WHERE i.valor = :valor")})

public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_produto", nullable = false)
    private int codigo_produto;

    @Column(name = "categoria", nullable = false, length = 45)
    private String categoria;

    @Column(name = "data_fabricacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data_fabricacao;

    @Column(name = "data_validade", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data_validade;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "dosagem", length = 255)
    private String dosagem;

    @Column(name = "lote", nullable = false, length = 45)
    private int lote;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "quantidade", nullable = false, length = 45)
    private int quantidade;

    @Column(name = "valor", nullable = false, length = 45)
    private double valor;

    
        @OneToMany(mappedBy = "codigo_produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produtocompra> produtosCompra;

    @OneToMany(mappedBy = "codigo_produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produtovenda> produtosVenda;

    public int getCodigo_produto() {
        return codigo_produto;
    }

    public void setCodigo_produto(int codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public List<Produtocompra> getProdutosCompra() {
        return produtosCompra;
    }

    public void setProdutosCompra(List<Produtocompra> produtosCompra) {
        this.produtosCompra = produtosCompra;
    }

    public List<Produtovenda> getProdutosVenda() {
        return produtosVenda;
    }

    public void setProdutosVenda(List<Produtovenda> produtosVenda) {
        this.produtosVenda = produtosVenda;
    }
    
    
    public Produto() {
    }

    public Produto(int codigo_produto, String categoria, Date data_fabricacao, Date data_validade, String descricao, String dosagem, int lote, String nome, int quantidade, double valor) {
        this.codigo_produto = codigo_produto;
        this.categoria = categoria;
        this.data_fabricacao = data_fabricacao;
        this.data_validade = data_validade;
        this.descricao = descricao;
        this.dosagem = dosagem;
        this.lote = lote;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    // METODO PARA ATUALIZAR O ESTOQUE, QUANDO REALIZA UMA  VENDA
    public void atualizarEstoqueVenda(int quantidadeVendida) {
        this.quantidade -= quantidadeVendida;
    }

    // METODO PARA ATUALIZAR O ESTOQUE, QUANDO REALIZA UMA COMPRA
    public void atualizarEstoqueCompra(int quantidadeComprada) {
        this.quantidade += quantidadeComprada;
    }
    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public int getcodigo_produto() {
        return codigo_produto;
    }

    public void setcodigo_produto(int codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getData_fabricacao() {
        return data_fabricacao;
    }

    public void setData_fabricacao(Date data_fabricacao) {
        this.data_fabricacao = data_fabricacao;
    }

    public Date getData_validade() {
        return data_validade;
    }

    public void setData_validade(Date data_validade) {
        this.data_validade = data_validade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo_produto);
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
        final Produto other = (Produto) obj;
        return Objects.equals(this.codigo_produto, other.codigo_produto);
    }

}
