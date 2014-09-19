package de.gravitex.bpmtest.ejb.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractBpmEntity implements Serializable {
	
	private static final long serialVersionUID = -7891252976537285618L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "UniqueIdGenerator")
	protected Long id;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
