package ifsplife.model;

import java.io.Serializable;

public class PagamentocompraId {

    private int codigo_compra;
    private int parcela;

    public PagamentocompraId() {
    }

    public PagamentocompraId(int codigo_compra, int parcela) {
        this.codigo_compra = codigo_compra;
        this.parcela = parcela;
    }

    public int getCodigo_compra() {
        return codigo_compra;
    }

    public void setCodigo_compra(int codigo_compra) {
        this.codigo_compra = codigo_compra;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.codigo_compra;
        hash = 97 * hash + this.parcela;
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
        final PagamentocompraId other = (PagamentocompraId) obj;
        if (this.codigo_compra != other.codigo_compra) {
            return false;
        }
        return this.parcela == other.parcela;
    }

}
