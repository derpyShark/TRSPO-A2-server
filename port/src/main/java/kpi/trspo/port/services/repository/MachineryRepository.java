package kpi.trspo.port.services.repository;

import kpi.trspo.port.services.model.Machinery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MachineryRepository extends JpaRepository<Machinery, UUID> {
}
