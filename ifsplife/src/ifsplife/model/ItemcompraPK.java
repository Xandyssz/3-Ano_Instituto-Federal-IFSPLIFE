package ifsplife.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItemcompraPK implements Serializable {

    
    @Column(name = "codigo_compra", nullable = false)
    private int codigoCompra;
    
    @Column(name = "codigo_produto", nullable = false)
    private int codigoProduto;

    public ItemcompraPK() {
    }

    public ItemcompraPK(int codigoCompra, int codigoProduto) {
        this.codigoCompra = codigoCompra;
        this.codigoProduto = codigoProduto;
    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
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
        hash += (int) codigoCompra;
        hash += (int) codigoProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ItemcompraPK)) {
            return false;
        }
        ItemcompraPK other = (ItemcompraPK) object;
        if (this.codigoCompra != other.codigoCompra) {
            return false;
        }
        if (this.codigoProduto != other.codigoProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.ItemcompraPK[ codigoCompra=" + codigoCompra + ", codigoProduto=" + codigoProduto + " ]";
    }

}
