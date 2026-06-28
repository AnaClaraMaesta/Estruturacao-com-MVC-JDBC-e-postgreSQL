import Controller.ClienteController;
import Controller.ServicoController;
import Controller.VeiculoController;
import Model.Veiculo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Scanner;

Scanner scan = new Scanner(System.in);


ClienteController clienteController = new ClienteController();
VeiculoController veiculoController = new VeiculoController();
ServicoController servicoController = new ServicoController();
void main() throws SQLException {
    boolean encerrar = false;
    int value;

    do{
        System.out.println("==========SISTEMA==========");
        System.out.println("1| CLIENTES");
        System.out.println("2| VEICULOS");
        System.out.println("3| SERVIÇOS");
        System.out.println("0| ENCERRAR SISTEMA");
        System.out.println(":");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                System.out.println("1| Cadastrar clientes");
                System.out.println("2| Listar todos os clientes");
                System.out.println("3| Consultar cliente por id");
                System.out.println("4| Atualizar cliente");
                System.out.println("5| Deletar cliente");
                System.out.println("0| Retornar");
                System.out.println(":");
                value = scan.nextInt();
                scan.nextLine();

                gerenciarClientes(value);
                break;

            case 2:
                System.out.println("1| Cadastrar veiculo");
                System.out.println("2| Listar todos os veiculos");
                System.out.println("3| Consultar veiculo por id");
                System.out.println("4| Atualizar veiculo");
                System.out.println("5| Deletar veiculo");
                System.out.println("0| Retornar");
                System.out.println(":");
                value = scan.nextInt();
                scan.nextLine();

                gerenciarVeiculos(value);
                break;

            case 3:
                System.out.println("1| Registrar Serviço: ");
                System.out.println("2| Consultar Serviço por id do cliente:");
                System.out.println("3| Deletar Matricula");
                System.out.println("0| Retornar");
                System.out.println(":");
                value = scan.nextInt();
                scan.nextLine();

                gerenciarServico(value);
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

public void gerenciarVeiculos(int value) throws SQLException {
    switch (value) {
        case 1 -> {
            System.out.print("Placa do veiculo: ");
            String placa = scan.nextLine();
            System.out.print("Modelo do veiculo: ");
            String modelo = scan.nextLine();
            System.out.print("Ano do veiculo: ");
            int ano = scan.nextInt();

           veiculoController.cadastrar(placa, modelo, ano);
        }
        case 2 -> {
          veiculoController.listarTodos();
        }
        case 3 -> {
            System.out.println("id do veiculo a consultar: ");
            long id= scan.nextLong();
            veiculoController.buscarPorId(id);
        }
        case 4 -> {
            System.out.println("id do veiculo a atualizar: ");
            long id = scan.nextLong();
            System.out.print("Placa do veiculo: ");
            scan.nextLine();
            String placa = scan.nextLine();
            System.out.print("Modelo do veiculo: ");
            String modelo = scan.nextLine();
            System.out.print("Ano do veiculo: ");
            int ano = scan.nextInt();
            veiculoController.update(id, placa, modelo, ano);
        }
        case 5 -> {
            System.out.println("Id do veiculo a ser deletado");
            long id = scan.nextLong();
            veiculoController.excluir(id);
        }
        case 0 -> {
            main();
        }
    }
}

public void gerenciarClientes(int value) throws SQLException {
    switch (value) {
        case 1 -> {
            System.out.print("Nome do Cliente: ");
            String nome = scan.nextLine();
            System.out.print("Telefone: ");
            String telefone = scan.nextLine();
            clienteController.cadastrar(nome, telefone);
        }
        case 2 -> {
           clienteController.listarTodos();
        }
        case 3 -> {
            System.out.println("id do cliente a consultar: ");
            long id = scan.nextLong();
            clienteController.buscarPorId(id);
        }
        case 4 -> {
            System.out.println("id do Cliente a atualizar: ");
            long id = scan.nextLong();
            System.out.print("Informar nome: ");
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.print("Informar telefone: ");
            String telefone = scan.nextLine();
            clienteController.update(id, nome, telefone);
        }
        case 5 -> {
            System.out.println("Id do Cliente a ser deletado: ");
            long id = scan.nextLong();
            clienteController.excluir(id);
        }
        case 0 -> {
            main();
        }
    }
}

public void gerenciarServico(int value) throws SQLException {
    switch (value) {
        case 1 -> {
            System.out.println("Id do cliente: ");
            long id_cliente = scan.nextLong();
            scan.nextLine();
            System.out.println("Id do veiculo: ");
            long id_veiculo = scan.nextLong();
            scan.nextLine();
            System.out.println("Valor: ");
            BigDecimal valor = scan.nextBigDecimal();
            System.out.println("Descrição: ");
            scan.nextLine();
            String descricao = scan.nextLine();
            System.out.println("está concluido? 1| true 2| false:");
            int choice = scan.nextInt();

            boolean status;

            if(choice==1){
                status = true;
            }else{
                status = false;
            }

            Cliente cliente = clienteController.buscarPorId(id_cliente).orElse(null);
            if (cliente == null) {
                return;
            }
            Veiculo veiculo = veiculoController.buscarPorId(id_veiculo).orElse(null);
            if (veiculo == null) {
                return;
            }
            servicoController.cadastrar(cliente,veiculo, valor, descricao, status );
        }
        case 2 -> {

            servicoController.listarTodos();
        }

        case 3 -> {
            System.out.println("Informe o Id do cliente: ");
            long id_cliente = scan.nextLong();
            List<Servico> consultas = servicoController.listarPorCliente(id_cliente);
            if (consultas.isEmpty()) {
                System.out.println("Nenhuma consulta encontrada.");
            } else {
                consultas.forEach(System.out::println);
            }
        }
        case 4 -> {
            System.out.println("id do Cliente a atualizar: ");
            long id = scan.nextLong();
            System.out.print("Informar nome: ");
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.print("Informar telefone: ");
            String telefone = scan.nextLine();
            clienteController.update(id, nome, telefone);
        }
        case 5 -> {
            System.out.println("Id do serviço a ser deletado: ");
            long id = scan.nextLong();
            clienteController.excluir(id);
        }
        case 0 -> {
            main();
        }
    }
}
