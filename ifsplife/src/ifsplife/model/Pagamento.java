package ifsplife.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento")
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p")})

@IdClass(PagamentoId.class)
public class Pagamento implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "codigo_venda", referencedColumnName = "codigo_venda")
    private Vendas codigo_venda;

    @Id
    @Column(name = "codigo_pagamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo_pagamento;

    @Column(name = "forma", nullable = false, length = 10)
    private String forma;

    @Column(name = "valor", nullable = false)
    private double valor;

    public Pagamento() {
    }

    public Pagamento(String forma, double valor, Vendas codigo_venda) {
        this.forma = forma;
        this.valor = valor;
        this.codigo_venda = codigo_venda;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Vendas getCodigo_venda() {
        return codigo_venda;
    }

    public void setCodigo_venda(Vendas codigo_venda) {
        this.codigo_venda = codigo_venda;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.codigo_venda);
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
        final Pagamento other = (Pagamento) obj;
        return Objects.equals(this.codigo_venda, other.codigo_venda);
    }

}
