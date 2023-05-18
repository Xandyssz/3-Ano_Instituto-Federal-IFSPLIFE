package ifsplife.model;

import java.io.Serializable;
import java.util.Objects;
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
    @NamedQuery(name = "Funcionarios.findByCodigoFuncionario", query = "SELECT f FROM Funcionarios f WHERE f.codigo_funcionario = :codigoFuncionario"),
    @NamedQuery(name = "Funcionarios.findByCep", query = "SELECT f FROM Funcionarios f WHERE f.cep = :cep"),
    @NamedQuery(name = "Funcionarios.findByCidade", query = "SELECT f FROM Funcionarios f WHERE f.cidade = :cidade"),
    @NamedQuery(name = "Funcionarios.findByCpf", query = "SELECT f FROM Funcionarios f WHERE f.cpf = :cpf"),
    @NamedQuery(name = "Funcionarios.findByEndereco", query = "SELECT f FROM Funcionarios f WHERE f.endereco = :endereco"),
    
    @NamedQuery(name = "Funcionarios.findByLogin", query = "SELECT f FROM Funcionarios f WHERE f.login = :login AND f.senha = :senha" ),
    
    
    
    @NamedQuery(name = "Funcionarios.findByNivelacesso", query = "SELECT f FROM Funcionarios f WHERE f.nivelacesso = :nivelacesso"),
    @NamedQuery(name = "Funcionarios.findByNome", query = "SELECT f FROM Funcionarios f WHERE f.nome = :nome"),
    @NamedQuery(name = "Funcionarios.findBySalario", query = "SELECT f FROM Funcionarios f WHERE f.salario = :salario"),
    @NamedQuery(name = "Funcionarios.findBySenha", query = "SELECT f FROM Funcionarios f WHERE f.senha = :senha"),
    @NamedQuery(name = "Funcionarios.findByTelefone", query = "SELECT f FROM Funcionarios f WHERE f.telefone = :telefone"),
    @NamedQuery(name = "Funcionarios.findByUf", query = "SELECT f FROM Funcionarios f WHERE f.uf = :uf")})
public class Funcionarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_funcionario", nullable = false)
    private Integer codigo_funcionario;

    @Column(name = "cep", nullable = false, length = 12)
    private String cep;

    @Column(name = "cidade", nullable = false, length = 45)
    private String cidade;

    @Column(name = "cpf", nullable = false, length = 15)
    private String cpf;

    @Column(name = "endereco", nullable = false, length = 45)
    private String endereco;

    @Column(name = "login", nullable = false, length = 45)
    private String login;

    @Column(name = "nivelacesso", nullable = false, length = 45)
    private String nivelacesso;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "salario", nullable = false, length = 50)
    private String salario;

    @Column(name = "senha", nullable = false, length = 45)
    private String senha;

    @Column(name = "telefone", nullable = false, length = 20)
    private String telefone;

    @Column(name = "uf", nullable = false, length = 20)
    private String uf;

    public Funcionarios() {
    }

    public Funcionarios(Integer codigo_funcionario, String cep, String cidade, String cpf, String endereco, String login, String nivelacesso, String nome, String salario, String senha, String telefone, String uf) {
        this.codigo_funcionario = codigo_funcionario;
        this.cep = cep;
        this.cidade = cidade;
        this.cpf = cpf;
        this.endereco = endereco;
        this.login = login;
        this.nivelacesso = nivelacesso;
        this.nome = nome;
        this.salario = salario;
        this.senha = senha;
        this.telefone = telefone;
        this.uf = uf;
    }

    public Integer getCodigo_funcionario() {
        return codigo_funcionario;
    }

    public void setCodigo_funcionario(Integer codigo_funcionario) {
        this.codigo_funcionario = codigo_funcionario;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNivelacesso() {
        return nivelacesso;
    }

    public void setNivelacesso(String nivelacesso) {
        this.nivelacesso = nivelacesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo_funcionario);
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
        final Funcionarios other = (Funcionarios) obj;
        return Objects.equals(this.codigo_funcionario, other.codigo_funcionario);
    }

}
