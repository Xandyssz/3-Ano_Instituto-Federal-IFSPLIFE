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
public class ItemvendaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigo_venda", nullable = false)
    private int codigoVenda;
    @Basic(optional = false)
    @Column(name = "codigo_produto", nullable = false)
    private int codigoProduto;

    public ItemvendaPK() {
    }

    public ItemvendaPK(int codigoVenda, int codigoProduto) {
        this.codigoVenda = codigoVenda;
        this.codigoProduto = codigoProduto;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoVenda;
        hash += (int) codigoProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemvendaPK)) {
            return false;
        }
        ItemvendaPK other = (ItemvendaPK) object;
        if (this.codigoVenda != other.codigoVenda) {
            return false;
        }
        if (this.codigoProduto != other.codigoProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.ItemvendaPK[ codigoVenda=" + codigoVenda + ", codigoProduto=" + codigoProduto + " ]";
    }
    
}
