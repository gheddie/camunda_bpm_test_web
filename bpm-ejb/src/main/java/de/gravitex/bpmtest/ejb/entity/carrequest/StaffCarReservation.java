package de.gravitex.bpmtest.ejb.entity.carrequest;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import de.gravitex.bpmtest.ejb.entity.AbstractBpmEntity;
import de.gravitex.bpmtest.ejb.entity.employee.Employee;

@Entity
@Table(name = "StaffCarBean")
@TableGenerator(name = "UniqueIdGenerator", table = "ID_GEN", pkColumnName = "ID_NAME", valueColumnName = "ID_VAL", pkColumnValue = "globalkey", allocationSize = 10)
public class StaffCarReservation extends AbstractBpmEntity {

	private static final long serialVersionUID = -8846238046148236072L;

	private Employee requester;
	
	private StaffCar staffCar;
	
	private Date fromDate;
	
	private Date untilDate;
	
	private ReservationState reservationState;

	public Employee getRequester() {
		return requester;
	}

	public void setRequester(Employee requester) {
		this.requester = requester;
	}

	public StaffCar getStaffCar() {
		return staffCar;
	}

	public void setStaffCar(StaffCar staffCar) {
		this.staffCar = staffCar;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getUntilDate() {
		return untilDate;
	}

	public void setUntilDate(Date untilDate) {
		this.untilDate = untilDate;
	}

	public ReservationState getReservationState() {
		return reservationState;
	}

	public void setReservationState(ReservationState reservationState) {
		this.reservationState = reservationState;
	}
}
