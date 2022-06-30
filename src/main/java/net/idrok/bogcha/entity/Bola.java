package net.idrok.bogcha.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, unique = true, nullable = false)
    private String ism;
    private String familya;
    private String sharif;
    private String jins;
    private LocalDate tug_kun;
    private String ota_ism;
    private String ona_ism;
    private String tel_nomer;
    @ManyToOne
    private Guruh guruh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsm() {
        return ism;
    }

    public void setIsm(String ism) {
        this.ism = ism;
    }

    public String getFamilya() {
        return familya;
    }

    public void setFamilya(String familya) {
        this.familya = familya;
    }

    public String getSharif() {
        return sharif;
    }

    public void setSharif(String sharif) {
        this.sharif = sharif;
    }

    public String getJins() {
        return jins;
    }

    public void setJins(String jins) {
        this.jins = jins;
    }



    public LocalDate getTug_kun() {
        return tug_kun;
    }

    public void setTug_kun(LocalDate tug_kun) {
        this.tug_kun = tug_kun;
    }

    public String getOta_ism() {
        return ota_ism;
    }

    public void setOta_ism(String ota_ism) {
        this.ota_ism = ota_ism;
    }

    public String getOna_ism() {
        return ona_ism;
    }

    public void setOna_ism(String ona_ism) {
        this.ona_ism = ona_ism;
    }

    public String getTel_nomer() {
        return tel_nomer;
    }

    public void setTel_nomer(String tel_nomer) {
        this.tel_nomer = tel_nomer;
    }

    public Guruh getGuruh() {
        return guruh;
    }

    public void setGuruh(Guruh guruh) {
        this.guruh = guruh;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String info;

}
