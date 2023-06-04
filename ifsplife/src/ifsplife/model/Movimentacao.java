package ifsplife.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "movimentacao")
@NamedQueries({
    @NamedQuery(name = "Movimentacao.findAll", query = "SELECT m FROM Movimentacao m"),
    @NamedQuery(name = "Movimentacao.findByIdMovimentacao", query = "SELECT m FROM Movimentacao m WHERE m.codigo_movimentacao = :idMovimentacao"),
    @NamedQuery(name = "Movimentacao.findByMotivo", query = "SELECT m FROM Movimentacao m WHERE m.motivo = :motivo"),
    @NamedQuery(name = "Movimentacao.findByTipo", query = "SELECT m FROM Movimentacao m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "Movimentacao.findByValor", query = "SELECT m FROM Movimentacao m WHERE m.valor = :valor"),
    @NamedQuery(name = "Movimentacao.findByCodigoCaixa", query = "SELECT m FROM Movimentacao m WHERE m.codigo_caixa = :codigoCaixa")})

@IdClass(MovimentacaoId.class)
public class Movimentacao implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "codigo_caixa", referencedColumnName = "codigo_caixa")
    private Caixa codigo_caixa;

    @Id
    @Column(name = "idMovimentacao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo_movimentacao;

    @Column(name = "motivo", nullable = false, length = 200)
    private String motivo;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "valor", nullable = false)
    private double valor;

    public Movimentacao() {
    }

    public Movimentacao(int codigo_movimentacoa, String motivo, String tipo, double valor, Caixa codigo_caixa) {
        this.codigo_movimentacao = codigo_movimentacao;
        this.motivo = motivo;
        this.tipo = tipo;
        this.valor = valor;
        this.codigo_caixa = codigo_caixa;
    }

    public int getCodigo_movimentacao() {
        return codigo_movimentacao;
    }

    public void setCodigo_movimentacao(int codigo_movimentacao) {
        this.codigo_movimentacao = codigo_movimentacao;
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

    public double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Caixa getCodigo_caixa() {
        return codigo_caixa;
    }

    public void setCodigo_caixa(Caixa codigo_caixa) {
        this.codigo_caixa = codigo_caixa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.codigo_caixa);
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
        final Movimentacao other = (Movimentacao) obj;
        return Objects.equals(this.codigo_caixa, other.codigo_caixa);
    }

}
