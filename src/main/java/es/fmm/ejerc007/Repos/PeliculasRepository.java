package es.fmm.ejerc007.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import es.fmm.ejerc007.Peliculas;

public interface PeliculasRepository extends JpaRepository<Peliculas, Long>{
    
}
