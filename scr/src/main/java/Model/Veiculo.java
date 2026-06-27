package Model;

public class Veiculo {
    private long id;
    private String placa;
    private String modelo;
    private int ano;

    public Veiculo(String placa, String modelo, int ano) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
    }

    public Veiculo(long id, String placa, String modelo, int ano) {}
        this(placa, modelo, ano);
        this.id = id;
}
