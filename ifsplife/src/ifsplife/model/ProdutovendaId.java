package ifsplife.model;

import java.io.Serializable;

public class ProdutovendaId implements Serializable {

    private int codigo_venda;
    private int codigo_produto;

    public ProdutovendaId() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.codigo_venda;
        hash = 73 * hash + this.codigo_produto;
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
        final ProdutovendaId other = (ProdutovendaId) obj;
        if (this.codigo_venda != other.codigo_venda) {
            return false;
        }
        return this.codigo_produto == other.codigo_produto;
    }

}
