package es.fmm.ejerc007.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.fmm.ejerc007.Peliculas;
import es.fmm.ejerc007.Repos.PeliculasRepository;

public class PeliculaService {

    private final PeliculasRepository peliculaRepository;

    @Autowired
    public PeliculaService(PeliculasRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }
    
    public Peliculas getPeliculaId(Long id)
    {
        return peliculaRepository.findById(id).orElse(null);
    }

    public List<Peliculas> getAllPeliculas()
    {
        return peliculaRepository.findAll();
    }

    public Peliculas createPelicula(Peliculas pelicula)
    {
        return peliculaRepository.save(pelicula);
    }

    public Peliculas updatePelicula(Peliculas pelicula)
    {
        return peliculaRepository.save(pelicula);
    }

    public void deletePelicula(Long id)
    {
        peliculaRepository.deleteById(id);
    }


}
