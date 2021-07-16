package id.go.bppt.ptik.fastcharging.dbapi.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import id.go.bppt.ptik.fastcharging.dbapi.repository.ConnectorStatusRepository;

@Service
public class ConnectorStatusServiceImpl implements ConnectorStatusService {

	@Autowired
	private ConnectorStatusRepository connectorStatusRepository;

	@Override
	public List<Map<String, Object>> findAllConnectorStatus(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<Map<String, Object>> pagedResult = connectorStatusRepository.findAllConnectorStatus(paging);

		return pagedResult.toList();
	}

}
