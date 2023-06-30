package ifsplife.model;

import java.io.Serializable;

public class ProdutocompraId implements Serializable {

    private int codigo_compra;
    private int codigo_produto;

    public ProdutocompraId() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.codigo_compra;
        hash = 97 * hash + this.codigo_produto;
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
        final ProdutocompraId other = (ProdutocompraId) obj;
        if (this.codigo_compra != other.codigo_compra) {
            return false;
        }
        return this.codigo_produto == other.codigo_produto;
    }

}
