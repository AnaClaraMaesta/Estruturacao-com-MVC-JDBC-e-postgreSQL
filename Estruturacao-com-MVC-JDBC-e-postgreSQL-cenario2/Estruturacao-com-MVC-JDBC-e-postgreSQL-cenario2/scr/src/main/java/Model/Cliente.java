package Model;

public class Cliente {
    private long id;
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone){

        if(nome == null || nome.isBlank() || telefone == null || telefone.isBlank()){
            throw new IllegalArgumentException("Informe o nome e o telefone");
        }

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


    @Override
    public String toString() {
        return String.format("ID: %d | Nome: %s | Telefone: %s\n",
                id, nome, telefone);
    }

}
