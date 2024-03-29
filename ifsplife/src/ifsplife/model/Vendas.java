package ifsplife.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "vendas")
@NamedQueries({
    @NamedQuery(name = "Vendas.findAll", query = "SELECT v FROM Vendas v"),

    @NamedQuery(name = "Vendas.findByCodigoVenda", query = "SELECT v FROM Vendas v WHERE v.codigo_venda = :codigoVenda"),
    @NamedQuery(name = "Vendas.findByDataVenda", query = "SELECT v FROM Vendas v WHERE v.data_venda = :dataVenda"),
    @NamedQuery(name = "Vendas.findByPeriodo", query = "SELECT v FROM Vendas v WHERE v.data_venda BETWEEN :datainicio AND :datafim"),
    @NamedQuery(name = "Vendas.itensPorPeriodos", query = "SELECT pv FROM Produtovenda pv WHERE pv.codigo_venda.data_venda BETWEEN :datainicio AND :datafim ORDER BY pv.codigo_venda"),
    @NamedQuery(name = "Vendas.findByFormaPagamento", query = "SELECT v FROM Vendas v WHERE v.forma_pagamento = :formaPagamento"),
    @NamedQuery(name = "Vendas.findByCaixa", query = "SELECT v FROM Vendas v WHERE v.codigo_caixa = :caixa"),
    @NamedQuery(name = "Vendas.findByValorVenda", query = "SELECT v FROM Vendas v WHERE v.valor_venda = :valorVenda")})
public class Vendas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_venda", nullable = false)
    private Integer codigo_venda;

    @Column(name = "data_venda", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data_venda;

    @Column(name = "forma_pagamento", nullable = false)
    private String forma_pagamento;

    @Column(name = "valor_venda", nullable = false)
    private double valor_venda;

    @ManyToOne
    @JoinColumn(name = "codigo_caixa", referencedColumnName = "codigo_caixa")
    private Caixa codigo_caixa;

    @ManyToOne
    @JoinColumn(name = "codigo_convenio", referencedColumnName = "codigo_convenio")
    private Convenios codigo_convenio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigo_venda")
    private List<Produtovenda> ProdutovendaList = new ArrayList<>();

    public Vendas() {
    }

    public Vendas(Integer codigo_venda, Date data_venda, String forma_pagamento, Double valor_venda, Caixa codigo_caixa, Convenios codigo_convenio) {
        this.codigo_venda = codigo_venda;
        this.data_venda = data_venda;
        this.forma_pagamento = forma_pagamento;
        this.valor_venda = valor_venda;
        this.codigo_caixa = codigo_caixa;
        this.codigo_convenio = codigo_convenio;
    }

    public Integer getCodigo_venda() {
        return codigo_venda;
    }

    public void setCodigo_venda(Integer codigo_venda) {
        this.codigo_venda = codigo_venda;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public double getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(Double valor_venda) {
        this.valor_venda = valor_venda;
    }

    public Caixa getcodigo_caixa() {
        return codigo_caixa;
    }

    public void setcodigo_caixa(Caixa codigo_caixa) {
        this.codigo_caixa = codigo_caixa;
    }

    public Convenios getCodigo_convenio() {
        return codigo_convenio;
    }

    public void setCodigo_convenio(Convenios codigo_convenio) {
        this.codigo_convenio = codigo_convenio;
    }

    public void adicionarItem(Produtovenda iv) {
        iv.setCodigo_venda(this);
        this.ProdutovendaList.add(iv);
    }

    public List<Produtovenda> getProdutovendaList() {
        return ProdutovendaList;
    }

    public void setProdutovendaList(List<Produtovenda> ProdutovendaList) {
        this.ProdutovendaList = ProdutovendaList;
    }

    ///// ACESSAR PRODUTOVENDAS
    public void listarProdutosVenda() {
        for (Produtovenda produtovenda : ProdutovendaList) {
            System.out.println("Preço Unitário: " + produtovenda.getPreco());
            System.out.println("Quantidade Vendida: " + produtovenda.getQuantidade());
            System.out.println("Preço Unitário: " + produtovenda.getSubtotal());
            System.out.println("Código do Produto: " + produtovenda.getcodigo_produto());
            System.out.println("Preço Unitário: " + produtovenda.getPreco());
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.codigo_venda);
        hash = 23 * hash + Objects.hashCode(this.codigo_caixa);
        hash = 23 * hash + Objects.hashCode(this.codigo_convenio);
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
        final Vendas other = (Vendas) obj;
        if (!Objects.equals(this.codigo_venda, other.codigo_venda)) {
            return false;
        }
        if (!Objects.equals(this.codigo_caixa, other.codigo_caixa)) {
            return false;
        }
        return Objects.equals(this.codigo_convenio, other.codigo_convenio);
    }

}
