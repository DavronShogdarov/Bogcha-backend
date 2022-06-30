package net.idrok.bogcha.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tulov")
public class Tulov {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String miqdor;
    private LocalDate sana;
    private TulovTur tulovTur;

    @ManyToOne
    private Bola bola;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMiqdor() {
        return miqdor;
    }

    public void setMiqdor(String miqdor) {
        this.miqdor = miqdor;
    }

    public LocalDate getSana() {
        return sana;
    }

    public void setSana(LocalDate sana) {
        this.sana = sana;
    }
    
    public TulovTur getTulovTur() {
        return tulovTur;
    }

    public void setTulovTur(TulovTur tulovTur) {
        this.tulovTur = tulovTur;
    }

    public Bola getBola() {
        return bola;
    }

    public void setBola(Bola bola) {
        this.bola = bola;
    }

}
