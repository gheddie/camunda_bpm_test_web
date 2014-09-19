package de.gravitex.bpmtest.ejb.entity.carrequest;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import de.gravitex.bpmtest.ejb.entity.AbstractBpmEntity;

@Entity
@Table(name = "StaffCarBean")
@TableGenerator(name = "UniqueIdGenerator", table = "ID_GEN", pkColumnName = "ID_NAME", valueColumnName = "ID_VAL", pkColumnValue = "globalkey", allocationSize = 10)
public class StaffCar extends AbstractBpmEntity {

	private static final long serialVersionUID = -3002310481736900862L;

	private String licenceTag;
	
	private int numberOfSeats;
	
	private boolean fixForEmployee;

	public String getLicenceTag() {
		return licenceTag;
	}

	public void setLicenceTag(String licenceTag) {
		this.licenceTag = licenceTag;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public boolean isFixForEmployee() {
		return fixForEmployee;
	}

	public void setFixForEmployee(boolean fixForEmployee) {
		this.fixForEmployee = fixForEmployee;
	}	
}
