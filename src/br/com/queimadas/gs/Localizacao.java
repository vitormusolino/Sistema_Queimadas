    package br.com.queimadas.gs;

    public class Localizacao {
        private String municipio;
        private String estado;
        private String pais;
        private double latitude;
        private double longitude;


        public Localizacao(String municipio, String estado, String pais) {
            this.municipio = municipio;
            this.estado = estado;
            this.pais = pais;
            this.latitude = 00.00;
            this.longitude = 00.00;
        }

        /**
         * Registra as coordenadas geográficas (latitude e longitude) para esta localização.
         * Exibe uma mensagem no console confirmando a adição das coordenadas.
         *
         * @param latitude A coordenada de latitude para a localização.
         * @param longitude A coordenada de longitude para a localização.
         */
        public void registrarInformacoes(double latitude, double longitude){
            this.latitude = latitude;
            this.longitude = longitude;

            System.out.println("Latitude:" + latitude + " e Longitude:" + longitude + " foram adicionadas a localização");
        }

        /**
         * Exibe no console o nome do país onde a queimada está localizada.
         */
        public void retornarPais(){
            System.out.println("O País da queimada é: " + pais + "." );
        }

        /**
         * Exibe no console o nome do estado e do país onde a queimada está localizada.
         */
        public void retornarEstado(){
            System.out.println("O Estado da queimada é:" + estado + ", " + pais + ".");
        }

        /**
         * Exibe no console o nome completo da localização, incluindo município, estado e país.
         */
        public void retornarMunicipio(){
            System.out.println("O Município da queimada é:"+ municipio + ", " + estado + ", " + pais + ".");
        }


        @Override
        public String toString() {
            return "Município: " + municipio + ", Estado: " + estado + ", País: " + pais + ", Latitude: " + latitude + " Longitude: " + longitude;
        }
    }
