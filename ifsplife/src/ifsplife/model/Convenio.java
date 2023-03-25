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
    @NamedQuery(name = "Convenio.todos",
            query = "SELECT c FROM Convenio c"),
    @NamedQuery(name = "Convenio.porNome",
            query = "SELECT c FROM Convenio c WHERE c.nome LIKE :nomequalquer")
})

// indicando ao JPA qual a tabela será utilizada
// para armazenar os objetos dessa classe
@Table(name = "convenios")
// 01. Definição dos Atributos da Classe

public class Convenio implements Serializable {

    // Definição dos Atributos da Classe [Convenio];
    @Id   // indica ao JPA que codigo será a chave primária
    // @Column - name -> indica o nome do campo da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_convenio")
    private int codigo_convenio;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Column(name = "cnpj", length = 20, nullable = false)
    private String cnpj;

    @Column(name = "telefone", length = 255, nullable = false)
    private String telefone;

    @Column(name = "endereco", length = 255, nullable = false)
    private String endereco;

    @Column(name = "desconto", nullable = false)
    private double desconto;

    // Definição do construtor VAZIO da Classe [Convenio]; 
    public Convenio() {
    }
    
    // Definição do construtor preenchido da Classe [Convenio];
    public Convenio(int codigo_convenio, String nome, String email, String cnpj, String telefone, String endereco, double desconto) {
        this.codigo_convenio = codigo_convenio;
        this.nome = nome;
        this.email = email;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.endereco = endereco;
        this.desconto = desconto;
    }

    // Definição dos Getters da Classe [Convenio];
    public int getCodigo() {
        return codigo_convenio;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getDesconto() {
        return desconto;
    }

    // Definição dos Setters da Classe [Convenio];
    public void setCodigo_convenio(int codigo_convenio) {
        this.codigo_convenio = codigo_convenio;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

        public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }



    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    // Definição do EQUALS da Classe [Convenio];
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.codigo_convenio;
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
        final Convenio other = (Convenio) obj;
        return this.codigo_convenio == other.codigo_convenio;
    }
    // Definição do TOSTRING da Classe [Convenio];

    @Override
    public String toString() {
        return "Convenios{" + "codigo_convenio=" + codigo_convenio + ", nome=" + nome + '}';
    }

}
