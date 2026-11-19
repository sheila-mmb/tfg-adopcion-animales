package com.mimo.backend.repository;

import com.mimo.backend.model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {

    // Me da una lista de los favoritos que tiene esa persona
    List<Favorito> findByPersonaIdPersona(Long idPersona);

    // Sirve para quitar un favorito: lo busco por persona y animal, y luego lo borro
    Optional<Favorito> findByPersonaIdPersonaAndAnimalIdAnimal(Long idPersona, Long idAnimal);

}
