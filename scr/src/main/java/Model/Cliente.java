package Model;

public class Cliente {
    private long id;
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public Cliente(long id, String nome, String telefone){
        this(nome, telefone);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
