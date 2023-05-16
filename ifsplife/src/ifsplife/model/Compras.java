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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "compras")
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c")})
public class Compras implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_compra", nullable = false)
    private Integer codigo_compra;

    @Column(name = "data_compra", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data_compra;

    @Column(name = "forma_pagamento", nullable = false)
    private Character forma_pagamento;

    @Column(name = "valortotal", nullable = false)
    private double valortotal;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "codigo_compra")
    private List<Itemcompra> itemcompra = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "codigo_compra")
    private Pagamentocompra pagamentocompra;

    @ManyToOne
    @JoinColumn(name = "codigo_fornecedor", referencedColumnName = "codigo_fornecedor")
    private Fornecedores codigo_fornecedor;

    public Compras() {
    }

    public Compras(Integer codigo_compra, Date data_compra, Character forma_pagamento, double valortotal, Pagamentocompra pagamentocompra, Fornecedores codigo_fornecedor) {
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

    public Character getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(Character forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public List<Itemcompra> getItemcompra() {
        return itemcompra;
    }

    public void setItemcompra(List<Itemcompra> itemcompra) {
        this.itemcompra = itemcompra;
    }

    public Pagamentocompra getPagamentocompra() {
        return pagamentocompra;
    }

    public void setPagamentocompra(Pagamentocompra pagamentocompra) {
        this.pagamentocompra = pagamentocompra;
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
