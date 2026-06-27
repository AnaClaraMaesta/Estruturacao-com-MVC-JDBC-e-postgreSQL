package Controller;

import Model.Tutor;
import Service.TutorService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TutorController {
    private TutorService service = new TutorService();

    public void cadastrar(String nome, String endereco, String telefone) throws SQLException {
        try{
            Tutor tutor = new Tutor(nome,endereco, telefone);
            Tutor salvo = tutor;
            service.cadastrar(salvo);
            System.out.println("Salvo com sucesso!" + salvo);
        } catch (IllegalArgumentException e) {
        System.out.println("Erro de validação: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

    public void listar() throws SQLException {
        try{
            List<Tutor> tutores = service.listarTudo();

            if(tutores.isEmpty()){
                System.out.println("Nenhum Tutor encontrado!");
            }
            else{
                for (Tutor tutor : tutores) {
                    System.out.println(tutor);
                }
            }
        }catch(SQLException e){
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

    public Optional<Tutor> buscar(long id) throws SQLException {
        try{
            Optional<Tutor> tutor = service.buscarPorId(id);
            tutor.ifPresentOrElse(
                    t -> System.out.println("Tutor encontrado: " + t),
                    () -> System.out.println("Tutor não encontrado.")
            );
            return tutor;


            /* if(tutor.isPresent()){
                System.out.println(tutor.get());
            }else{
                System.out.println("Tutor não encontrado!");
            }*/


        }catch (SQLException e){
            System.out.println("Erro no banco: " + e.getMessage());
            return Optional.empty();
        }
    }

    public void deletar(long id) throws SQLException {
        try{
            service.deletar(id);
        }catch (SQLException e){
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }
}
