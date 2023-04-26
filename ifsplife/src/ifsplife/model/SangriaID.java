package ifsplife.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SangriaID implements Serializable {

    @Column(name = "codigo_caixa")
    private int codigoCaixa;

    @Column(name = "codigo_sangria")
    private int codigoSangria;

    public SangriaID() {
    }

    public SangriaID(int codigoCaixa, int codigoSangria) {
        this.codigoCaixa = codigoCaixa;
        this.codigoSangria = codigoSangria;
    }

    public int getCodigoCaixa() {
        return codigoCaixa;
    }

    public void setCodigoCaixa(int codigoCaixa) {
        this.codigoCaixa = codigoCaixa;
    }

    public int getCodigoSangria() {
        return codigoSangria;
    }

    public void setCodigoSangria(int codigoSangria) {
        this.codigoSangria = codigoSangria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoCaixa;
        hash += (int) codigoSangria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SangriaID)) {
            return false;
        }
        SangriaID other = (SangriaID) object;
        if (this.codigoCaixa != other.codigoCaixa) {
            return false;
        }
        if (this.codigoSangria != other.codigoSangria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.SangriaPK[ codigoCaixa=" + codigoCaixa + ", codigoSangria=" + codigoSangria + " ]";
    }

}
