package Controller;

import Model.Animal;
import Model.Tutor;
import Service.AnimalService;

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
}