package ifsplife.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "convenios")
@NamedQueries({
    @NamedQuery(name = "Convenios.findAll", query = "SELECT c FROM Convenios c"),
    @NamedQuery(name = "Convenios.findByCodigoConvenio", query = "SELECT c FROM Convenios c WHERE c.codigoConvenio = :codigoConvenio"),
    @NamedQuery(name = "Convenios.findByNome", query = "SELECT c FROM Convenios c WHERE c.nome = :nome"),
    @NamedQuery(name = "Convenios.findByEmail", query = "SELECT c FROM Convenios c WHERE c.email = :email"),
    @NamedQuery(name = "Convenios.findByCnpj", query = "SELECT c FROM Convenios c WHERE c.cnpj = :cnpj"),
    @NamedQuery(name = "Convenios.findByEndereco", query = "SELECT c FROM Convenios c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "Convenios.findByTelefone", query = "SELECT c FROM Convenios c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "Convenios.findByDesconto", query = "SELECT c FROM Convenios c WHERE c.desconto = :desconto")})
public class Convenios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_convenio")
    private Integer codigoConvenio;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "desconto")
    private float desconto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoConvenio")
    private List<Vendas> vendasList;

    public Convenios() {
    }

    public Convenios(Integer codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
    }

    public Convenios(Integer codigoConvenio, String nome, String email, String cnpj, String endereco, String telefone, float desconto) {
        this.codigoConvenio = codigoConvenio;
        this.nome = nome;
        this.email = email;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.desconto = desconto;
    }

    public Integer getCodigoConvenio() {
        return codigoConvenio;
    }

    public void setCodigoConvenio(Integer codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public List<Vendas> getVendasList() {
        return vendasList;
    }

    public void setVendasList(List<Vendas> vendasList) {
        this.vendasList = vendasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoConvenio != null ? codigoConvenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Convenios)) {
            return false;
        }
        Convenios other = (Convenios) object;
        if ((this.codigoConvenio == null && other.codigoConvenio != null) || (this.codigoConvenio != null && !this.codigoConvenio.equals(other.codigoConvenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
