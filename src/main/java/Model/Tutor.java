package Model;

public class Tutor {
    private String nome;
    private String telefone;
    private String endereco;

    public Tutor(String nome, String telefone, String endereco) {
        if(nome == null || nome.isBlank() || endereco == null || endereco.isBlank()){
            throw new IllegalArgumentException("Informe algum meio de contato");
        }

        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Tutor => [" +
                "nome: '" + nome + '\'' +
                ", telefone: '" + telefone + '\'' +
                ", endereco: '" + endereco + '\'' +
                ']';
    }
}
