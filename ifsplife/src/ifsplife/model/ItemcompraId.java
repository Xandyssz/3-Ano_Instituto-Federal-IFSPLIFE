package ifsplife.model;

import java.io.Serializable;

public class ItemcompraId implements Serializable {

    private int codigo_compra;
    private int codigo_item;

    public ItemcompraId() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.codigo_compra;
        hash = 97 * hash + this.codigo_item;
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
        final ItemcompraId other = (ItemcompraId) obj;
        if (this.codigo_compra != other.codigo_compra) {
            return false;
        }
        return this.codigo_item == other.codigo_item;
    }

}
