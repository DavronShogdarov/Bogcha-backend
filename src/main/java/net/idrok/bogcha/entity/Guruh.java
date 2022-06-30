package net.idrok.bogcha.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Guruh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, unique = true, nullable = false)
    private String nom;

    
    @ManyToOne
    private Xodim xodim;
    private LocalDate ochilgan_sana;
    private LocalDate yopilgan_sana;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Xodim getXodim() {
        return xodim;
    }

    public void setXodim(Xodim xodim) {
        this.xodim = xodim;
    }

    public LocalDate getOchilgan_sana() {
        return ochilgan_sana;
    }

    public void setOchilgan_sana(LocalDate ochilgan_sana) {
        this.ochilgan_sana = ochilgan_sana;
    }

    public LocalDate getYopilgan_sana() {
        return yopilgan_sana;
    }

    public void setYopilgan_sana(LocalDate yopilgan_sana) {
        this.yopilgan_sana = yopilgan_sana;
    }


}
