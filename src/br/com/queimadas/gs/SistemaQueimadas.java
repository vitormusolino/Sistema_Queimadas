package br.com.queimadas.gs;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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

    /**
     * Realiza o cadastro de uma nova queimada no sistema.
     * Este método guia o usuário através do processo de registrar a localização (município, estado, país)
     * e, opcionalmente, adicionar detalhes como latitude e longitude. Em seguida, gera um ID automático para a queimada,
     * registra o horário e permite adicionar detalhes opcionais como a área afetada e a causa.
     * A queimada é adicionada à lista principal de queimadas e à lista de queimadas ativas.
     */
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

        System.out.print("Quer adicionar mais detalhes na localização? \n" +
                "1- Sim\n" +
                "2- Não\n");
        opcao = scanner.nextInt();
        scanner.nextLine();

        if(opcao == 1){
            System.out.print("Latitude: (Caso vá específicar, coloque vírgula)\n");
            Double latitude = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Longitude: (Caso vá específicar, coloque vírgula)\n");
            Double longitude = scanner.nextDouble();
            scanner.nextLine();

            localizacao.registrarInformacoes(latitude,longitude);

            System.out.println("********************************************");
            System.out.println("Informações da localização: " + localizacao);
            System.out.println("********************************************");
        }else{
            System.out.println("Tudo bem! Continuando o registro...");
        }

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

    /**
     * Lista todas as queimadas registradas no sistema.
     * Se a lista de queimadas estiver vazia, exibe uma mensagem informando.
     * Caso contrário, imprime os detalhes de cada queimada cadastrada no console.
     */
    public void listarQueimadas(){
        System.out.println("Lista de queimadas: \n");
        System.out.println(listaQueimadas);
    }

    /**
     * Permite ao usuário atualizar o status de uma queimada existente.
     * O usuário é solicitado a informar o ID da queimada que deseja modificar.
     * Se a queimada for encontrada, o usuário pode definir um novo status ("Controlado" ou "Resolvido").
     * A queimada é então movida da lista de queimadas ativas para a lista correspondente ao novo status (controladas ou resolvidas).
     * Lida com entradas inválidas de ID e status.
     */
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

    /**
     * Permite ao usuário verificar detalhes da localização de uma queimada específica.
     * O usuário deve fornecer o ID da queimada. Uma vez encontrada, o sistema oferece opções
     * para exibir o país, estado e país, ou município, estado e país da queimada.
     * Lida com IDs não encontrados e opções de verificação inválidas.
     */
    public void verificarLocalizacao(){
        System.out.println("Qual o ID da queimada que deseja verificar?\n");
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
            System.out.println("Você quer verificar a localização com:\n" +
                    "1- Páis\n" +
                    "2- Estado e País\n" +
                    "3- Município, Estado e País");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if(opcao == 1){
                queimadaEncontrada.getLocalizacao().retornarPais();
            }else if(opcao == 2){
                queimadaEncontrada.getLocalizacao().retornarEstado();
            }else if(opcao == 3){
                queimadaEncontrada.getLocalizacao().retornarMunicipio();
            }else{
                System.out.println("Número inválido!");
            }
        }else{
            System.out.println("ID não encontrado");
        }
    }

    /**
     * Permite ao usuário verificar a área afetada de uma queimada específica.
     * O usuário é solicitado a informar o ID da queimada. Se a queimada for encontrada,
     * o método {@code verificarArea()} da própria queimada é chamado para exibir a informação.
     * Lida com IDs não encontrados.
     */
    public void verificarArea(){
        System.out.println("Qual o ID da queimada que deseja verificar?\n");
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
            queimadaEncontrada.verificarArea();
        }else{
            System.out.println("ID não encontrado");
        }
    }

    /**
     * Exibe o status atual das queimadas, categorizando-as em Ativas, Controladas e Resolvidas.
     * Imprime as queimadas presentes em cada uma dessas listas separadamente no console.
     */
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

    /**
     * Inicia o sistema de gerenciamento de queimadas, apresentando um menu principal ao usuário.
     * O usuário pode escolher entre cadastrar novas queimadas, listar todas as queimadas,
     * atualizar o status de uma queimada, verificar status por categoria, verificar localização
     * de uma queimada específica, verificar a área afetada, ou sair do sistema.
     * O sistema continua em execução até que o usuário escolha a opção de sair.
     * Lida com entradas de menu inválidas.
     */
    public void iniciar() {
        while(opcao != 0){
            String mensagemSistema = """
                    BEM VINDO AO SISTEMA DE QUEIMADAS, O QUE DESEJA FAZER?
                    -----------------------------------------------------
                        1- Cadastrar Queimada
                        2- Listar Queimadas
                        3- Atualizar Queimada
                        4- Status de Queimada
                        5- Localização Queimada
                        6- Verificar área afetada
                        0- Sair
                    -----------------------------------------------------
                    """;

            System.out.println(mensagemSistema);
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1 || opcao == 2 || opcao == 3 || opcao == 4 || opcao == 5 || opcao == 6 || opcao == 0){
                if(opcao == 1){
                    cadastroQueimadas();
                }else if(opcao == 2){
                    listarQueimadas();
                }else if(opcao == 3){
                    atualizarQueimada();
                }else if(opcao == 4){
                    verificarStatus();
                }else if(opcao == 5){
                    verificarLocalizacao();
                }else if(opcao == 6) {
                    verificarArea();
                }else{
                    System.out.println("Saindo do sistema, Até logo!");
                    break;
                }
            }else {
                System.out.println("Opção inválida! Por favor, digite 0, 1, 2, 3, 4, 5 ou 6");
                opcao = -1;
            }
        }

    }
}
