package Controller;

import Model.Veiculo;
import Service.VeiculoService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class VeiculoController {

    VeiculoService veiculoService = new VeiculoService();

    public void cadastrar(String placa, String modelo, int ano) throws SQLException {
        try {
            Veiculo veiculo = new Veiculo(placa, modelo, ano);
            Veiculo salvo = veiculoService.Salvar(veiculo);
            System.out.println("Veiculo cadastrado\n" + salvo + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

    public Optional<Veiculo> buscarPorId(long id) {
        try {
            Optional<Veiculo> veiculo = veiculoService.buscarPorId(id);
            veiculo.ifPresentOrElse(
                    a -> System.out.println(a + "\n"),
                    () -> System.out.println("Veiculo não encontrado.")
            );
            return veiculo;
        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
            return Optional.empty();
        }
    }

    public void listarTodos() {
        try {
            List<Veiculo> veiculos = veiculoService.listarTudo();

            if (veiculos.isEmpty()) {
                System.out.println("Nenhum Veiculo encontrado.");
            } else {
                System.out.println("\n=== LISTA DE VEICULOS ===");
                for (Veiculo a : veiculos) {
                    System.out.printf("ID: %d | Placa: %s | Modelo: %s | Ano:%d\n",
                            a.getId(), a.getPlaca().toUpperCase(), a.getModelo(), a.getAno());
                }
            }
        } catch(SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

    public void update(long id, String placa, String modelo, int ano) throws SQLException {
        try{
            veiculoService.update(id, placa, modelo, ano);
        }catch (SQLException e){
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

    public void excluir(long id) throws SQLException {
        try{
            veiculoService.delete(id);
        }catch(SQLException e){
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

}
