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
@Table(name = "sangria")
@NamedQueries({
    @NamedQuery(name = "Sangria.findAll", query = "SELECT s FROM Sangria s"),
    @NamedQuery(name = "Sangria.findByCodigoSangria", query = "SELECT s FROM Sangria s WHERE s.codigo_sangria = :codigoSangria"),
    @NamedQuery(name = "Sangria.findByMotivo", query = "SELECT s FROM Sangria s WHERE s.motivo = :motivo"),
    @NamedQuery(name = "Sangria.findByTipomovimentacao", query = "SELECT s FROM Sangria s WHERE s.tipomovimentacao = :tipomovimentacao"),
    @NamedQuery(name = "Sangria.findByValor", query = "SELECT s FROM Sangria s WHERE s.valor = :valor"),
    @NamedQuery(name = "Sangria.findByCodigoCaixa", query = "SELECT s FROM Sangria s WHERE s.codigo_caixa = :codigoCaixa")})

@IdClass(SangriaId.class)
public class Sangria implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "codigo_caixa", referencedColumnName = "codigo_caixa")
    private Caixa codigo_caixa;

    @Id
    @Column(name = "codigo_sangria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo_sangria;

    @Column(name = "motivo", nullable = false, length = 250)
    private String motivo;

    @Column(name = "tipomovimentacao", nullable = false, length = 45)
    private String tipomovimentacao;

    @Column(name = "valor", nullable = false)
    private double valor;

    public Sangria() {
    }

    public Sangria(String motivo, String tipomovimentacao, double valor, Caixa codigo_caixa) {
        this.motivo = motivo;
        this.tipomovimentacao = tipomovimentacao;
        this.valor = valor;
        this.codigo_caixa = codigo_caixa;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getTipomovimentacao() {
        return tipomovimentacao;
    }

    public void setTipomovimentacao(String tipomovimentacao) {
        this.tipomovimentacao = tipomovimentacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
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
        hash = 53 * hash + Objects.hashCode(this.codigo_caixa);
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
        final Sangria other = (Sangria) obj;
        return Objects.equals(this.codigo_caixa, other.codigo_caixa);
    }

}
