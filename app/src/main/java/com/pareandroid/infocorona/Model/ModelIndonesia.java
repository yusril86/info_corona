package com.pareandroid.infocorona.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelIndonesia {
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public class Attributes {

        @SerializedName("FID")
        @Expose
        private Integer fID;
        @SerializedName("Kode_Provi")
        @Expose
        private Integer kodeProvi;
        @SerializedName("Provinsi")
        @Expose
        private String provinsi;
        @SerializedName("Kasus_Posi")
        @Expose
        private Integer kasusPosi;
        @SerializedName("Kasus_Semb")
        @Expose
        private Integer kasusSemb;
        @SerializedName("Kasus_Meni")
        @Expose
        private Integer kasusMeni;

        public Integer getFID() {
            return fID;
        }

        public void setFID(Integer fID) {
            this.fID = fID;
        }

        public Integer getKodeProvi() {
            return kodeProvi;
        }

        public void setKodeProvi(Integer kodeProvi) {
            this.kodeProvi = kodeProvi;
        }

        public String getProvinsi() {
            return provinsi;
        }

        public void setProvinsi(String provinsi) {
            this.provinsi = provinsi;
        }

        public Integer getKasusPosi() {
            return kasusPosi;
        }

        public void setKasusPosi(Integer kasusPosi) {
            this.kasusPosi = kasusPosi;
        }

        public Integer getKasusSemb() {
            return kasusSemb;
        }

        public void setKasusSemb(Integer kasusSemb) {
            this.kasusSemb = kasusSemb;
        }

        public Integer getKasusMeni() {
            return kasusMeni;
        }

        public void setKasusMeni(Integer kasusMeni) {
            this.kasusMeni = kasusMeni;
        }

    }

}
