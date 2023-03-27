package ifsplife.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author xandy
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "Produto.todos",
            query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.porNome",
            query = "SELECT p FROM Produto p WHERE p.nome LIKE :nomequalquer")
})

@Table(name = "produtos")
// 01. Definição dos Atributos da Classe

public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Definição dos Atributos da Classe [Fornecedor];
    private int codigo_produto;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "dosagem", length = 255, nullable = true)
    private String dosagem;

    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    @Column(name = "lote", nullable = false)
    private int lote;

    @Column(name = "data_fabricacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data_fabricacao;

    @Column(name = "data_validade", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data_validade;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "valor", nullable = false)
    private double valor;

    // Definição do construtor VAZIO da Classe [Produto]; 
    public Produto() {
    }

    // Definição do construtor preenchido da Classe [Produto];
    public Produto(int codigo_produto, String nome, String dosagem, String descricao, int lote, Date data_fabricacao, Date data_validade, int quantidade, double valor) {
        this.codigo_produto = codigo_produto;
        this.nome = nome;
        this.dosagem = dosagem;
        this.descricao = descricao;
        this.lote = lote;
        this.data_fabricacao = data_fabricacao;
        this.data_validade = data_validade;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    // Definição dos Getters da Classe [Produto];
    public int getCodigo() {
        return codigo_produto;
    }

    public String getNome() {
        return nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getLote() {
        return lote;
    }

    public Date getData_fabricacao() {
        return data_fabricacao;
    }

    public Date getData_validade() {
        return data_validade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValor() {
        return valor;
    }

    // Definição dos Setters da Classe [Produto];
    public void setCodigo_produto(int codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public void setData_fabricacao(Date data_fabricacao) {
        this.data_fabricacao = data_fabricacao;
    }

    public void setData_validade(Date data_validade) {
        this.data_validade = data_validade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // Definição do EQUALS da Classe [Produto];
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.codigo_produto;
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
        return this.codigo_produto == other.codigo_produto;
    }
    // Definição do TOSTRING da Classe [Produto];

    @Override
    public String toString() {
        return "Produtos{" + "codigo_produto=" + codigo_produto + ", nome=" + nome + ", quantidade=" + quantidade + ", valor=" + valor + '}';
    }

}
