/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifsplife_modelo;

/**
 *
 * @author xandy
 */
public class Usuario {

    // 01. Definição dos Atributos da Classe
    private int codigo_usuario;
    private String nome_usuario;
    private String cpf_usuario;
    private String endereco_usuario;
    private String telefone_usuario;
    private String cargo_funcionario;

    // 02. Construtor Vázio
    public Usuario() {
    }

    // 03. Construtor Preenchido
    public Usuario(int codigo_usuario, String nome_usuario, String cpf_usuario, String endereco_usuario, String telefone_usuario, String cargo_funcionario) {
        this.codigo_usuario = codigo_usuario;
        this.nome_usuario = nome_usuario;
        this.cpf_usuario = cpf_usuario;
        this.endereco_usuario = endereco_usuario;
        this.telefone_usuario = telefone_usuario;
        this.cargo_funcionario = cargo_funcionario;
    }
     // 04. Metodos Getters e Setters - *INICIO*

    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(String cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }

    public String getEndereco_usuario() {
        return endereco_usuario;
    }

    public void setEndereco_usuario(String endereco_usuario) {
        this.endereco_usuario = endereco_usuario;
    }

    public String getTelefone_usuario() {
        return telefone_usuario;
    }

    public void setTelefone_usuario(String telefone_usuario) {
        this.telefone_usuario = telefone_usuario;
    }

    public String getCargo_funcionario() {
        return cargo_funcionario;
    }

    public void setCargo_funcionario(String cargo_funcionario) {
        this.cargo_funcionario = cargo_funcionario;
    }
     // 04. Metodos Getters e Setters - *FIM*

}
