package Controller;

import Model.Animal;
import Model.Consulta;
import Model.Tutor;
import Repository.ConsultaRepository;
import Service.ConsultaService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

public class ConsultaController {
    private ConsultaService service = new  ConsultaService();

    public void cadastrar(LocalDate dataConsulta, Animal animal, Tutor tutor, BigDecimal valor, String descricao) throws SQLException {
        try{
            Consulta consulta = new Consulta(dataConsulta, animal, tutor, valor, descricao);
            Consulta salvo = service.finalizar(consulta);
            System.out.println("Consulta cadastrado com sucesso! " + salvo);

        }catch (SQLException e){
            System.out.println("Erro no banco: " + e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println("Valor inválido: " + e.getMessage());
        }
    }

    public void listarPorAnimal(long id_animal) throws SQLException {
        try{
            service.listarPorAnimal(id_animal);
        }catch (SQLException e){
            System.out.println("Erro no banco: " + e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println("Valor inválido: " + e.getMessage());
        }
    }

    public void deletar(long id_consulta) throws SQLException {
        try{
            service.deletar(id_consulta);
        }catch (SQLException e){
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }
}
