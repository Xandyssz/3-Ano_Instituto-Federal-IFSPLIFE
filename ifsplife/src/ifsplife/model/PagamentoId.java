package ifsplife.model;

import java.io.Serializable;

public class PagamentoId implements Serializable {

    private int codigo_venda;
    private int codigo_pagamento;

    public PagamentoId() {
    }

    public PagamentoId(int codigo_venda, int codigo_pagamento) {
        this.codigo_venda = codigo_venda;
        this.codigo_pagamento = codigo_pagamento;
    }

    public int getCodigo_venda() {
        return codigo_venda;
    }

    public void setCodigo_venda(int codigo_venda) {
        this.codigo_venda = codigo_venda;
    }

    public int getCodigo_pagamento() {
        return codigo_pagamento;
    }

    public void setCodigo_pagamento(int codigo_pagamento) {
        this.codigo_pagamento = codigo_pagamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.codigo_venda;
        hash = 23 * hash + this.codigo_pagamento;
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
        final PagamentoId other = (PagamentoId) obj;
        if (this.codigo_venda != other.codigo_venda) {
            return false;
        }
        return this.codigo_pagamento == other.codigo_pagamento;
    }


}
