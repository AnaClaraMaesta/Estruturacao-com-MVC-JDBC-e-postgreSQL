package Controller;

import Model.Cliente;
import Model.Servico;
import Model.Veiculo;
import Service.ClienteService;
import Service.ServicoService;
import Service.VeiculoService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ServicoController {

    ServicoService servicoService = new ServicoService();
    VeiculoService veiculoService = new VeiculoService();
    ClienteService clienteService = new ClienteService();

    public void cadastrar(Veiculo veiculo, Cliente cliente, BigDecimal valor, String descricao, boolean isConcluida) throws SQLException {
        try {
            Servico servico = new Servico(veiculo, cliente,valor,descricao,isConcluida);
            Servico salvo = servicoService.Salvar(servico);
            System.out.println("Cliente cadastrado\n" + salvo + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }


    public Optional<Servico> buscarPorIdCliente(long id) {
        try {
            Optional<Servico> servico = Optional.ofNullable(servicoService.buscarPorIdCliente(id));
            servico.ifPresentOrElse(
                    a -> System.out.println(a + "\n"),
                    () -> System.out.println("Cliente não encontrado.")
            );
            return servico;
        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
            return Optional.empty();
        }
    }

    public void excluir(long id) throws SQLException {
        try{
            servicoService.delete(id);
        }catch(SQLException e){
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

}
