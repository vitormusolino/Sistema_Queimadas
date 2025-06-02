    package br.com.queimadas.gs;

    public class Localizacao {
        private String municipio;
        private String estado;
        private String pais;


        public Localizacao(String municipio, String estado, String pais) {
            this.municipio = municipio;
            this.estado = estado;
            this.pais = pais;
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
            return "Município: " + municipio + ", Estado: " + estado + ", País:" + pais;
        }
    }
