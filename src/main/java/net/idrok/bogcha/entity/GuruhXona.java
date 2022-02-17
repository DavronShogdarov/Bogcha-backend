package net.idrok.bogcha.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GuruhXona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Guruh guruh;
    @ManyToOne
    private Xona xona;
    private String kirish_vaqt;
    private String chiqish_vaqt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Guruh getGuruh() {
        return guruh;
    }

    public void setGuruh(Guruh guruh) {
        this.guruh = guruh;
    }

    public Xona getXona() {
        return xona;
    }

    public void setXona(Xona xona) {
        this.xona = xona;
    }

    public String getKirish_vaqt() {
        return kirish_vaqt;
    }

    public void setKirish_vaqt(String kirish_vaqt) {
        this.kirish_vaqt = kirish_vaqt;
    }

    public String getChiqish_vaqt() {
        return chiqish_vaqt;
    }

    public void setChiqish_vaqt(String chiqish_vaqt) {
        this.chiqish_vaqt = chiqish_vaqt;
    }

}
