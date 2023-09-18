package com.example.jpaonetomany.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Region {

    @Id
    @Column(length = 4)
    private String kode;
    private String navn;
    private String href;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "region")
    @JsonBackReference
    private Set<Kommune> kommuner = new HashSet<>();

    @JsonIgnore
    public List<String> getKommunenavne() {
        List<String> lst = new ArrayList<>();
        kommuner.forEach((kom) -> lst.add(kom.getNavn()));
        return lst;
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
