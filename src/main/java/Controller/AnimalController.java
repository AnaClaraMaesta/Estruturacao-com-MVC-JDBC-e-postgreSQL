package Controller;

import Model.Animal;
import Model.Tutor;
import Service.AnimalService;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AnimalController {
    private AnimalService service = new AnimalService();

    public void cadastrar(String nome, String especie, String raca) throws SQLException {
        try {
            Animal animal = new Animal(nome, especie, raca);
            Animal salvo = service.cadastrar(animal);
            System.out.println("Animal cadastrado com sucesso! " + salvo);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

    public void listarPorTutor(long tutorId) {
        try {
            List<Animal> animais = service.listarPorTutor(tutorId);
            if (animais.isEmpty()) {
                System.out.println("Nenhum animal cadastrado para esse tutor.");
            } else {
                animais.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

    public Optional<Animal> buscarPorId(long id) {
        try {
            Optional<Animal> animal = service.buscarPorId(id);
            animal.ifPresentOrElse(
                    a -> System.out.println("Animal encontrado: " + a),
                    () -> System.out.println("Animal não encontrado.")
            );
            return animal;
        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
            return Optional.empty();
        }
    }

    public void listarTodos() {
        try {
            List<Animal> animais = service.listarTudo();

            if (animais.isEmpty()) {
                System.out.println("Nenhum animal encontrado.");
            } else {
                System.out.println("\n=== LISTA DE ANIMAIS ===");
                for (Animal a : animais) {
                    System.out.printf("ID: %d | Nome: %s | Espécie: %s | Raça: %s%n",
                            a.getId(), a.getNome(), a.getEspecie(), a.getRaca());
                }
            }
        } catch(SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

    public void update(long id, String nome, String raca, String especie) throws SQLException {
        try{
            service.update(id, nome, especie,raca);
        }catch (SQLException e){
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

    public void excluir(long id_animal) throws SQLException {
        try{
            service.deletar(id_animal);
        }catch(SQLException e){
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }
}