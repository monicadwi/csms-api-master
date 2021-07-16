package id.go.bppt.ptik.fastcharging.dbapi.repository;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.go.bppt.ptik.fastcharging.dbapi.model.ConnectorStatus;

public interface ConnectorStatusRepository extends JpaRepository<ConnectorStatus, Long> {

	@Query(value = "SELECT * FROM connector_status_latest", countQuery = "SELECT COUNT(*) FROM connector_status_latest", nativeQuery = true)
	public Page<Map<String, Object>> findAllConnectorStatus(Pageable pageable);
}
