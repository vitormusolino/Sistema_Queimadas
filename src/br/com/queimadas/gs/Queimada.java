package br.com.queimadas.gs;


import java.time.LocalDateTime;

public class Queimada {
    private int id;
    private LocalDateTime dataHoraQueimada;
    private String causa;
    private String status;
    private Localizacao localizacao;
    private double areaEstimadaHectares;

    public Queimada(int id, Localizacao localizacao, LocalDateTime dataHoraQueimada) {
        this.id = id;
        this.localizacao = localizacao;
        this.dataHoraQueimada = dataHoraQueimada;
        this.status = "Ativa";
        this.causa = "Não informada";
        this.areaEstimadaHectares = 0.0;
    }

    public void registrarDetalhes(double areaEstimadaHectares){
        this.areaEstimadaHectares = areaEstimadaHectares;
        System.out.println("Queimada ID " + id + ": Área estimada atualizada para: " + areaEstimadaHectares);
    }

    public void registrarDetalhes(String novoStatus) {
        this.status = novoStatus;
        System.out.println("Queimada ID " + this.id + ": Status atualizado para " + novoStatus + ".");
    }

    public void registrarDetalhes(String novaCausa, double areaEstimadaHectares) {
        this.causa = novaCausa;
        this.areaEstimadaHectares = areaEstimadaHectares;
        System.out.println("Queimada ID " + this.id + ": Causa '" + novaCausa + "' e área '" + areaEstimadaHectares + " ha' registradas.");
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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public LocalDateTime getDataHoraQueimada() {
        return dataHoraQueimada;
    }

    public void setDataHoraQueimada(LocalDateTime dataHoraQueimada) {
        this.dataHoraQueimada = dataHoraQueimada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
