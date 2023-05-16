package ifsplife.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "caixa_despesas", catalog = "ifsplife", schema = "")
@NamedQueries({
    @NamedQuery(name = "CaixaDespesas.findAll", query = "SELECT c FROM CaixaDespesas c")})

@IdClass(CaixaDespesasId.class)

public class CaixaDespesas implements Serializable {

    @Column(name = "data_pagamento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data_pagamento;

    @Id
    @ManyToOne
    @JoinColumn(name = "codigo_caixa", referencedColumnName = "codigo_caixa")
    private Caixa codigo_caixa;

    @Id
    @ManyToOne
    @JoinColumn(name = "codigo_despesa", referencedColumnName = "codigo_despesa")
    private Despesas codigo_despesa;

    public CaixaDespesas() {
    }

    public CaixaDespesas(Date data_pagamento, Caixa codigo_caixa, Despesas codigo_despesa) {
        this.data_pagamento = data_pagamento;
        this.codigo_caixa = codigo_caixa;
        this.codigo_despesa = codigo_despesa;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public Caixa getCodigo_caixa() {
        return codigo_caixa;
    }

    public void setCodigo_caixa(Caixa codigo_caixa) {
        this.codigo_caixa = codigo_caixa;
    }

    public Despesas getCodigo_despesa() {
        return codigo_despesa;
    }

    public void setCodigo_despesa(Despesas codigo_despesa) {
        this.codigo_despesa = codigo_despesa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.codigo_caixa);
        hash = 53 * hash + Objects.hashCode(this.codigo_despesa);
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
        final CaixaDespesas other = (CaixaDespesas) obj;
        if (!Objects.equals(this.codigo_caixa, other.codigo_caixa)) {
            return false;
        }
        return Objects.equals(this.codigo_despesa, other.codigo_despesa);
    }

}
