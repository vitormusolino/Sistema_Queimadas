// Main.java
package br.com.queimadas.gs;

public class Main {
    public static void main(String[] args) {
        Localizacao loc1 = new Localizacao("São Paulo", "SP", "Brasil");
        Queimada novaQueimada = new Queimada(1, loc1, "16:40");

        System.out.println(novaQueimada);
    }
}