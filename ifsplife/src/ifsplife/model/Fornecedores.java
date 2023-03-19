package ifsplife.model;

public class Fornecedores {

    // Definição dos Atributos da Classe [Fornecedor];
    private int codigo_fornecedor;
    private String nome_fornecedor;
    private String cnpj_fornecedor;
    private String telefone_fornecedor;
    private String email_forncedor;
    private String endereco_fornecedor;
    private String cidade_forncedor;
    private String cep_fornecedor;
    private String uf_forncedor;

    // Definição do construtor VAZIO da Classe [Fornecedor]; 
    public Fornecedores() {
    }

    // Definição do construtor preenchido da Classe [Fornecedor];
    public Fornecedores(int codigo_fornecedor, String nome_fornecedor, String cnpj_fornecedor, String telefone_fornecedor, String email_forncedor, String endereco_fornecedor, String cidade_forncedor, String cep_fornecedor, String uf_forncedor) {
        this.codigo_fornecedor = codigo_fornecedor;
        this.nome_fornecedor = nome_fornecedor;
        this.cnpj_fornecedor = cnpj_fornecedor;
        this.telefone_fornecedor = telefone_fornecedor;
        this.email_forncedor = email_forncedor;
        this.endereco_fornecedor = endereco_fornecedor;
        this.cidade_forncedor = cidade_forncedor;
        this.cep_fornecedor = cep_fornecedor;
        this.uf_forncedor = uf_forncedor;
    }

    // Definição dos Getters da Classe [Fornecedor];
    public int getCodigo_fornecedor() {
        return codigo_fornecedor;
    }

    public String getNome_fornecedor() {
        return nome_fornecedor;
    }

    public String getCnpj_fornecedor() {
        return cnpj_fornecedor;
    }

    public String getTelefone_fornecedor() {
        return telefone_fornecedor;
    }

    public String getEmail_forncedor() {
        return email_forncedor;
    }

    public String getEndereco_fornecedor() {
        return endereco_fornecedor;
    }

    public String getCidade_forncedor() {
        return cidade_forncedor;
    }

    public String getCep_fornecedor() {
        return cep_fornecedor;
    }

    public String getUf_forncedor() {
        return uf_forncedor;
    }

    // Definição dos Setters da Classe [Fornecedor];
    public void setCodigo_fornecedor(int codigo_fornecedor) {
        this.codigo_fornecedor = codigo_fornecedor;
    }

    public void setNome_fornecedor(String nome_fornecedor) {
        this.nome_fornecedor = nome_fornecedor;
    }

    public void setCnpj_fornecedor(String cnpj_fornecedor) {
        this.cnpj_fornecedor = cnpj_fornecedor;
    }

    public void setTelefone_fornecedor(String telefone_fornecedor) {
        this.telefone_fornecedor = telefone_fornecedor;
    }

    public void setEmail_forncedor(String email_forncedor) {
        this.email_forncedor = email_forncedor;
    }

    public void setEndereco_fornecedor(String endereco_fornecedor) {
        this.endereco_fornecedor = endereco_fornecedor;
    }

    public void setCidade_forncedor(String cidade_forncedor) {
        this.cidade_forncedor = cidade_forncedor;
    }

    public void setCep_fornecedor(String cep_fornecedor) {
        this.cep_fornecedor = cep_fornecedor;
    }

    public void setUf_forncedor(String uf_forncedor) {
        this.uf_forncedor = uf_forncedor;
    }

    // Definição do EQUALS da Classe [Fornecedor];
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigo_fornecedor;
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
        return this.codigo_fornecedor == other.codigo_fornecedor;
    }

    // Definição do TOSTRING da Classe [Fornecedor];
    @Override
    public String toString() {
        return "Fornecedores{" + "codigo_fornecedor=" + codigo_fornecedor + ", nome_fornecedor=" + nome_fornecedor + ", cnpj_fornecedor=" + cnpj_fornecedor + '}';
    }

}
