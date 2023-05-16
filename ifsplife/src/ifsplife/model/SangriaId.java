package ifsplife.model;

import java.io.Serializable;

public class SangriaId implements Serializable {

    private int codigo_caixa;
    private int codigo_sangria;

    public SangriaId() {
    }

    public SangriaId(int codigo_caixa, int codigo_sangria) {
        this.codigo_caixa = codigo_caixa;
        this.codigo_sangria = codigo_sangria;
    }

    public int getCodigo_caixa() {
        return codigo_caixa;
    }

    public void setCodigo_caixa(int codigo_caixa) {
        this.codigo_caixa = codigo_caixa;
    }

    public int getCodigo_sangria() {
        return codigo_sangria;
    }

    public void setCodigo_sangria(int codigo_sangria) {
        this.codigo_sangria = codigo_sangria;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.codigo_caixa;
        hash = 73 * hash + this.codigo_sangria;
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
        final SangriaId other = (SangriaId) obj;
        if (this.codigo_caixa != other.codigo_caixa) {
            return false;
        }
        return this.codigo_sangria == other.codigo_sangria;
    }

}
