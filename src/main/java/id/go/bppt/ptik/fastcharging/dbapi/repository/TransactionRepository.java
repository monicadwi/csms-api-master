package id.go.bppt.ptik.fastcharging.dbapi.repository;


import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.go.bppt.ptik.fastcharging.dbapi.model.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	@Query(value = "SELECT trx.transaction_pk, trx.connector_pk, trx.start_value, trx.stop_value, "
		    +"mcs.name AS NameCS , mcust.ID AS IdCust, mcust.name AS NameCust, mcity.city "
		    +"FROM transaction trx "
		    +"INNER JOIN connector cn ON cn.connector_pk = trx.connector_pk "
		    +"INNER JOIN mdb_cs mcs ON binary mcs.charge_box_id = binary cn.charge_box_id "
		    +"INNER JOIN mdb_customer mcust ON binary mcust.id_tag = binary trx.id_tag "
		    +"INNER JOIN mdb_city mcity ON mcs.city = mcity.id "
		    +"ORDER BY trx.transaction_pk DESC", 
		    countQuery = "select COUNT(*) FROM transaction trx INNER JOIN connector cn ON cn.connector_pk = trx.connector_pk INNER JOIN mdb_cs mcs ON binary mcs.charge_box_id = binary cn.charge_box_id INNER JOIN mdb_customer mcust ON binary mcust.id_tag = binary trx.id_tag INNER JOIN mdb_city mcity ON mcs.city = mcity.id",
		    nativeQuery = true)
	public Page<Map<String, Object>> findAllTransaction(Pageable pageable);
	
	@Query(value = "SELECT trx.transaction_pk, trx.connector_pk, trx.start_value, trx.stop_value, "
		    +"mcs.name AS NameCS , mcust.ID AS IdCust, mcust.name AS NameCust, mcity.city "
		    +"FROM transaction trx "
		    +"INNER JOIN connector cn ON cn.connector_pk = trx.connector_pk "
		    +"INNER JOIN mdb_cs mcs ON binary mcs.charge_box_id = binary cn.charge_box_id "
		    +"INNER JOIN mdb_customer mcust ON binary mcust.id_tag = binary trx.id_tag "
		    +"INNER JOIN mdb_city mcity ON mcs.city = mcity.id "
		    +"WHERE mcust.ID = ?1 "
		    +"ORDER BY trx.transaction_pk DESC", 
		    countQuery = "select COUNT(*) FROM transaction trx INNER JOIN connector cn ON cn.connector_pk = trx.connector_pk INNER JOIN mdb_cs mcs ON binary mcs.charge_box_id = binary cn.charge_box_id INNER JOIN mdb_customer mcust ON binary mcust.id_tag = binary trx.id_tag INNER JOIN mdb_city mcity ON mcs.city = mcity.id WHERE mcust.ID =?1 ",
		    nativeQuery = true)
	public Page<Map<String, Object>> findTransactionByUserId(int userId, Pageable pageable);
}
