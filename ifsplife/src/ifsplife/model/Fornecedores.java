package ifsplife.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedores", catalog = "ifsplife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Fornecedores.findAll", query = "SELECT f FROM Fornecedores f"),
    @NamedQuery(name = "Fornecedores.findByCodigoFornecedor", query = "SELECT f FROM Fornecedores f WHERE f.codigoFornecedor = :codigoFornecedor"),
    @NamedQuery(name = "Fornecedores.findByNome", query = "SELECT f FROM Fornecedores f WHERE f.nome = :nome"),
    @NamedQuery(name = "Fornecedores.findByNomeQualquer", query = "SELECT f FROM Fornecedores f WHERE f.nome like :nome"),
    @NamedQuery(name = "Fornecedores.findByCnpj", query = "SELECT f FROM Fornecedores f WHERE f.cnpj = :cnpj"),
    @NamedQuery(name = "Fornecedores.findByTelefone", query = "SELECT f FROM Fornecedores f WHERE f.telefone = :telefone"),
    @NamedQuery(name = "Fornecedores.findByEmail", query = "SELECT f FROM Fornecedores f WHERE f.email = :email"),
    @NamedQuery(name = "Fornecedores.findByEndereco", query = "SELECT f FROM Fornecedores f WHERE f.endereco = :endereco"),
    @NamedQuery(name = "Fornecedores.findByCidade", query = "SELECT f FROM Fornecedores f WHERE f.cidade = :cidade"),
    @NamedQuery(name = "Fornecedores.findByCep", query = "SELECT f FROM Fornecedores f WHERE f.cep = :cep"),
    @NamedQuery(name = "Fornecedores.findByUf", query = "SELECT f FROM Fornecedores f WHERE f.uf = :uf")})
public class Fornecedores implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_fornecedor", nullable = false)
    private Integer codigoFornecedor;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "cnpj", nullable = false, length = 20)
    private String cnpj;

    @Column(name = "telefone", nullable = false, length = 20)
    private String telefone;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "endereco", nullable = false, length = 45)
    private String endereco;

    @Column(name = "cidade", nullable = false, length = 45)
    private String cidade;

    @Column(name = "cep", nullable = false, length = 12)
    private String cep;

    @Column(name = "uf", nullable = false, length = 20)
    private String uf;

    public Fornecedores() {
    }

    public Fornecedores(Integer codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public Fornecedores(Integer codigoFornecedor, String nome, String cnpj, String telefone, String email, String endereco, String cidade, String cep, String uf) {
        this.codigoFornecedor = codigoFornecedor;
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
    }

    public Integer getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(Integer codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFornecedor != null ? codigoFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Fornecedores)) {
            return false;
        }
        Fornecedores other = (Fornecedores) object;
        if ((this.codigoFornecedor == null && other.codigoFornecedor != null) || (this.codigoFornecedor != null && !this.codigoFornecedor.equals(other.codigoFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.Fornecedores[ codigoFornecedor=" + codigoFornecedor + " ]";
    }

}
