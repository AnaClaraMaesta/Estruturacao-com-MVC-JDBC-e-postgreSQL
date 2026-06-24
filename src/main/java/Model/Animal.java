package Model;

public class Animal {
    private long id;
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

    public Animal(long id, String nome, String especie, String raca) {
        this(nome, especie, raca);
        this.id = id;
    }

    public long getId() {
        return id;
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
