package es.fmm.ejerc007;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Sala{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int butacas;

    public Sala(String nombre, int butacas) {
        this.nombre = nombre;
        this.butacas = butacas;
    }

    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getButacas() {
        return butacas;
    }
    public void setButacas(int butacas) {
        this.butacas = butacas;
    }
}