package ifsplife.model;

public class Convenios {

    // Definição dos Atributos da Classe [Convenio];
    private int codigo_convenio;
    private String nome_convenio;
    private String telefone_convenio;
    private double desconto_convenio;

    // Definição do construtor VAZIO da Classe [Convenio]; 
    public Convenios() {
    }
    // Definição do construtor preenchido da Classe [Convenio];

    public Convenios(int codigo_convenio, String nome_convenio, String telefone_convenio, double desconto_convenio) {
        this.codigo_convenio = codigo_convenio;
        this.nome_convenio = nome_convenio;
        this.telefone_convenio = telefone_convenio;
        this.desconto_convenio = desconto_convenio;
    }

    // Definição dos Getters da Classe [Convenio];
    public int getCodigo_convenio() {
        return codigo_convenio;
    }

    public String getNome_convenio() {
        return nome_convenio;
    }

    public String getTelefone_convenio() {
        return telefone_convenio;
    }

    public double getDesconto_convenio() {
        return desconto_convenio;
    }

    // Definição dos Setters da Classe [Convenio];
    public void setCodigo_convenio(int codigo_convenio) {
        this.codigo_convenio = codigo_convenio;
    }

    public void setNome_convenio(String nome_convenio) {
        this.nome_convenio = nome_convenio;
    }

    public void setTelefone_convenio(String telefone_convenio) {
        this.telefone_convenio = telefone_convenio;
    }

    public void setDesconto_convenio(double desconto_convenio) {
        this.desconto_convenio = desconto_convenio;
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
        final Convenios other = (Convenios) obj;
        return this.codigo_convenio == other.codigo_convenio;
    }
    // Definição do TOSTRING da Classe [Convenio];

    @Override
    public String toString() {
        return "Convenios{" + "codigo_convenio=" + codigo_convenio + ", nome_convenio=" + nome_convenio + '}';
    }

}
