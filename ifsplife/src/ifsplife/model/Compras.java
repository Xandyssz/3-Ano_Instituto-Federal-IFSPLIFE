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
@Table(name = "compras")
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findByCodigoCompra", query = "SELECT c FROM Compras c WHERE c.codigo_compra = :codigoCompra"),
    @NamedQuery(name = "Compras.findByDataCompra", query = "SELECT c FROM Compras c WHERE c.data_compra = :dataCompra"),
    @NamedQuery(name = "Compras.findByFormaPagamento", query = "SELECT c FROM Compras c WHERE c.forma_pagamento = :formaPagamento"),
    @NamedQuery(name = "Compras.findByPeriodo", query = "SELECT c FROM Compras c WHERE c.data_compra BETWEEN :datainicio AND :datafim"),
    @NamedQuery(name = "Compras.findByValortotal", query = "SELECT c FROM Compras c WHERE c.valortotal = :valortotal")})

public class Compras implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_compra", nullable = false)
    private Integer codigo_compra;

    @Column(name = "data_compra", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data_compra;

    @Column(name = "forma_pagamento", nullable = false)
    private String forma_pagamento;

    @Column(name = "valortotal", nullable = false)
    private double valortotal;

    @OneToMany(cascade = CascadeType.PERSIST,
            orphanRemoval = true,
            mappedBy = "codigo_compra")
    private List<Produtocompra> itemcompra = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST,
            orphanRemoval = true,
            mappedBy = "codigo_compra")
    private List<Pagamentocompra> pagamentocompra;

    @ManyToOne
    @JoinColumn(name = "codigo_fornecedor", referencedColumnName = "codigo_fornecedor")
    private Fornecedores codigo_fornecedor;

    public Compras() {
    }

    public Compras(Integer codigo_compra, Date data_compra, String forma_pagamento, double valortotal, List<Pagamentocompra> pagamentocompra, Fornecedores codigo_fornecedor) {
        this.codigo_compra = codigo_compra;
        this.data_compra = data_compra;
        this.forma_pagamento = forma_pagamento;
        this.valortotal = valortotal;
        this.pagamentocompra = pagamentocompra;
        this.codigo_fornecedor = codigo_fornecedor;
    }

    public Integer getCodigo_compra() {
        return codigo_compra;
    }

    public void setCodigo_compra(Integer codigo_compra) {
        this.codigo_compra = codigo_compra;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public void adicionarItem(Produtocompra ic) {
        ic.setCodigo_compra(this);
        this.itemcompra.add(ic);
    }

    public List<Produtocompra> getItemcompra() {
        return itemcompra;
    }

    public void setItemcompra(List<Produtocompra> itemcompra) {
        this.itemcompra = itemcompra;
    }

    public List<Pagamentocompra> getPagamentocompra() {
        return pagamentocompra;
    }

    public void setPagamentocompra(List<Pagamentocompra> pagamentocompra) {
        this.pagamentocompra = pagamentocompra;
        for (Pagamentocompra p : pagamentocompra) {
            p.setCodigo_compra(this);
        }
    }

    public Fornecedores getCodigo_fornecedor() {
        return codigo_fornecedor;
    }

    public void setCodigo_fornecedor(Fornecedores codigo_fornecedor) {
        this.codigo_fornecedor = codigo_fornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.codigo_compra);
        hash = 71 * hash + Objects.hashCode(this.codigo_fornecedor);
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
        final Compras other = (Compras) obj;
        if (!Objects.equals(this.codigo_compra, other.codigo_compra)) {
            return false;
        }
        return Objects.equals(this.codigo_fornecedor, other.codigo_fornecedor);
    }

}
