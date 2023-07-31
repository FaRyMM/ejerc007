package es.fmm.ejerc007;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Peliculas{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private LocalDate inicio;
    private LocalDate fin;
    @ManyToOne
    private Sala sala;
    @ManyToMany
    private Sesion sessiones;

    public Peliculas(String titulo, LocalDate inicio, LocalDate fin, Sala sala) {
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
        this.sala = sala;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public LocalDate getInicio() {
        return inicio;
    }
    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }
    public LocalDate getFin() {
        return fin;
    }
    public void setFin(LocalDate fin) {
        this.fin = fin;
    }
    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    public Sesion getSessiones() {
        return sessiones;
    }
    public void setSessiones(Sesion sessiones) {
        this.sessiones = sessiones;
    }
    
}