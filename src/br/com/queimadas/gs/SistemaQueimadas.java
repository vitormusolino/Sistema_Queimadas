package br.com.queimadas.gs;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaQueimadas {
    private Scanner scanner = new Scanner(System.in);
    private List<Queimada> listaQueimadas;
    private int proximoID;

    public SistemaQueimadas() {
        this.listaQueimadas = new ArrayList<>();
        this.proximoID = 1;
    }

    public void cadastroQueimadas(){
        System.out.println("Cadastro de queimadas: \n" +
                            "*********************");
        System.out.println("Primeiro vamos cadastrar a localização da queimada: \n");

        System.out.print("Município: ");
        String municipio = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("País: ");
        String pais = scanner.nextLine();
        Localizacao localizacao = new Localizacao(municipio, estado, pais);

        System.out.println("Agora vamos cadastrar os detalhes da queimada: \n");
        int id = proximoID++;
        System.out.println("ID da Queimada gerado automaticamente: " + id);
        System.out.println("Cadastre o horário da queimada: ");
        String horario = scanner.nextLine();

        Queimada queimada = new Queimada(id, localizacao, horario);
        listaQueimadas.add(queimada);
    }

    public void listarQueimadas(){
        System.out.println("Lista de queimadas: \n");
        System.out.println(listaQueimadas);
    }

    public void iniciar() {
        int opcao = -1;

        while(opcao != 0){
            String mensagemSistema = """
                    BEM VINDO AO SISTEMA DE QUEIMADAS, O QUE DESEJA FAZER?
                    -----------------------------------------------------
                        1- Cadastrar Queimadas
                        2- Listar Queimadas
                        0- Sair
                    -----------------------------------------------------
                        Digite sua opção: \n
                    """;

            System.out.println(mensagemSistema);
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1 || opcao == 2 || opcao == 0){
                if(opcao == 1){
                    cadastroQueimadas();
                }else if(opcao == 2){
                    listarQueimadas();
                }else{
                    System.out.println("Adeus!");
                    break;
                }
            }else {
                System.out.println("Opção inválida! Por favor, digite 0, 1 ou 2.");
                opcao = -1;
            }
        }

    }
}
