    package br.com.queimadas.gs;

    public class Localizacao {
        private double latitude;
        private double longitude;
        private String municipio;
        private String estado;
        private String pais;


        public Localizacao(double latitude, double longitude, String municipio, String estado, String pais) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.municipio = municipio;
            this.estado = estado;
            this.pais = pais;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
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
            return "\"Lat: \" + latitude + \", Long: \" + longitude +\n" +
                    "               \", Município: \" + municipio + \", Estado: \" + estado + \", País: \" + pais;";
        }
    }
