package de.gravitex.bpmtest.ejb.logic.carrequest;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import de.gravitex.bpmtest.ejb.common.GenericBpmException;
import de.gravitex.bpmtest.ejb.entity.carrequest.StaffCar;

@Stateless(name = "PoolCarService")
@Local(PoolCarService.class)
public class PoolCarServiceBean implements PoolCarService {
	
	private static Logger logger = Logger.getLogger(PoolCarServiceBean.class);

	public List<StaffCar> findSuitablePoolCar(int numSeatsRequested, Date requestCarFrom, Date requestCarUntil) {
		System.out.println(" @------------------------------------------------> [numSeatsRequested:"+numSeatsRequested+"|requestCarFrom:"+requestCarFrom+"|requestCarUntil:"+requestCarUntil+"]");
		return null;
	}

	public void checkRequestPrerequisites(Date requestFrom, Date requestUntil) throws GenericBpmException {
		if (requestUntil.before(requestFrom)) {
			throw new GenericBpmException("invalid request range (" + requestFrom + "-" + requestUntil + ")!");
		}
		//Anfrage muss mindestens 48 Stunden vor Fahrtantritt erfolgen
		int diffMinutes = (int) ((requestUntil.getTime()/60000) - (requestFrom.getTime()/60000));
		if (diffMinutes < 2*24*60) {
			throw new GenericBpmException("request is too late!!");
		}
		logger.info(" car requested from '" + requestFrom + "' to '" + requestUntil + "'.");		
	}
}
