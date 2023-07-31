package es.fmm.ejerc007.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import es.fmm.ejerc007.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    
}
