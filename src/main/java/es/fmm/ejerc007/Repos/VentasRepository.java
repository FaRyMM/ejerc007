package es.fmm.ejerc007.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import es.fmm.ejerc007.Ventas;

public interface VentasRepository extends JpaRepository<Ventas, Long> {
    
}
