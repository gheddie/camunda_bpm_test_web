package de.gravitex.bpmtest.processref.delegate.carrequest;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Named;

import org.apache.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;

import de.gravitex.bpmtest.ejb.common.BpmnVariables;
import de.gravitex.bpmtest.processref.delegate.AbstractProcessDelegate;
import de.gravitex.bpmtest.processref.delegate.BpmnConstants;

@Named
public class TriggerReservationDelegate extends AbstractProcessDelegate {
	
	private static Logger			logger					= Logger.getLogger(TriggerReservationDelegate.class);

	public void execute(DelegateExecution execution) throws Exception {		
		logger.info(" ### TriggerReservationDelegate ### ");
		Calendar calReqDlPoTime = Calendar.getInstance();
		if (BpmnConstants.TESTING) {
			calReqDlPoTime.add(Calendar.SECOND, 30);
			logger.info("set '"+BpmnVariables.CarRequestVariables.REQUEST_LICENCE_POT+"' to "+calReqDlPoTime.getTime()+".");
		} else {
			calReqDlPoTime.setTime((Date) execution.getVariable(BpmnVariables.CarRequestVariables.REQUEST_CAR_FROM));
			calReqDlPoTime.add(Calendar.HOUR, -24);
			logger.info("set '"+BpmnVariables.CarRequestVariables.REQUEST_LICENCE_POT+"' to "+calReqDlPoTime.getTime()+".");			
		}
		execution.setVariable(BpmnVariables.CarRequestVariables.REQUEST_LICENCE_POT, calReqDlPoTime.getTime());
	}
}
