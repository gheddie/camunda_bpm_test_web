package de.gravitex.bpmtest.ejb.scripting;

import javax.ejb.Remote;

@Remote
public interface ScriptingHelperRemote {

	public void createStaffCars();
}
