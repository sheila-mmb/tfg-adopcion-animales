package com.mimo.backend.repository;

import com.mimo.backend.model.Solicitud;
import com.mimo.backend.model.enums.TipoTramite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    // Solicitudes cuyo solicitante tenga este idPersona
    List<Solicitud> findBySolicitanteIdPersona(Long idPersona);

    // Comprueba si ya existe esa misma combinación de persona + animal + tipo de trámite, que la base de datos prohíbe repetir
    boolean existsBySolicitanteIdPersonaAndAnimalIdAnimalAndTipoTramite(Long idPersona, Long idAnimal, TipoTramite tipoTramite);

    Optional<Solicitud> findByIdReferenciaSalesforce(String idReferenciaSalesforce);
}
