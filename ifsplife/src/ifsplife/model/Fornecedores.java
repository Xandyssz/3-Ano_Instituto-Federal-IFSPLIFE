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
@Table(name = "fornecedores", catalog = "ifsplife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Fornecedores.findAll", query = "SELECT f FROM Fornecedores f"),
    @NamedQuery(name = "Fornecedores.findByCodigoFornecedor", query = "SELECT f FROM Fornecedores f WHERE f.codigo_fornecedor = :codigoFornecedor"),
    @NamedQuery(name = "Fornecedores.findByCep", query = "SELECT f FROM Fornecedores f WHERE f.cep = :cep"),
    @NamedQuery(name = "Fornecedores.findByCidade", query = "SELECT f FROM Fornecedores f WHERE f.cidade = :cidade"),
    @NamedQuery(name = "Fornecedores.findByCnpj", query = "SELECT f FROM Fornecedores f WHERE f.cnpj = :cnpj"),
    @NamedQuery(name = "Fornecedores.findByEmail", query = "SELECT f FROM Fornecedores f WHERE f.email = :email"),
    @NamedQuery(name = "Fornecedores.findByEndereco", query = "SELECT f FROM Fornecedores f WHERE f.endereco = :endereco"),
    @NamedQuery(name = "Fornecedores.findByNome", query = "SELECT f FROM Fornecedores f WHERE f.nome = :nome"),
    @NamedQuery(name = "Fornecedores.findByResponsavel", query = "SELECT f FROM Fornecedores f WHERE f.responsavel = :responsavel"),
    @NamedQuery(name = "Fornecedores.findByTelefone", query = "SELECT f FROM Fornecedores f WHERE f.telefone = :telefone"),
    @NamedQuery(name = "Fornecedores.findByUf", query = "SELECT f FROM Fornecedores f WHERE f.uf = :uf")})
public class Fornecedores implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_fornecedor", nullable = false)
    private Integer codigo_fornecedor;

    @Column(name = "cep", nullable = false, length = 12)
    private String cep;

    @Column(name = "cidade", nullable = false, length = 45)
    private String cidade;

    @Column(name = "cnpj", nullable = false, length = 20)
    private String cnpj;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "endereco", nullable = false, length = 45)
    private String endereco;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "responsavel", nullable = false, length = 45)
    private String responsavel;

    @Column(name = "telefone", nullable = false, length = 20)
    private String telefone;

    @Column(name = "uf", nullable = false, length = 20)
    private String uf;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "codigo_fornecedor")
    private List<Compras> compras = new ArrayList<>();

    public Fornecedores() {
    }

    public Fornecedores(Integer codigo_fornecedor, String cep, String cidade, String cnpj, String email, String endereco, String nome, String responsavel, String telefone, String uf, List<Compras> compras) {
        this.codigo_fornecedor = codigo_fornecedor;
        this.cep = cep;
        this.cidade = cidade;
        this.cnpj = cnpj;
        this.email = email;
        this.endereco = endereco;
        this.nome = nome;
        this.responsavel = responsavel;
        this.telefone = telefone;
        this.uf = uf;
        this.compras = compras;
    }

    public Integer getCodigo_fornecedor() {
        return codigo_fornecedor;
    }

    public void setCodigo_fornecedor(Integer codigo_fornecedor) {
        this.codigo_fornecedor = codigo_fornecedor;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Compras> getCompras() {
        return compras;
    }

    public void setCompras(List<Compras> compras) {
        this.compras = compras;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.codigo_fornecedor);
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
        final Fornecedores other = (Fornecedores) obj;
        return Objects.equals(this.codigo_fornecedor, other.codigo_fornecedor);
    }

    @Override
    public String toString() {
        return nome;
    }

    
}
