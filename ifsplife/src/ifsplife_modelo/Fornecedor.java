/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsplife_modelo;

/**
 *
 * @author xandy
 */
public class Fornecedor {

    // 01. Definição dos Atributos da Classe
    private int codigo_fornecedor;
    private String nome_fornecedor;
    private String cnpj_fornecedor;
    private String endereco_fornecedor;
    private String telefone_fornecedor;

    // 02. Construtor Vázio
    public Fornecedor() {
    }

    // 03. Construtor Preenchido
    public Fornecedor(int codigo_fornecedor, String nome_fornecedor, String cnpj_fornecedor, String endereco_fornecedor, String telefone_fornecedor) {
        this.codigo_fornecedor = codigo_fornecedor;
        this.nome_fornecedor = nome_fornecedor;
        this.cnpj_fornecedor = cnpj_fornecedor;
        this.endereco_fornecedor = endereco_fornecedor;
        this.telefone_fornecedor = telefone_fornecedor;
    }
     // 04. Metodos Getters e Setters - *INICIO*

    public int getCodigo_fornecedor() {
        return codigo_fornecedor;
    }

    public void setCodigo_fornecedor(int codigo_fornecedor) {
        this.codigo_fornecedor = codigo_fornecedor;
    }

    public String getNome_fornecedor() {
        return nome_fornecedor;
    }

    public void setNome_fornecedor(String nome_fornecedor) {
        this.nome_fornecedor = nome_fornecedor;
    }

    public String getCnpj_fornecedor() {
        return cnpj_fornecedor;
    }

    public void setCnpj_fornecedor(String cnpj_fornecedor) {
        this.cnpj_fornecedor = cnpj_fornecedor;
    }

    public String getEndereco_fornecedor() {
        return endereco_fornecedor;
    }

    public void setEndereco_fornecedor(String endereco_fornecedor) {
        this.endereco_fornecedor = endereco_fornecedor;
    }

    public String getTelefone_fornecedor() {
        return telefone_fornecedor;
    }

    public void setTelefone_fornecedor(String telefone_fornecedor) {
        this.telefone_fornecedor = telefone_fornecedor;
    }
    // 04. Metodos Getters e Setters - *FIM*

}
