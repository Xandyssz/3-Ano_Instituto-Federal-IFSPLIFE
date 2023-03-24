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
//    @NamedQuery(name = "Produto.todos",
//            query = "SELECT p FROM Produto p"),
//    @NamedQuery(name = "Fornecedor.porNome",
//            query = "SELECT p FROM Produto p WHERE p.nome LIKE :nomequalquer")
//})
//
//// indicando ao JPA qual a tabela será utilizada
//// para armazenar os objetos dessa classe
//@Table(name = "produtos")
//// 01. Definição dos Atributos da Classe
//
//public class Produto implements Serializable {
//
//    // Definição dos Atributos da Classe [Produto];
//    // Definição dos Atributos da Classe [Funcionario];
//    @Id   // indica ao JPA que codigo será a chave primária
//    // @Column - name -> indica o nome do campo da tabela
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    // Definição dos Atributos da Classe [Fornecedor];
//    private int codigo_produto;
//
//    @Column(name = "nome", length = 255, nullable = false)
//    private String nome;
//
//    @Column(name = "dosagem", length = 255, nullable = true)
//    private double dosagem;
//
//    @Column(name = "quantidade", nullable = false)
//    private int quantidade;
//
//    @Column(name = "valor", nullable = false)
//    private double valor;
//
//    // Definição do construtor VAZIO da Classe [Produto]; 
//    public Produto() {
//    }
//
//    // Definição do construtor preenchido da Classe [Produto];
//    public Produto(int codigo_produto, String nome, double dosagem, int quantidade, double valor) {
//        this.codigo_produto = codigo_produto;
//        this.nome = nome;
//        this.dosagem = dosagem;
//        this.quantidade = quantidade;
//        this.valor = valor;
//    }
//
//    // Definição dos Getters da Classe [Produto];
//    public int getCodigo() {
//        return codigo_produto;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public double getDosagem() {
//        return dosagem;
//    }
//
//    public int getQuantidade() {
//        return quantidade;
//    }
//
//    public double getValor() {
//        return valor;
//    }
//
//    // Definição dos Setters da Classe [Produto];
//    public void setCodigo_produto(int codigo_produto) {
//        this.codigo_produto = codigo_produto;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public void setDosagem(double dosagem) {
//        this.dosagem = dosagem;
//    }
//
//    public void setQuantidade(int quantidade) {
//        this.quantidade = quantidade;
//    }
//
//    public void setValor(double valor) {
//        this.valor = valor;
//    }
//
//    // Definição do EQUALS da Classe [Produto];
//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 67 * hash + this.codigo_produto;
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
//        final Produto other = (Produto) obj;
//        return this.codigo_produto == other.codigo_produto;
//    }
//    // Definição do TOSTRING da Classe [Produto];
//
//    @Override
//    public String toString() {
//        return "Produtos{" + "codigo_produto=" + codigo_produto + ", nome=" + nome + ", quantidade=" + quantidade + ", valor=" + valor + '}';
//    }
//
//}
