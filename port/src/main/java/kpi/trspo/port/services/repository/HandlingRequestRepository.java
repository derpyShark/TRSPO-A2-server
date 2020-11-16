package kpi.trspo.port.services.repository;

import kpi.trspo.port.services.model.HandlingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HandlingRequestRepository extends JpaRepository<HandlingRequest, UUID> {
}
