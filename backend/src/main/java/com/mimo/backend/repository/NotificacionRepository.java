package com.mimo.backend.repository;

import com.mimo.backend.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    // Ordeno de la más nueva a la más antigua
    List<Notificacion> findByPersonaIdPersonaOrderByFechaCreacionDesc(Long idPersona);

    // Cuento cuántas notificaciones sin leer tiene esa persona
    long countByPersonaIdPersonaAndLeidoFalse(Long idPersona);
}
