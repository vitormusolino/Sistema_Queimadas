package br.com.queimadas.gs;


import java.time.LocalDateTime;
import java.util.Scanner;

public class Queimada {
    private int id;
    private String hora;
    private String causa;
    private String status;
    private Localizacao localizacao;
    private double areaEstimadaHectares;



    public Queimada(int id, Localizacao localizacao, String hora) {
        this.id = id;
        this.localizacao = localizacao;
        this.hora = hora;
        this.status = "Ativa";
        this.causa = "Não informada";
        this.areaEstimadaHectares = 0.0;
    }

    /**
     * Registra a área estimada em hectares afetada pela queimada.
     * Exibe uma mensagem de confirmação no console com o ID da queimada e a nova área.
     *
     * @param areaEstimadaHectares A área estimada da queimada em hectares.
     */
    public void registrarDetalhes(double areaEstimadaHectares){
        this.areaEstimadaHectares = areaEstimadaHectares;
        System.out.println("Queimada ID " + id + ": Área estimada atualizada para: " + areaEstimadaHectares);
    }

    /**
     * Registra a área estimada em hectares e a causa da queimada.
     * Exibe uma mensagem de confirmação no console com o ID da queimada, a nova área e a causa.
     * Este é um método sobrecarregado de {@link #registrarDetalhes(double)}.
     *
     * @param areaEstimadaHectares A área estimada da queimada em hectares.
     * @param causa A causa da queimada.
     */
    public void registrarDetalhes(double areaEstimadaHectares, String causa){
        this.areaEstimadaHectares = areaEstimadaHectares;
        this.causa = causa;
        System.out.println("Queimada ID " + id + ": Área estimada atualizada para: " + areaEstimadaHectares + "; Causa da queimada: " + causa);
    }

    /**
     * Altera o status atual da queimada.
     * Exibe uma mensagem no console informando o ID da queimada e o novo status.
     *
     * @param status O novo status da queimada (ex: "Ativa", "Controlada", "Resolvida").
     */
    public void mudarStatus(String status){
        this.status = status;
        System.out.println("Queimada ID " + id + ": Mudando o status para = " + status);
    }

    /**
     * Exibe no console a área estimada em hectares afetada pela queimada.
     */
    public void verificarArea(){
        System.out.println("A área afetada foi de: " + areaEstimadaHectares + "ha.");
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID Queimada: " + id + "; Localização: " + localizacao + "; Causa: " + causa + "; Status: " + status + "; Horário: " + hora + "; Área: " + areaEstimadaHectares + "ha\n";
    }
}
