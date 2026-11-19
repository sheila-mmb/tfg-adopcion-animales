package com.mimo.backend.repository;

import com.mimo.backend.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    // Optional es que puede traer una persona o estar vacía, asi no devuelve null
    Optional<Persona> findByEmail(String email);

    // Me dice si existe el email o no
    boolean existsByEmail(String email);

}
