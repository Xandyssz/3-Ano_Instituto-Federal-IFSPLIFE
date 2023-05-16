package ifsplife.model;

import java.io.Serializable;

public class CaixaDespesasId implements Serializable {

    private int codigo_despesa;
    private int codigo_caixa;

    public CaixaDespesasId() {
    }

    public CaixaDespesasId(int codigo_despesa, int codigo_caixa) {
        this.codigo_despesa = codigo_despesa;
        this.codigo_caixa = codigo_caixa;
    }

    public int getCodigo_despesa() {
        return codigo_despesa;
    }

    public void setCodigo_despesa(int codigo_despesa) {
        this.codigo_despesa = codigo_despesa;
    }

    public int getCodigo_caixa() {
        return codigo_caixa;
    }

    public void setCodigo_caixa(int codigo_caixa) {
        this.codigo_caixa = codigo_caixa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.codigo_despesa;
        hash = 53 * hash + this.codigo_caixa;
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
        final CaixaDespesasId other = (CaixaDespesasId) obj;
        if (this.codigo_despesa != other.codigo_despesa) {
            return false;
        }
        return this.codigo_caixa == other.codigo_caixa;
    }

}
