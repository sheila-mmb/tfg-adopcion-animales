package com.mimo.backend.repository;

import com.mimo.backend.model.Cuestionario;
import org.springframework.data.jpa.repository.JpaRepository;

// No necesita búsquedas propias: al cuestionario se llega siempre desde su Solicitante
public interface CuestionarioRepository extends JpaRepository<Cuestionario, Long> {

}
