package br.com.queimadas.gs;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaQueimadas {
    private Scanner scanner = new Scanner(System.in);
    private List<Queimada> listaQueimadas;
    private List<Queimada> listaAtivas;
    private List<Queimada> listaControladas;
    private List<Queimada> listaResolvidas;
    private int proximoID;
    int opcao = -1;

    public SistemaQueimadas() {
        this.listaQueimadas = new ArrayList<>();
        this.listaAtivas = new ArrayList<>();
        this.listaControladas = new ArrayList<>();
        this.listaResolvidas = new ArrayList<>();
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
        listaAtivas.add(queimada);

        System.out.println("Você deseja ADICIONAR Causa e Tamanho da área impactada?\n" +
                           "Ou somente o Tamanho da Área?\n" +
                           "1 - Causa e tamanho da área\n" +
                           "2 - Tamanho da área\n" +
                           "3 - Não desejo informar");
        opcao = scanner.nextInt();
        scanner.nextLine();

        if(opcao == 1){
            System.out.println("Qual o tamanho da área afetada em hectáres? (Caso for especificar, usar vírgula) ");
            double area = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Qual foi a causa da queimada?");
            String causaQueimada = scanner.nextLine();

            queimada.registrarDetalhes(area,causaQueimada);
            System.out.println("Detalhes registrados com sucesso, informações da queimada: \n " + queimada);
        }else if(opcao == 2){
            System.out.println("Qual o tamanho da área afetada em hectáres? (Caso for especificar, usar vírgula) ");
            double area = scanner.nextDouble();
            scanner.nextLine();
            queimada.registrarDetalhes(area);
            System.out.println("Tamanho da área atualizada! Informações da queimada: " + queimada);
        }else{
            System.out.println("Queimada registrada!");
        }
    }

    public void listarQueimadas(){
        System.out.println("Lista de queimadas: \n");
        System.out.println(listaQueimadas);
    }

    public void atualizarQueimada(){
        System.out.println("Você deseja atualizar o status de uma queimada?\n" +
                "1- Sim\n" +
                "2- Não");
        opcao = scanner.nextInt();
        scanner.nextLine();

        if(opcao == 1){
            System.out.println("Diga o ID da queimada que você deseja atualizar o Status: \n");
            int idQueimada = scanner.nextInt();
            scanner.nextLine();

            Queimada queimadaEncontrada = null;
            for (Queimada queimada : listaQueimadas) {
                if (queimada.getId() == idQueimada) {
                    queimadaEncontrada = queimada;
                    break;
                }
            }

            if(queimadaEncontrada != null){
                System.out.println("Diga o novo status da queimada: Controlado ou Resolvido \n");
                String statusQueimada = scanner.nextLine();

                if(!statusQueimada.equalsIgnoreCase("Controlado") && !statusQueimada.equalsIgnoreCase("Resolvido")) {
                    System.out.println("Status inválido, digite se o status da queimada está Controlado ou Resolvido");
                }else{
                    queimadaEncontrada.mudarStatus(statusQueimada);
                    System.out.println("Status da Queimada ID" + queimadaEncontrada.getId() + " alterado para: " + statusQueimada);
                    System.out.println(queimadaEncontrada);

                    if(statusQueimada.equalsIgnoreCase("Controlado")){
                        listaControladas.add(queimadaEncontrada);
                        listaAtivas.remove(queimadaEncontrada);
                    }else{
                        listaResolvidas.add(queimadaEncontrada);
                        listaAtivas.remove(queimadaEncontrada);
                    }
                }
            }else{
                System.out.println("ID não encontrado");
            }
        }
    }

    public void verificarStatus(){
        System.out.println("Queimadas Ativas: \n");
        System.out.println("--------------------------\n");
        System.out.println(listaAtivas + "\n");
        System.out.println("--------------------------\n");
        System.out.println("Queimadas Controladas: \n");
        System.out.println("--------------------------\n");
        System.out.println(listaControladas + "\n");
        System.out.println("--------------------------\n");
        System.out.println("Queimadas Resolvidas: \n");
        System.out.println("--------------------------\n");
        System.out.println(listaResolvidas);
        System.out.println("--------------------------\n");
    }

    public void iniciar() {
        while(opcao != 0){
            String mensagemSistema = """
                    BEM VINDO AO SISTEMA DE QUEIMADAS, O QUE DESEJA FAZER?
                    -----------------------------------------------------
                        1- Cadastrar Queimada
                        2- Listar Queimadas
                        3- Atualizar Queimada
                        4- Status de Queimadas
                        0- Sair
                    -----------------------------------------------------
                    """;

            System.out.println(mensagemSistema);
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1 || opcao == 2 || opcao == 3 || opcao == 4 || opcao == 0){
                if(opcao == 1){
                    cadastroQueimadas();
                }else if(opcao == 2){
                    listarQueimadas();
                }else if(opcao == 3){
                    atualizarQueimada();
                }else if(opcao == 4){
                    verificarStatus();
                }else{
                    System.out.println("Saindo do sistema, Até logo!");
                    break;
                }
            }else {
                System.out.println("Opção inválida! Por favor, digite 0, 1, 2, 3 ou 4");
                opcao = -1;
            }
        }

    }
}
