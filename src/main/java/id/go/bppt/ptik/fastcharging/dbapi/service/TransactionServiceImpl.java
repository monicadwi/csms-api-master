package id.go.bppt.ptik.fastcharging.dbapi.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import id.go.bppt.ptik.fastcharging.dbapi.repository.TransactionRepository;
import id.go.bppt.ptik.fastcharging.dbapi.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
    private TransactionRepository transactionRepository;
	
	@Override
	public List<Map<String, Object>> findAllTransaction(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		
		Page<Map<String, Object>> pagedResult = transactionRepository.findAllTransaction(paging);
		
		return pagedResult.toList();
	}

	@Override
	public List<Map<String, Object>> findTransactionByUserId(int pageNo, int pageSize, int userId) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		
		Page<Map<String, Object>> pagedResult = transactionRepository.findTransactionByUserId(userId, paging);
		
		return pagedResult.toList();
	}

}
