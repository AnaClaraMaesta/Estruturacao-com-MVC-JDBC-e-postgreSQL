package Controller;

import Model.Cliente;
import Repository.ClienteRepository;
import Service.ClienteService;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ClienteController {

    ClienteService clienteService = new ClienteService();

    public void cadastrar(String nome, String telefone) throws SQLException {
        try {
            Cliente cliente = new Cliente( nome, telefone);
            Cliente salvo = clienteService.Salvar(cliente);
            System.out.println("Cliente cadastrado\n" + salvo + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

    public Optional<Cliente> buscarPorId(long id) {
        try {
            Optional<Cliente> cliente = clienteService.buscarPorId(id);
            cliente.ifPresentOrElse(
                    a -> System.out.println(a + "\n"),
                    () -> System.out.println("Cliente não encontrado.")
            );
            return cliente;
        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
            return Optional.empty();
        }
    }

    public void listarTodos() {
        try {
            List<Cliente> clientes = clienteService.listarTudo();

            if (clientes.isEmpty()) {
                System.out.println("Nenhum cliente encontrado.");
            } else {
                System.out.println("\n=== LISTA DE CLIENTES ===");
                for (Cliente a : clientes) {
                    System.out.printf("ID: %d | Nome: %s | Telefone: %s\n",
                            a.getId(), a.getNome(), a.getTelefone());
                }
            }
        } catch(SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

    public void update(long id, String nome, String telefone) throws SQLException {
        try{
            clienteService.update(id, nome, telefone);
        }catch (SQLException e){
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

    public void excluir(long id) throws SQLException {
        try{
            clienteService.delete(id);
        }catch(SQLException e){
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }
}



