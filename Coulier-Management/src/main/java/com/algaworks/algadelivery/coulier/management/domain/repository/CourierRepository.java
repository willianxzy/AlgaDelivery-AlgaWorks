package com.algaworks.algadelivery.coulier.management.domain.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.algaworks.algadelivery.coulier.management.domain.model.Courier;

public interface CourierRepository extends JpaRepository<Courier, UUID> {

}
