import org.trabalho.Controller.AlunosController;
import org.trabalho.Controller.CursosController;
import org.trabalho.Controller.MatriculaController;

import java.sql.SQLException;
import java.util.Scanner;

Scanner scan = new Scanner(System.in);


AlunosController alunoController = new AlunosController();
CursosController cursosController = new CursosController();
MatriculaController matriculaController = new MatriculaController();

void main() throws SQLException {
    boolean encerrar = false;
    int value;

    do{
        System.out.println("==========SISTEMA==========");
        System.out.println("1| ALUNOS");
        System.out.println("2| CURSOS");
        System.out.println("3| MATRICULAS");
        System.out.println("0| ENCERRAR SISTEMA");
        System.out.println(":");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                System.out.println("1| Cadastrar aluno");
                System.out.println("2| Listar todos os alunos");
                System.out.println("3| Consultar aluno por nome");
                System.out.println("4| Atualizar aluno");
                System.out.println("5| Deletar aluno");
                System.out.println("0| Retornar");
                System.out.println(":");
                 value = scan.nextInt();
                scan.nextLine();

                gerenciarAluno(value);
                break;

            case 2:
                System.out.println("1| Cadastrar curso");
                System.out.println("2| Listar todos os cursos");
                System.out.println("3| Consultar curso por nome");
                System.out.println("4| Atualizar curso");
                System.out.println("5| Deletar aluno");
                System.out.println("0| Retornar");
                System.out.println(":");
                value = scan.nextInt();
                scan.nextLine();

                gerenciarCursos(value);
                break;

            case 3:
                System.out.println("1| Efetuar Matricula: ");
                System.out.println("2| Listar todas as Matriculas");
                System.out.println("3| Consultar Matricula por curso");
                System.out.println("4| Consultar Matricula por aluno");
                System.out.println("5| Atualizar Matricula");
                System.out.println("6| Deletar Matricula");
                System.out.println("0| Retornar");
                System.out.println(":");
                value = scan.nextInt();
                scan.nextLine();

                gerenciarMatricula(value);
                break;

            case 0:
                System.out.println("Encerrando...");
                encerrar = true;
                break;

            default:
                System.out.println("Valor inválido");
        }
    }while(!encerrar);
}

public void gerenciarAluno(int value) throws SQLException {
    switch (value) {
        case 1 -> {
            System.out.print("Nome do aluno: ");
            String nome = scan.nextLine();
            System.out.print("email: ");
            String email = scan.nextLine();
            System.out.print("telefone: ");
            String telefone = scan.nextLine();

            alunoController.alunosCadastrar(nome, email, telefone);
        }
        case 2 -> {
            alunoController.alunosConsultaTodos();
        }
        case 3 -> {
            System.out.println("nome do aluno a consultar: ");
            String nome = scan.nextLine();
            alunoController.alunosConsultaNome(nome);
        }
        case 4 -> {
            System.out.println("id do aluno: ");
            Long id = scan.nextLong();

            System.out.print("Nome do aluno: ");
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.print("email: ");
            String email = scan.nextLine();
            System.out.print("telefone: ");
            String telefone = scan.nextLine();
            alunoController.alunosAtualisar(nome, email, telefone, id);
        }
        case 5 -> {
            System.out.println("Id do aluno a ser deletado");
            BigInteger id = scan.nextBigInteger();
            alunoController.alunosDeletar(id);
        }
        case 0 -> {
            main();
        }
    }
}

public void gerenciarCursos(int value) throws SQLException {
    switch (value) {
        case 1 -> {
            System.out.print("Nome do curso: ");
            String nome = scan.nextLine();
            System.out.print("descrição: ");
            String descricao = scan.nextLine();
            System.out.print("carga horaria: ");
            long carga_horaria = scan.nextLong();
            System.out.println("Total de vagas: ");
            int vagas_totais = scan.nextInt();
            System.out.println("Vagas Disponiveis: ");
            int vagas_disponiveis = scan.nextInt();
            cursosController.cursosCadastrar(nome, descricao, carga_horaria, vagas_totais, vagas_disponiveis);
        }
        case 2 -> {
            cursosController.cursosConsultaTodos();
        }
        case 3 -> {
            System.out.println("nome do curso a consultar: ");
            String nome = scan.nextLine();
            cursosController.cursosConsultaNome(nome);
        }
        case 4 -> {
            System.out.println("id do curso: ");
            Long id = scan.nextLong();
            System.out.print("Informar nome: ");
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.print("Informar descrição: ");
            String descricao = scan.nextLine();
            System.out.print("Informar nova carga horaria: ");
            long carga_horaria = scan.nextLong();
            System.out.print("Informar novo total de vagas: ");
            int vagas_totais = scan.nextInt();
            System.out.print("Informar nova quantidade de vagas: ");
            int vagas_disponiveis = scan.nextInt();

            cursosController.cursosAtualisar(nome, descricao, carga_horaria, vagas_totais, vagas_disponiveis, id);
        }
        case 5 -> {
            System.out.println("Id do curso a ser deletado: ");
            BigInteger id = scan.nextBigInteger();
            cursosController.cursosDeletar(id);
        }
        case 0 -> {
            main();
        }
    }
}

public void gerenciarMatricula(int value) throws SQLException {
    switch (value) {
        case 1 -> {
            System.out.println("id do aluno a ser matriculado: ");
            Long id_aluno = scan.nextLong();
            scan.nextLine();
            System.out.print("Nome do Aluno a ser Matriculado: ");
            String nome = scan.nextLine();
            System.out.println("id do curso a ser matriculado: ");
            Long id_curso = scan.nextLong();
            System.out.print("Nome do Curso a ser Matriculado: ");
            String curso = scan.nextLine();
            scan.nextLine();
            System.out.print("Valor da Matricula: ");
            BigDecimal valor = scan.nextBigDecimal();
            matriculaController.matriculaCadastrar(id_aluno, nome, id_curso, curso, valor );
        }

        case 2 -> {
            matriculaController.matriculaConsultaTodos();
        }
        case 3 -> {
            System.out.println("id do curso a consultar: ");
            Long id = scan.nextLong();
            matriculaController.matriculaConsultaCursosid(id);
        }

        case 4 -> {
            System.out.println("id do aluno a consultar: ");
            Long id = scan.nextLong();
            matriculaController.matriculaConsultaAlunosid(id);
        }
        case 5 -> {
            System.out.print("Id da Matricula para atualização: ");
            Long id = scan.nextLong();
            System.out.print("Novo valor da Matricula: ");
            BigDecimal valor = scan.nextBigDecimal();

            matriculaController.matriculaAtualisar(valor, id);
        }
        case 6 -> {
            System.out.println("Id da matricula a ser deletado: ");
            BigInteger id = scan.nextBigInteger();
            matriculaController.matriculaDeletar(id);
        }
        case 0 -> {
            main();
        }
    }
}