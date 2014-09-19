package de.gravitex.bpmtest.ejb.logic.carrequest;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import de.gravitex.bpmtest.ejb.common.GenericBpmException;
import de.gravitex.bpmtest.ejb.entity.carrequest.StaffCar;

@Local
public interface PoolCarService {
	
	/**
	 * Orüft die Vorbedingungen für eine Poolcar-Reservierung.
	 * 
	 * @param requestFrom
	 * @param requestUntil
	 * @throws GenericBpmException
	 */
	public void checkRequestPrerequisites(Date requestFrom, Date requestUntil) throws GenericBpmException;

	public List<StaffCar> findSuitablePoolCar(int numSeatsRequested, Date requestCarFrom, Date requestCarUntil);
}
