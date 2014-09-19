package de.gravitex.bpmtest.ejb.logic.wstest;

import javax.ejb.Remote;
import javax.jws.WebService;

import de.gravitex.bpmtest.ejb.logic.ComponentState;

@Remote
@WebService
public interface WSTestRemote {

	public int triggerWebservice(String message, int x, int y);
	
	public void triggerWebserviceSimple(String componentId, ComponentState componentState);
}
