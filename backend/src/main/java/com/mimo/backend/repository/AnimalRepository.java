package com.mimo.backend.repository;

import com.mimo.backend.model.Animal;
import com.mimo.backend.model.enums.EstadoAnimal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Al hacerlo de Animal puedo buscar cualquier tipo de animal, ya sea perro, gato o exótico
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    // Me da una lista de los animales en función del estado que quiera
    List<Animal> findByEstado(EstadoAnimal estado);

    // Me da una lista de los animales urgentes
    List<Animal> findByEstadoAndEsUrgenteTrue(EstadoAnimal estado);

    Optional<Animal> findByIdReferenciaSalesforce(String idReferenciaSalesforce);

}
