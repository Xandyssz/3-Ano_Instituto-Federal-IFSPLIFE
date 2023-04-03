/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsplife.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author xandy
 */
@Embeddable
public class PagamentoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigo_pagamento", nullable = false)
    private int codigoPagamento;
    @Basic(optional = false)
    @Column(name = "codigo_venda", nullable = false)
    private int codigoVenda;

    public PagamentoPK() {
    }

    public PagamentoPK(int codigoPagamento, int codigoVenda) {
        this.codigoPagamento = codigoPagamento;
        this.codigoVenda = codigoVenda;
    }

    public int getCodigoPagamento() {
        return codigoPagamento;
    }

    public void setCodigoPagamento(int codigoPagamento) {
        this.codigoPagamento = codigoPagamento;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoPagamento;
        hash += (int) codigoVenda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagamentoPK)) {
            return false;
        }
        PagamentoPK other = (PagamentoPK) object;
        if (this.codigoPagamento != other.codigoPagamento) {
            return false;
        }
        if (this.codigoVenda != other.codigoVenda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.PagamentoPK[ codigoPagamento=" + codigoPagamento + ", codigoVenda=" + codigoVenda + " ]";
    }
    
}
