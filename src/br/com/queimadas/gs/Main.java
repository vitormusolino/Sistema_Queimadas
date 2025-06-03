// Main.java
package br.com.queimadas.gs;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Localizacao loc1 = new Localizacao("São Paulo", "SP", "Brasil");
        Localizacao loc2 = new Localizacao("Sorocaba", "SP", "Brasil");
        Queimada novaQueimada = new Queimada(1, loc1, "16:40");
        Queimada novaQueimada2 = new Queimada(2,loc2,"07:30");

        novaQueimada.registrarDetalhes(5.5, "Causas Naturais");
        novaQueimada2.registrarDetalhes(3.0);


        List<Queimada> listaQueimadas = new ArrayList<>();
        listaQueimadas.add(novaQueimada);
        listaQueimadas.add(novaQueimada2);

        System.out.println(listaQueimadas);

        SistemaQueimadas sistema = new SistemaQueimadas();
        sistema.iniciar();
    }
}