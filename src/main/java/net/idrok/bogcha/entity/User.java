package net.idrok.bogcha.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, length = 30)
    private String ism;
    
    @Column(length = 30)
    private String familya;

    @Column(nullable = false, length = 30, unique = true)
    private String login;
    
    @Column(nullable = false, length = 60)  
    private String parol;
    private Role role;
    private LocalDateTime regVaqt;
    private LocalDateTime oxirgiTashrif;

    private Boolean aktiv;

    @ManyToOne
    private Fayl rasm;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getParol() {
        return parol;
    }

    public void setParol(String parol) {
        this.parol = parol;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getRegVaqt() {
        return regVaqt;
    }

    public void setRegVaqt(LocalDateTime regVaqt) {
        this.regVaqt = regVaqt;
    }

    public LocalDateTime getOxirgiTashrif() {
        return oxirgiTashrif;
    }

    public void setOxirgiTashrif(LocalDateTime oxirgiTashrif) {
        this.oxirgiTashrif = oxirgiTashrif;
    }

    public Boolean getAktiv() {
        return aktiv;
    }

    public void setAktiv(Boolean aktiv) {
        this.aktiv = aktiv;
    }

    public Fayl getRasm() {
        return rasm;
    }

    public void setRasm(Fayl rasm) {
        this.rasm = rasm;
    }

}
