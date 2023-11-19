// ModelPenyimpanan.java
package com.raven.model;

public class ModelPenyimpanan {
    private int kodeAdmin;
    private int kodeBarang;
    private String namaPengirim;
    private String namaPenerima;

    // Constructor dengan parameter namaPengirim dan namaPenerima
    public ModelPenyimpanan(String namaPengirim, String namaPenerima) {
        this.kodeAdmin = kodeAdmin;
        this.kodeBarang = kodeBarang;
        this.namaPengirim = namaPengirim;
        this.namaPenerima = namaPenerima;
    }

    public int getKodeAdmin() {
        return kodeAdmin;
    }

    public void setKodeAdmin(int kodeAdmin) {
        this.kodeAdmin = kodeAdmin;
    }

    public int getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(int kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaPengirim() {
        return namaPengirim;
    }

    public void setNamaPengirim(String namaPengirim) {
        this.namaPengirim = namaPengirim;
    }

    public String getNamaPenerima() {
        return namaPenerima;
    }

    public void setNamaPenerima(String namaPenerima) {
        this.namaPenerima = namaPenerima;
    }
}
