package ifsplife.model;

public class Funcionarios {

    // Definição dos Atributos da Classe [Funcionario];
    private int codigo_funcionario;
    private String nome_funcionairo;
    private String cargo_funcionario;
    private String telefone_funcionario;
    private String endereco_funcionario;
    private String cidade_funcionario;
    private String cep_funcionario;
    private String uf_funcionario;
    private double salario_funcionario;
    private String nivelacesso_funcionario;
    private String login_funcionario;
    private String senha_funcionario;

    // Definição do construtor VAZIO da Classe [Funcionario]; 
    public Funcionarios() {
    }

    // Definição do construtor preenchido da Classe [Funcionario];
    public Funcionarios(int codigo_funcionario, String nome_funcionairo, String cargo_funcionario, String telefone_funcionario, String endereco_funcionario, String cidade_funcionario, String cep_funcionario, String uf_funcionario, double salario_funcionario, String nivelacesso_funcionario, String login_funcionario, String senha_funcionario) {
        this.codigo_funcionario = codigo_funcionario;
        this.nome_funcionairo = nome_funcionairo;
        this.cargo_funcionario = cargo_funcionario;
        this.telefone_funcionario = telefone_funcionario;
        this.endereco_funcionario = endereco_funcionario;
        this.cidade_funcionario = cidade_funcionario;
        this.cep_funcionario = cep_funcionario;
        this.uf_funcionario = uf_funcionario;
        this.salario_funcionario = salario_funcionario;
        this.nivelacesso_funcionario = nivelacesso_funcionario;
        this.login_funcionario = login_funcionario;
        this.senha_funcionario = senha_funcionario;
    }

    // Definição dos Getters da Classe [Funcionario];
    public int getCodigo_funcionario() {
        return codigo_funcionario;
    }

    public String getNome_funcionairo() {
        return nome_funcionairo;
    }

    public String getCargo_funcionario() {
        return cargo_funcionario;
    }

    public String getTelefone_funcionario() {
        return telefone_funcionario;
    }

    public String getEndereco_funcionario() {
        return endereco_funcionario;
    }

    public String getCidade_funcionario() {
        return cidade_funcionario;
    }

    public String getCep_funcionario() {
        return cep_funcionario;
    }

    public String getUf_funcionario() {
        return uf_funcionario;
    }

    public double getSalario_funcionario() {
        return salario_funcionario;
    }

    public String getNivelacesso_funcionario() {
        return nivelacesso_funcionario;
    }

    public String getLogin_funcionario() {
        return login_funcionario;
    }

    public String getSenha_funcionario() {
        return senha_funcionario;
    }
    
    // Definição dos Setters da Classe [Funcionario];
    public void setCodigo_funcionario(int codigo_funcionario) {
        this.codigo_funcionario = codigo_funcionario;
    }

    public void setNome_funcionairo(String nome_funcionairo) {
        this.nome_funcionairo = nome_funcionairo;
    }

    public void setCargo_funcionario(String cargo_funcionario) {
        this.cargo_funcionario = cargo_funcionario;
    }

    public void setTelefone_funcionario(String telefone_funcionario) {
        this.telefone_funcionario = telefone_funcionario;
    }

    public void setEndereco_funcionario(String endereco_funcionario) {
        this.endereco_funcionario = endereco_funcionario;
    }

    public void setCidade_funcionario(String cidade_funcionario) {
        this.cidade_funcionario = cidade_funcionario;
    }

    public void setCep_funcionario(String cep_funcionario) {
        this.cep_funcionario = cep_funcionario;
    }

    public void setUf_funcionario(String uf_funcionario) {
        this.uf_funcionario = uf_funcionario;
    }

    public void setSalario_funcionario(double salario_funcionario) {
        this.salario_funcionario = salario_funcionario;
    }

    public void setNivelacesso_funcionario(String nivelacesso_funcionario) {
        this.nivelacesso_funcionario = nivelacesso_funcionario;
    }

    public void setLogin_funcionario(String login_funcionario) {
        this.login_funcionario = login_funcionario;
    }

    public void setSenha_funcionario(String senha_funcionario) {
        this.senha_funcionario = senha_funcionario;
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
        final Funcionarios other = (Funcionarios) obj;
        return this.codigo_funcionario == other.codigo_funcionario;
    }

    // Definição do TOSTRING da Classe [Funcionario];

    @Override
    public String toString() {
        return "Funcionarios{" + "codigo_funcionario=" + codigo_funcionario + ", nome_funcionairo=" + nome_funcionairo + ", cargo_funcionario=" + cargo_funcionario + '}';
    }
    
}
