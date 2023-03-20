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

@NamedQueries({
    @NamedQuery(name = "Funcionario.todos",
            query = "SELECT func FROM Funcionario func"),
    @NamedQuery(name = "Fornecedor.porNome",
            query = "SELECT func FROM Funcionario func WHERE func.nome LIKE :nomequalquer")
})

// indicando ao JPA qual a tabela será utilizada
// para armazenar os objetos dessa classe
@Table(name = "funcionarios")
// 01. Definição dos Atributos da Classe

public class Funcionario implements Serializable {

    // Definição dos Atributos da Classe [Funcionario];
    @Id   // indica ao JPA que codigo será a chave primária
    // @Column - name -> indica o nome do campo da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Definição dos Atributos da Classe [Fornecedor];
    private int codigo_funcionario;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "cargo", length = 45, nullable = false)
    private String cargo;

    @Column(name = "telefone", length = 11, nullable = false)
    private String telefone;

    @Column(name = "endereco", length = 45, nullable = false)
    private String endereco;

    @Column(name = "cidade", length = 45, nullable = false)
    private String cidade;

    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

    @Column(name = "salario", length = 45, nullable = false)
    private double salario;

    @Column(name = "nivelacesso", length = 45, nullable = false)
    private String nivelacesso;

    @Column(name = "login", length = 45, nullable = false)
    private String login;
    
    @Column(name = "senha", length = 45, nullable = false)
    private String senha;

    // Definição do construtor VAZIO da Classe [Funcionario]; 
    public Funcionario() {
    }

    // Definição do construtor preenchido da Classe [Funcionario];
    public Funcionario(int codigo_funcionario, String nome, String cargo, String telefone, String endereco, String cidade, String cep, String uf, double salario, String nivelacesso, String login, String senha) {
        this.codigo_funcionario = codigo_funcionario;
        this.nome = nome;
        this.cargo = cargo;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
        this.salario = salario;
        this.nivelacesso = nivelacesso;
        this.login = login;
        this.senha = senha;
    }

    // Definição dos Getters da Classe [Funcionario];
    public int getCodigo() {
        return codigo_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getUf() {
        return uf;
    }

    public double getSalario() {
        return salario;
    }

    public String getNivelacesso() {
        return nivelacesso;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    // Definição dos Setters da Classe [Funcionario];
    public void setCodigo_funcionario(int codigo_funcionario) {
        this.codigo_funcionario = codigo_funcionario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setNivelacesso(String nivelacesso) {
        this.nivelacesso = nivelacesso;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Definição do EQUALS da Classe [Funcionario];
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigo_funcionario;
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
        final Funcionario other = (Funcionario) obj;
        return this.codigo_funcionario == other.codigo_funcionario;
    }

    // Definição do TOSTRING da Classe [Funcionario];
    @Override
    public String toString() {
        return "Funcionarios{" + "codigo_funcionario=" + codigo_funcionario + ", nome=" + nome + ", cargo=" + cargo + '}';
    }

}
