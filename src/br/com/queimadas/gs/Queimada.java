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

    public void registrarDetalhes(double areaEstimadaHectares){
        this.areaEstimadaHectares = areaEstimadaHectares;
        System.out.println("Queimada ID " + id + ": Área estimada atualizada para: " + areaEstimadaHectares);
    }

    public void registrarDetalhes(double areaEstimadaHectares, String causa){
        this.areaEstimadaHectares = areaEstimadaHectares;
        this.causa = causa;
        System.out.println("Queimada ID " + id + ": Área estimada atualizada para: " + areaEstimadaHectares + "; Causa da queimada: " + causa);
    }

    public void mudarStatus(String status){
        this.status = status;
        System.out.println("Queimada ID " + id + ": Mudando o status para = " + status);
    }

    public double getAreaEstimadaHectares() {
        return areaEstimadaHectares;
    }

    public void setAreaEstimadaHectares(double areaEstimadaHectares) {
        this.areaEstimadaHectares = areaEstimadaHectares;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public String getStatus() {
        return status;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void exibirInformacoesQueimada() {
    }

    @Override
    public String toString() {
        return "ID Queimada: " + id + "; Localização: " + localizacao + "; Causa: " + causa + "; Status: " + status + "; Horário: " + hora + "; Área: " + areaEstimadaHectares + "ha\n";
    }
}
