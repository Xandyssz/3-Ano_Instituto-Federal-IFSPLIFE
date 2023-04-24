package ifsplife.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "movimentacao", catalog = "ifsplife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Movimentacao.findAll", query = "SELECT m FROM Movimentacao m"),
    @NamedQuery(name = "Movimentacao.findByCodigoMovimentacao", query = "SELECT m FROM Movimentacao m WHERE m.movimentacaoPK.codigoMovimentacao = :codigoMovimentacao"),
    @NamedQuery(name = "Movimentacao.findByValor", query = "SELECT m FROM Movimentacao m WHERE m.valor = :valor"),
    @NamedQuery(name = "Movimentacao.findByMotivo", query = "SELECT m FROM Movimentacao m WHERE m.motivo = :motivo"),
    @NamedQuery(name = "Movimentacao.findByTipo", query = "SELECT m FROM Movimentacao m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "Movimentacao.findByCaixaCodigoCaixa", query = "SELECT m FROM Movimentacao m WHERE m.movimentacaoPK.caixaCodigoCaixa = :caixaCodigoCaixa")})
public class Movimentacao implements Serializable {

    
    @EmbeddedId
    protected MovimentacaoId movimentacaoPK;
    
    @Column(name = "valor", nullable = false)
    private double valor;
    
    @Column(name = "motivo", nullable = false, length = 200)
    private String motivo;
    
    @Column(name = "tipo", nullable = false)
    private String tipo;
    @JoinColumn(name = "caixa_codigo_caixa", referencedColumnName = "codigo_caixa", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Caixa caixa;

    public Movimentacao() {
    }

    public Movimentacao(MovimentacaoId movimentacaoPK) {
        this.movimentacaoPK = movimentacaoPK;
    }

    public Movimentacao(MovimentacaoId movimentacaoPK, double valor, String motivo, String tipo) {
        this.movimentacaoPK = movimentacaoPK;
        this.valor = valor;
        this.motivo = motivo;
        this.tipo = tipo;
    }

    public Movimentacao(int codigoMovimentacao, int caixaCodigoCaixa) {
        this.movimentacaoPK = new MovimentacaoId(codigoMovimentacao, caixaCodigoCaixa);
    }

    public MovimentacaoId getMovimentacaoPK() {
        return movimentacaoPK;
    }

    public void setMovimentacaoPK(MovimentacaoId movimentacaoPK) {
        this.movimentacaoPK = movimentacaoPK;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movimentacaoPK != null ? movimentacaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Movimentacao)) {
            return false;
        }
        Movimentacao other = (Movimentacao) object;
        if ((this.movimentacaoPK == null && other.movimentacaoPK != null) || (this.movimentacaoPK != null && !this.movimentacaoPK.equals(other.movimentacaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.Movimentacao[ movimentacaoPK=" + movimentacaoPK + " ]";
    }
    
}
