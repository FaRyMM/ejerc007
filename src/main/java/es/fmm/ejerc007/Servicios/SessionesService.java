package es.fmm.ejerc007.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.fmm.ejerc007.Sesion;
import es.fmm.ejerc007.Repos.SessionesRepository;

public class SessionesService {
      private final SessionesRepository sessionRepository;

    @Autowired
    public SessionesService(SessionesRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
    
    public Sesion getSessionId(Long id)
    {
        return sessionRepository.findById(id).orElse(null);
    }
    public List<Sesion> getAllPeliculas()
    {
        return sessionRepository.findAll();
    }

    public Sesion createPelicula(Sesion session)
    {
        return sessionRepository.save(session);
    }

    public Sesion updatePelicula(Sesion session)
    {
        return sessionRepository.save(session);
    }

    public void deletePelicula(Long id)
    {
        sessionRepository.deleteById(id);
    }

}
