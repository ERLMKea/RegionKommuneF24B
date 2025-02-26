package org.example.regionkommunef24b.model;


import jakarta.persistence.*;

@Entity
public class Kommune {

    @Id
    @Column(length = 4)
    private String kode;
    private String navn;
    private String href;
    private String hrefPhoto;

    @ManyToOne
    @JoinColumn(name = "region", referencedColumnName = "kode", nullable = false)
    private Region region;

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getHrefPhoto() {
        return hrefPhoto;
    }

    public void setHrefPhoto(String hrefPhoto) {
        this.hrefPhoto = hrefPhoto;
    }

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
