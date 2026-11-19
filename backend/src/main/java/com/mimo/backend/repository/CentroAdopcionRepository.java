package com.mimo.backend.repository;

import com.mimo.backend.model.CentroAdopcion;
import org.springframework.data.jpa.repository.JpaRepository;

// Con las operaciones que trae JpaRepository (findAll, findById, save...) me basta por ahora
public interface CentroAdopcionRepository extends JpaRepository<CentroAdopcion, Long> {

}
