package id.go.bppt.ptik.fastcharging.dbapi.service;

import java.util.List;
import java.util.Map;

public interface ConnectorStatusService {
	List<Map<String,Object>> findAllConnectorStatus(int pageNo, int pageSize);
}
