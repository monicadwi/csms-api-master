package id.go.bppt.ptik.fastcharging.dbapi.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Immutable
@Table(name="connector_status_latest")
@Subselect("select uuid() as id, csl.* connector_status_latest csl")
public class ConnectorStatus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2431037367660239010L;
	
	@Id
    private String id;
	private int charge_box_pk;
	private String charge_box_id;
	private int connector_pk;
	private LocalDateTime max_status_timestamp;
	private int connector_id;
	private String plug_type;
	private String NAME;
	private String LATITUDE;
	private String LONGITUDE;
	private LocalDateTime LAST_HEARTBEAT_TIMESTAMP_GMT7;
}
