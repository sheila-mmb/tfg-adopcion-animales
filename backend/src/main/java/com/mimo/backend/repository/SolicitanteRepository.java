package com.mimo.backend.repository;

import com.mimo.backend.model.Solicitante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// El Long es el id de la Persona, porque Solicitante no tiene id propio (lo copia de ella con @MapsId)
public interface SolicitanteRepository extends JpaRepository<Solicitante, Long> {

    Optional<Solicitante> findByIdReferenciaSalesforce(String idReferenciaSalesforce);
}
