package ifsplife.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarios", catalog = "ifsplife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Funcionarios.findAll", query = "SELECT f FROM Funcionarios f"),
    @NamedQuery(name = "Funcionarios.findByCodigoFuncionario", query = "SELECT f FROM Funcionarios f WHERE f.codigoFuncionario = :codigoFuncionario"),
    @NamedQuery(name = "Funcionarios.findByNome", query = "SELECT f FROM Funcionarios f WHERE f.nome = :nome"),
    @NamedQuery(name = "Funcionarios.findByNomeQualquer", query = "SELECT f FROM Funcionarios f WHERE f.nome like :nome"),
    @NamedQuery(name = "Funcionarios.findByCpf", query = "SELECT f FROM Funcionarios f WHERE f.cpf = :cpf"),
    @NamedQuery(name = "Funcionarios.findByNivelacesso", query = "SELECT f FROM Funcionarios f WHERE f.nivelacesso = :nivelacesso"),
    @NamedQuery(name = "Funcionarios.findByTelefone", query = "SELECT f FROM Funcionarios f WHERE f.telefone = :telefone"),
    @NamedQuery(name = "Funcionarios.findByEndereco", query = "SELECT f FROM Funcionarios f WHERE f.endereco = :endereco"),
    @NamedQuery(name = "Funcionarios.findByCidade", query = "SELECT f FROM Funcionarios f WHERE f.cidade = :cidade"),
    @NamedQuery(name = "Funcionarios.findByCep", query = "SELECT f FROM Funcionarios f WHERE f.cep = :cep"),
    @NamedQuery(name = "Funcionarios.findByUf", query = "SELECT f FROM Funcionarios f WHERE f.uf = :uf"),
    @NamedQuery(name = "Funcionarios.findBySalario", query = "SELECT f FROM Funcionarios f WHERE f.salario = :salario"),
    @NamedQuery(name = "Funcionarios.findByLogin", query = "SELECT f FROM Funcionarios f WHERE f.login = :login"),
    @NamedQuery(name = "Funcionarios.findBySenha", query = "SELECT f FROM Funcionarios f WHERE f.senha = :senha")})
public class Funcionarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_funcionario", nullable = false)
    private Integer codigoFuncionario;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;
    @Basic(optional = false)
    @Column(name = "cpf", nullable = false, length = 15)
    private String cpf;
    @Basic(optional = false)
    @Column(name = "nivelacesso", nullable = false, length = 45)
    private String nivelacesso;
    @Basic(optional = false)
    @Column(name = "telefone", nullable = false, length = 20)
    private String telefone;
    @Basic(optional = false)
    @Column(name = "endereco", nullable = false, length = 45)
    private String endereco;
    @Basic(optional = false)
    @Column(name = "cidade", nullable = false, length = 45)
    private String cidade;
    @Basic(optional = false)
    @Column(name = "cep", nullable = false, length = 12)
    private String cep;
    @Basic(optional = false)
    @Column(name = "uf", nullable = false, length = 20)
    private String uf;
    @Basic(optional = false)
    @Column(name = "salario", nullable = false, length = 50)
    private String salario;
    @Basic(optional = false)
    @Column(name = "login", nullable = false, length = 45)
    private String login;
    @Basic(optional = false)
    @Column(name = "senha", nullable = false, length = 45)
    private String senha;

    public Funcionarios() {
    }

    public Funcionarios(Integer codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public Funcionarios(Integer codigoFuncionario, String nome, String cpf, String nivelacesso, String telefone, String endereco, String cidade, String cep, String uf, String salario, String login, String senha) {
        this.codigoFuncionario = codigoFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.nivelacesso = nivelacesso;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
        this.salario = salario;
        this.login = login;
        this.senha = senha;
    }

    public Integer getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(Integer codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNivelacesso() {
        return nivelacesso;
    }

    public void setNivelacesso(String nivelacesso) {
        this.nivelacesso = nivelacesso;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFuncionario != null ? codigoFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Funcionarios)) {
            return false;
        }
        Funcionarios other = (Funcionarios) object;
        if ((this.codigoFuncionario == null && other.codigoFuncionario != null) || (this.codigoFuncionario != null && !this.codigoFuncionario.equals(other.codigoFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifsplife.model.Funcionarios[ codigoFuncionario=" + codigoFuncionario + " ]";
    }

}
