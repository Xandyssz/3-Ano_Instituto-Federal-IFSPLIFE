package ifsplife.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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

@Entity
@Table(name = "item")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")})
public class Item implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "codigo_item", nullable = false)
    private Integer codigo_item;
    
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
    
    @Column(name = "lote", nullable = false)
    private int lote;
    
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;
    
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    
    @Column(name = "valor", nullable = false)
    private float valor;

    public Item() {
    }

    public Item(Integer codigo_item, String categoria, Date data_fabricacao, Date data_validade, String descricao, String dosagem, int lote, String nome, int quantidade, float valor) {
        this.codigo_item = codigo_item;
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

    public Integer getCodigo_item() {
        return codigo_item;
    }

    public void setCodigo_item(Integer codigo_item) {
        this.codigo_item = codigo_item;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo_item);
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
        final Item other = (Item) obj;
        return Objects.equals(this.codigo_item, other.codigo_item);
    }

}
