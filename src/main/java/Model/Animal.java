package Model;

public class Animal {
    private String nome;
    private String especie;
    private String raca;

    public Animal(String nome, String especie, String raca) {
        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome do animal não pode ser vazio");
        }

        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    @Override
    public String toString() {
        return "Animal => [" +
                "nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", raca='" + raca + '\'' +
                ']';
    }
}
