//package ifsplife.model;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
//@Entity
//
//@NamedQueries({
//    @NamedQuery(name = "Fornecedor.todos",
//            query = "SELECT f FROM Fornecedor f"),
//    @NamedQuery(name = "Fornecedor.porNome",
//            query = "SELECT f FROM Fornecedor f WHERE f.nome LIKE :nomequalquer")
//})
//
//// indicando ao JPA qual a tabela será utilizada
//// para armazenar os objetos dessa classe
//@Table(name = "fornecedores")
//// 01. Definição dos Atributos da Classe
//
//public class Fornecedor implements Serializable {
//
//    @Id   // indica ao JPA que codigo será a chave primária
//    // @Column - name -> indica o nome do campo da tabela
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    // Definição dos Atributos da Classe [Fornecedor];
//    private int codigo_fornecedor;
//
//    @Column(name = "nome", length = 45, nullable = false)
//    private String nome;
//
//    @Column(name = "cnpj", length = 14, nullable = false)
//    private String cnpj;
//
//    @Column(name = "telefone", length = 11, nullable = false)
//    private String telefone;
//
//    @Column(name = "email", length = 45, nullable = false)
//    private String email;
//    
//    @Column(name = "endereco", length = 45, nullable = false)
//    private String endereco;
//    
//    @Column(name = "cidade", length = 45, nullable = false)
//    private String cidade;
//    
//    @Column(name = "cep", length = 8, nullable = false)
//    private String cep;
//    
//    @Column(name = "uf", length = 2, nullable = false)
//    private String uf;
//
//    // Definição do construtor VAZIO da Classe [Fornecedor]; 
//    public Fornecedor() {
//    }
//
//    // Definição do construtor preenchido da Classe [Fornecedor];
//    public Fornecedor(int codigo_fornecedor, String nome, String cnpj, String telefone, String email, String endereco, String cidade, String cep, String uf) {
//        this.codigo_fornecedor = codigo_fornecedor;
//        this.nome = nome;
//        this.cnpj = cnpj;
//        this.telefone = telefone;
//        this.email = email;
//        this.endereco = endereco;
//        this.cidade = cidade;
//        this.cep = cep;
//        this.uf = uf;
//    }
//
//    // Definição dos Getters da Classe [Fornecedor];
//    public int getCodigo() {
//        return codigo_fornecedor;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public String getCnpj() {
//        return cnpj;
//    }
//
//    public String getTelefone() {
//        return telefone;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getEndereco() {
//        return endereco;
//    }
//
//    public String getCidade() {
//        return cidade;
//    }
//
//    public String getCep() {
//        return cep;
//    }
//
//    public String getUf() {
//        return uf;
//    }
//
//    // Definição dos Setters da Classe [Fornecedor];
//    public void setCodigo_fornecedor(int codigo_fornecedor) {
//        this.codigo_fornecedor = codigo_fornecedor;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public void setCnpj(String cnpj) {
//        this.cnpj = cnpj;
//    }
//
//    public void setTelefone(String telefone) {
//        this.telefone = telefone;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setEndereco(String endereco) {
//        this.endereco = endereco;
//    }
//
//    public void setCidade(String cidade) {
//        this.cidade = cidade;
//    }
//
//    public void setCep(String cep) {
//        this.cep = cep;
//    }
//
//    public void setUf(String uf) {
//        this.uf = uf;
//    }
//
//    // Definição do EQUALS da Classe [Fornecedor];
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 67 * hash + this.codigo_fornecedor;
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Fornecedor other = (Fornecedor) obj;
//        return this.codigo_fornecedor == other.codigo_fornecedor;
//    }
//
//    // Definição do TOSTRING da Classe [Fornecedor];
//    @Override
//    public String toString() {
//        return "Fornecedores{" + "codigo_fornecedor=" + codigo_fornecedor + ", nome=" + nome + ", cnpj=" + cnpj + '}';
//    }
//
//}
