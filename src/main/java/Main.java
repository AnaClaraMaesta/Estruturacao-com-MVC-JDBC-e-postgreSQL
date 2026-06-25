import Controller.AnimalController;
import Controller.ConsultaController;
import Controller.TutorController;
import Model.Animal;

import java.sql.SQLException;
import java.util.Scanner;

Scanner scan = new Scanner(System.in);
AnimalController animalController = new AnimalController();
TutorController tutorController = new TutorController();
ConsultaController consultaController = new ConsultaController();

void main() throws SQLException {
    boolean encerrar = false;

    do{
        System.out.println("==========SISTEMA CLINICA VETERINARIA==========");
        System.out.println("1| ANIMAL");
        System.out.println("2| TUTOR");
        System.out.println("3| CONSULTAS");
        System.out.println("0| ENCERRAR SISTEMA");
        System.out.println(":");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                System.out.println("1| Cadastrar animal");
                System.out.println("2| Listar por tutor");
                System.out.println("3| Consultar por id");
                System.out.println("0| Retornar");
                System.out.println(":");
                int value = scan.nextInt();

                gerenciarAnimal(value);
                break;

            case 2:
                System.out.println("1| Cadastrar Tutor");
                System.out.println("2| Buscar Tutor");
                System.out.println("3| Listar todos");
                System.out.println("0| Retornar");
                System.out.println(":");
                scan.nextLine();
                value = scan.nextInt();

                gerenciarTutor(value);
                break;

            case 3:
                System.out.println("1| Cadastrar consulta");
                System.out.println("2| Buscar por animal");
                System.out.println("0| Retornar");
                System.out.println(":");
                scan.nextLine();
                value = scan.nextInt();

                gerenciarConsulta(value);
                break;

            case 0:
                System.out.println("Encerrando...");
                encerrar = true;
                break;

            default:
                System.out.println("Valor inválido");
        }
    }while(!encerrar == true);
}

public void gerenciarAnimal(int value) throws SQLException {
    switch (value) {
        case 1 -> {
            System.out.print("Nome do animal: ");
            String nome = scan.nextLine();

            System.out.print("Raça de " + nome + ": ");
            String raca = scan.nextLine();
            System.out.print("Espécie de " + nome + ": ");
            String especie = scan.nextLine();

            animalController.cadastrar(nome, especie, raca);
        }
        case 2 ->{
            System.out.println("1| Id do tutor: ");
            long id_tutor = scan.nextLong();
            scan.nextLine();

            animalController.listarPorTutor(id_tutor);
        }
        case 3 ->{
            System.out.println("1| Id do animal: ");
            long id_animal = scan.nextLong();
            scan.nextLine();

            animalController.buscarPorId(id_animal);
        }
        case 0->{
            main();
        }
    }
}

public void gerenciarTutor(int value) throws SQLException {
    switch (value) {
        case 1 -> {
            System.out.println("Nome do tutor: ");
            String nome = scan.nextLine();
            System.out.println("Endereco: ");
            String endereco = scan.nextLine();
            System.out.println("Telefone: ");
            String telefone = scan.nextLine();

            tutorController.cadastrar(nome, endereco, telefone);
        }
        case 2 ->{
            System.out.println("1| Id do tutor: ");
            long id_tutor = scan.nextLong();
            scan.nextLine();

            tutorController.buscar(id_tutor);
        }
        case 3 ->{
            tutorController.listar();
        }
        case 0->{
            main();
        }
    }
}

public void gerenciarConsulta(int value){

}