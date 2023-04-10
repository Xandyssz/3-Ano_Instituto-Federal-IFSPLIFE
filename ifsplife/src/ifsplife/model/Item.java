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

@Entity
@Table(name = "item", catalog = "ifsplife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByCodigoItem", query = "SELECT i FROM Item i WHERE i.codigoItem = :codigoItem"),
    @NamedQuery(name = "Item.findByNomeEspecifico", query = "SELECT i FROM Item i WHERE i.nome = :nome"),
    
    @NamedQuery(name = "Item.findByNomeQualquer", query = "SELECT i FROM Item i WHERE i.nome like :nome"),
    
    @NamedQuery(name = "Item.findByDosagem", query = "SELECT i FROM Item i WHERE i.dosagem = :dosagem"),
    @NamedQuery(name = "Item.findByDescricao", query = "SELECT i FROM Item i WHERE i.descricao = :descricao"),
    @NamedQuery(name = "Item.findByLote", query = "SELECT i FROM Item i WHERE i.lote = :lote"),
    @NamedQuery(name = "Item.findByDataFabricacao", query = "SELECT i FROM Item i WHERE i.dataFabricacao = :dataFabricacao"),
    @NamedQuery(name = "Item.findByDataValidade", query = "SELECT i FROM Item i WHERE i.dataValidade = :dataValidade"),
    @NamedQuery(name = "Item.findByQuantidade", query = "SELECT i FROM Item i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "Item.findByValor", query = "SELECT i FROM Item i WHERE i.valor = :valor")})
public class Item implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "codigo_item", nullable = false)
    private Integer codigoItem;
    
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;
    @Column(name = "dosagem", length = 255)
    private String dosagem;
    
    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;
    
    @Column(name = "lote", nullable = false)
    private int lote;
    
    @Column(name = "data_fabricacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataFabricacao;
    
    @Column(name = "data_validade", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataValidade;
    
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    
    @Column(name = "valor", nullable = false)
    private float valor;

    public Item() {
    }

    public Item(Integer codigoItem) {
        this.codigoItem = codigoItem;
    }

    public Item(Integer codigoItem, String nome, String descricao, int lote, Date dataFabricacao, Date dataValidade, int quantidade, float valor) {
        this.codigoItem = codigoItem;
        this.nome = nome;
        this.descricao = descricao;
        this.lote = lote;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Integer getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(Integer codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
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
        int hash = 0;
        hash += (codigoItem != null ? codigoItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.codigoItem == null && other.codigoItem != null) || (this.codigoItem != null && !this.codigoItem.equals(other.codigoItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.Item[ codigoItem=" + codigoItem + " ]";
    }
    
}
