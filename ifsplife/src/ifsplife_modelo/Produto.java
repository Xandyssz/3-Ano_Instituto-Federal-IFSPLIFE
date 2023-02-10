/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsplife_modelo;

/**
 *
 * @author xandy
 */
public class Produto {

    // 01. Definição dos Atributos da Classe
    private int codigo_produto;
    private String nome_produto;
    private double dosagem_produto;
    private int quantidade_produto;
    private double valor_produto;

    // 02. Construtor Vázio
    public Produto() {
    }

    // 03. Construtor Preenchido
    public Produto(int codigo_produto, String nome_produto, double dosagem_produto, int quantidade_produto, double valor_produto) {
        this.codigo_produto = codigo_produto;
        this.nome_produto = nome_produto;
        this.dosagem_produto = dosagem_produto;
        this.quantidade_produto = quantidade_produto;
        this.valor_produto = valor_produto;
    }

     // 04. Metodos Getters e Setters - *INICIO*
    public int getCodigo_produto() {
        return codigo_produto;
    }

    public void setCodigo_produto(int codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public double getDosagem_produto() {
        return dosagem_produto;
    }

    public void setDosagem_produto(double dosagem_produto) {
        this.dosagem_produto = dosagem_produto;
    }

    public int getQuantidade_produto() {
        return quantidade_produto;
    }

    public void setQuantidade_produto(int quantidade_produto) {
        this.quantidade_produto = quantidade_produto;
    }

    public double getValor_produto() {
        return valor_produto;
    }

    public void setValor_produto(double valor_produto) {
        this.valor_produto = valor_produto;
    }
     // 04. Metodos Getters e Setters - *FIM*

}
