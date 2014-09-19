package de.gravitex.bpmtest.process.carrequest;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.gravitex.bpmtest.ejb.common.BpmnVariables;
import de.gravitex.bpmtest.ejb.common.ProcessDefinitionKeys;
import de.gravitex.bpmtest.ejb.remoting.EngineProviderRemote;
import de.gravitex.bpmtest.ejb.scripting.ScriptingHelperRemote;
import de.gravitex.bpmtest.lookup.JB7Lookup;

public class TestCarRequestProcess {

	public static void main(String[] args) {
		
//		createStaffCars();
		
		//---------------------------------------------------------------------------
		
		//Prozess starten
		startCarRequestProcess();
		
		//FE vorlegen
//		provideDriverLicence();
	}
	
	private static void createStaffCars() {
		try {
			InitialContext context = JB7Lookup.getServerContext();
			JB7Lookup.lookupRemoteInterface(ScriptingHelperRemote.class, context).createStaffCars();
		} catch (NamingException e) {
			e.printStackTrace();
		}		
	}

	private static void provideDriverLicence() {
		try {
			InitialContext context = JB7Lookup.getServerContext();
			JB7Lookup.lookupRemoteInterface(EngineProviderRemote.class, context).completeTask("c83a0816-3da2-11e4-ba1c-5add20524153");
		} catch (NamingException e) {
			e.printStackTrace();
		}		
	}

	//---
	
	private static void startCarRequestProcess() {
		try {
			InitialContext context = JB7Lookup.getServerContext();
			Map<String, Object> variables = new HashMap<String, Object>();
			
			variables.put(BpmnVariables.CarRequestVariables.NUM_SEATS_REQUESTED, 5);
			
			Calendar calFrom = Calendar.getInstance();			
			calFrom.set(2016, 6, 6, 0, 0, 0);						
			variables.put(BpmnVariables.CarRequestVariables.REQUEST_CAR_FROM, calFrom.getTime());
			
			Calendar calUntil = Calendar.getInstance();
			calUntil.set(2016, 6, 9, 0, 0, 0);
			variables.put(BpmnVariables.CarRequestVariables.REQUEST_CAR_UNTIL, calUntil.getTime());
			
			JB7Lookup.lookupRemoteInterface(EngineProviderRemote.class, context).startProcessInstance(ProcessDefinitionKeys.CAR_REQUEST, variables);			
		} catch (NamingException e) {
			e.printStackTrace();
		}		
	}	
}
