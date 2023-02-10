/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsplife_modelo;

/**
 *
 * @author xandy
 */
public class Convenio {

    // 01. Definição dos Atributos da Classe
    private int codigo_convenio;
    private String nome_convenio;
    private String telefone_convenio;
    private double desconto_convenio;

    // 02. Construtor Vázio
    public Convenio() {
    }

    // 03. Construtor Preenchido
    public Convenio(int codigo_convenio, String nome_convenio, String telefone_convenio, double desconto_convenio) {
        this.codigo_convenio = codigo_convenio;
        this.nome_convenio = nome_convenio;
        this.telefone_convenio = telefone_convenio;
        this.desconto_convenio = desconto_convenio;
    }

    // 04. Metodos Getters e Setters - *INICIO*
    public int getCodigo_convenio() {
        return codigo_convenio;
    }

    public void setCodigo_convenio(int codigo_convenio) {
        this.codigo_convenio = codigo_convenio;
    }

    public String getNome_convenio() {
        return nome_convenio;
    }

    public void setNome_convenio(String nome_convenio) {
        this.nome_convenio = nome_convenio;
    }

    public String getTelefone_convenio() {
        return telefone_convenio;
    }

    public void setTelefone_convenio(String telefone_convenio) {
        this.telefone_convenio = telefone_convenio;
    }

    public double getDesconto_convenio() {
        return desconto_convenio;
    }

    public void setDesconto_convenio(double desconto_convenio) {
        this.desconto_convenio = desconto_convenio;
    }
   // 04. Metodos Getters e Setters - *FIM*

    
    
}
