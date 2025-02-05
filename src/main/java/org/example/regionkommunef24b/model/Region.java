package org.example.regionkommunef24b.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Region {

    @Id
    private String kode;
    private String navn;
    private String href;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
