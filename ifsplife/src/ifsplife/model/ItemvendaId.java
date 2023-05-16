package ifsplife.model;

import java.io.Serializable;
import javax.persistence.Column;

public class ItemvendaId implements Serializable {

    private int codigo_venda;
    private int codigo_item;

    public ItemvendaId() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.codigo_venda;
        hash = 73 * hash + this.codigo_item;
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
        final ItemvendaId other = (ItemvendaId) obj;
        if (this.codigo_venda != other.codigo_venda) {
            return false;
        }
        return this.codigo_item == other.codigo_item;
    }

}
