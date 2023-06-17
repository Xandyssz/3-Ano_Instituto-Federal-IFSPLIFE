package ifsplife.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
@Table(name = "convenios", catalog = "ifsplife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Convenios.findAll", query = "SELECT c FROM Convenios c"),
    @NamedQuery(name = "Convenios.findByCodigoConvenio", query = "SELECT c FROM Convenios c WHERE c.codigo_convenio = :codigoConvenio"),
    @NamedQuery(name = "Convenios.findByCnpj", query = "SELECT c FROM Convenios c WHERE c.cnpj = :cnpj"),
    @NamedQuery(name = "Convenios.findByDesconto", query = "SELECT c FROM Convenios c WHERE c.desconto = :desconto"),
    @NamedQuery(name = "Convenios.findByEmail", query = "SELECT c FROM Convenios c WHERE c.email = :email"),
    @NamedQuery(name = "Convenios.findByEndereco", query = "SELECT c FROM Convenios c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "Convenios.findByNome", query = "SELECT c FROM Convenios c WHERE c.nome like :nome"),
    @NamedQuery(name = "Convenios.findByTelefone", query = "SELECT c FROM Convenios c WHERE c.telefone = :telefone")})

public class Convenios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_convenio", nullable = false)
    private Integer codigo_convenio;

    @Column(name = "cnpj", nullable = false, length = 20)
    private String cnpj;

    @Column(name = "desconto", nullable = false)
    private Double desconto;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "endereco", nullable = false, length = 255)
    private String endereco;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "telefone", nullable = false, length = 255)
    private String telefone;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "codigo_convenio")
    private List<Vendas> vendas = new ArrayList<>();

    public Convenios() {
    }

    public Convenios(Integer codigo_convenio, String cnpj, Double desconto, String email, String endereco, String nome, String telefone, List<Vendas> vendas) {
        this.codigo_convenio = codigo_convenio;
        this.cnpj = cnpj;
        this.desconto = desconto;
        this.email = email;
        this.endereco = endereco;
        this.nome = nome;
        this.telefone = telefone;
        this.vendas = vendas;
    }

    public Integer getCodigo_convenio() {
        return codigo_convenio;
    }

    public void setCodigo_convenio(Integer codigo_convenio) {
        this.codigo_convenio = codigo_convenio;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Vendas> getVendas() {
        return vendas;
    }

    public void setVendas(List<Vendas> vendas) {
        this.vendas = vendas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.codigo_convenio);
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
        final Convenios other = (Convenios) obj;
        return Objects.equals(this.codigo_convenio, other.codigo_convenio);
    }

    @Override
    public String toString() {
        return nome;
    }

    
    
}
