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

        public void registrarInformacoes(double latitude, double longitude){
            this.latitude = latitude;
            this.longitude = longitude;

            System.out.println("Latitude:" + latitude + " e Longitude:" + longitude + " foram adicionadas a localização");
        }

        public String getMunicipio() {
            return municipio;
        }

        public void setMunicipio(String municipio) {
            this.municipio = municipio;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }

        @Override
        public String toString() {
            return "Município: " + municipio + ", Estado: " + estado + ", País: " + pais + ", Latitude: " + latitude + " Longitude: " + longitude;
        }
    }
