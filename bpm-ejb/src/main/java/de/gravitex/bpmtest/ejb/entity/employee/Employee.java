package de.gravitex.bpmtest.ejb.entity.employee;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import de.gravitex.bpmtest.ejb.entity.AbstractBpmEntity;

@Entity
@Table(name = "EmployeeBean")
@TableGenerator(name = "UniqueIdGenerator", table = "ID_GEN", pkColumnName = "ID_NAME", valueColumnName = "ID_VAL", pkColumnValue = "globalkey", allocationSize = 10)
public class Employee extends AbstractBpmEntity {

	private static final long serialVersionUID = -5009867035940499199L;
	
	private String employeeCode;
	
	public String getEmployeeCode() {
		return employeeCode;
	}
	
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
}
