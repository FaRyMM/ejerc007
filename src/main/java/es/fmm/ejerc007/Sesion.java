package es.fmm.ejerc007;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sesion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime Inicio;
    private LocalTime Fin;
    @ManyToOne
    private Peliculas pelicula;

    public Sesion(LocalTime inicio, LocalTime fin, Peliculas pelicula) {
        this.Inicio = inicio;
        this.Fin = fin;
        this.pelicula = pelicula;
    }

    public Long getId() {
        return id;
    }
    public Peliculas getPelicula() {
        return pelicula;
    }
    public void setPelicula(Peliculas pelicula) {
        this.pelicula = pelicula;
    }
    public LocalTime getInicio() {
        return Inicio;
    }
    public void setInicio(LocalTime inicio) {
        Inicio = inicio;
    }
    public LocalTime getFin() {
        return Fin;
    }
    public void setFin(LocalTime fin) {
        Fin = fin;
    }


}