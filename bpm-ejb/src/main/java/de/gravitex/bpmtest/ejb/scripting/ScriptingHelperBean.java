package de.gravitex.bpmtest.ejb.scripting;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.gravitex.bpmtest.ejb.entity.carrequest.StaffCar;

@Stateless(name = "ScriptingHelper")
@Local(ScriptingHelper.class)
@Remote(ScriptingHelperRemote.class)
public class ScriptingHelperBean implements ScriptingHelper {
	
	@PersistenceContext
	EntityManager em;

	public void createStaffCars() {
		em.persist(new StaffCar());
	}
}
