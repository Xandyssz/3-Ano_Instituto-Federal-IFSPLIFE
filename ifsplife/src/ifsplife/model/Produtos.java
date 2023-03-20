package ifsplife.model;

public class Produtos {

    // Definição dos Atributos da Classe [Produto];
    private int codigo_prdotuo;
    private String nome_produto;
    private double dosagem_produto;
    private int quantidade_produto;
    private double valor_produto;

    // Definição do construtor VAZIO da Classe [Produto]; 
    public Produtos() {
    }

    // Definição do construtor preenchido da Classe [Produto];
    public Produtos(int codigo_prdotuo, String nome_produto, double dosagem_produto, int quantidade_produto, double valor_produto) {
        this.codigo_prdotuo = codigo_prdotuo;
        this.nome_produto = nome_produto;
        this.dosagem_produto = dosagem_produto;
        this.quantidade_produto = quantidade_produto;
        this.valor_produto = valor_produto;
    }

    // Definição dos Getters da Classe [Produto];
    public int getCodigo_prdotuo() {
        return codigo_prdotuo;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public double getDosagem_produto() {
        return dosagem_produto;
    }

    public int getQuantidade_produto() {
        return quantidade_produto;
    }

    public double getValor_produto() {
        return valor_produto;
    }

    // Definição dos Setters da Classe [Produto];
    public void setCodigo_prdotuo(int codigo_prdotuo) {
        this.codigo_prdotuo = codigo_prdotuo;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public void setDosagem_produto(double dosagem_produto) {
        this.dosagem_produto = dosagem_produto;
    }

    public void setQuantidade_produto(int quantidade_produto) {
        this.quantidade_produto = quantidade_produto;
    }

    public void setValor_produto(double valor_produto) {
        this.valor_produto = valor_produto;
    }

    // Definição do EQUALS da Classe [Produto];
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.codigo_prdotuo;
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
        final Produtos other = (Produtos) obj;
        return this.codigo_prdotuo == other.codigo_prdotuo;
    }
    // Definição do TOSTRING da Classe [Produto];

    @Override
    public String toString() {
        return "Produtos{" + "codigo_prdotuo=" + codigo_prdotuo + ", nome_produto=" + nome_produto + ", quantidade_produto=" + quantidade_produto + ", valor_produto=" + valor_produto + '}';
    }

}
