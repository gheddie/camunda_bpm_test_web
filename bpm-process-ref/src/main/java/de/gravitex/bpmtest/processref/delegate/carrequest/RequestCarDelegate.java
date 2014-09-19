package de.gravitex.bpmtest.processref.delegate.carrequest;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.delegate.DelegateExecution;

import de.gravitex.bpmtest.ejb.common.BpmnMessages;
import de.gravitex.bpmtest.ejb.common.BpmnVariables;
import de.gravitex.bpmtest.ejb.logic.carrequest.PoolCarService;
import de.gravitex.bpmtest.processref.delegate.AbstractProcessDelegate;

@Named
public class RequestCarDelegate extends AbstractProcessDelegate {

	private static Logger logger = Logger.getLogger(RequestCarDelegate.class);
	
	@Inject
	PoolCarService poolCarService;

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println(" ### RequestCarDelegate ### ");
		ensureVariableSet(execution, BpmnVariables.CarRequestVariables.NUM_SEATS_REQUESTED, Integer.class);
		ensureVariableSet(execution, BpmnVariables.CarRequestVariables.REQUEST_CAR_FROM, Date.class);
		ensureVariableSet(execution, BpmnVariables.CarRequestVariables.REQUEST_CAR_UNTIL, Date.class);
		Date requestFrom = (java.util.Date) execution.getVariable(BpmnVariables.CarRequestVariables.REQUEST_CAR_FROM);
		Date requestUntil = (java.util.Date) execution.getVariable(BpmnVariables.CarRequestVariables.REQUEST_CAR_UNTIL);
		poolCarService.checkRequestPrerequisites(requestFrom, requestUntil);
		displayVariableValues(execution, this);
		// Die Prozess-Variablen müssen an den Kind-Prozess weitergegeben
		// werden!		
		BpmPlatform.getDefaultProcessEngine().getRuntimeService().correlateMessage(BpmnMessages.CarRequestMessages.MSG_CAR_REQUESTED, "", execution.getVariables());
	}
}
