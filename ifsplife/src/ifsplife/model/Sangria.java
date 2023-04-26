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
@Table(name = "sangria")
@NamedQueries({
    @NamedQuery(name = "Sangria.findAll", query = "SELECT s FROM Sangria s"),
    @NamedQuery(name = "Sangria.findByCodigoCaixa", query = "SELECT s FROM Sangria s WHERE s.sangriaPK.codigoCaixa = :codigoCaixa"),
    @NamedQuery(name = "Sangria.findByCodigoSangria", query = "SELECT s FROM Sangria s WHERE s.sangriaPK.codigoSangria = :codigoSangria"),
    @NamedQuery(name = "Sangria.findByMotivo", query = "SELECT s FROM Sangria s WHERE s.motivo = :motivo"),
    @NamedQuery(name = "Sangria.findByValor", query = "SELECT s FROM Sangria s WHERE s.valor = :valor"),
    @NamedQuery(name = "Sangria.findByTipomovimentacao", query = "SELECT s FROM Sangria s WHERE s.tipomovimentacao = :tipomovimentacao")})
public class Sangria implements Serializable {

    @EmbeddedId
    protected SangriaID sangriaPK;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "valor")
    private double valor;

    @Column(name = "tipomovimentacao")
    private String tipomovimentacao;
    @JoinColumn(name = "codigo_caixa", referencedColumnName = "codigo_caixa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Caixa caixa;

    public Sangria() {
    }

    public Sangria(SangriaID sangriaPK) {
        this.sangriaPK = sangriaPK;
    }

    public Sangria(SangriaID sangriaPK, String motivo, double valor, String tipomovimentacao) {
        this.sangriaPK = sangriaPK;
        this.motivo = motivo;
        this.valor = valor;
        this.tipomovimentacao = tipomovimentacao;
    }

    public Sangria(int codigoCaixa, int codigoSangria) {
        this.sangriaPK = new SangriaID(codigoCaixa, codigoSangria);
    }

    public SangriaID getSangriaPK() {
        return sangriaPK;
    }

    public void setSangriaPK(SangriaID sangriaPK) {
        this.sangriaPK = sangriaPK;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipomovimentacao() {
        return tipomovimentacao;
    }

    public void setTipomovimentacao(String tipomovimentacao) {
        this.tipomovimentacao = tipomovimentacao;
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
        hash += (sangriaPK != null ? sangriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Sangria)) {
            return false;
        }
        Sangria other = (Sangria) object;
        if ((this.sangriaPK == null && other.sangriaPK != null) || (this.sangriaPK != null && !this.sangriaPK.equals(other.sangriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.Sangria[ sangriaPK=" + sangriaPK + " ]";
    }

}
