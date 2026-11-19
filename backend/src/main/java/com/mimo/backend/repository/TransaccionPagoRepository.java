package com.mimo.backend.repository;

import com.mimo.backend.model.TransaccionPago;
import org.springframework.data.jpa.repository.JpaRepository;

// Con las operaciones que trae JpaRepository (save, findById...) me basta por ahora
public interface TransaccionPagoRepository extends JpaRepository<TransaccionPago, Long> {

}
