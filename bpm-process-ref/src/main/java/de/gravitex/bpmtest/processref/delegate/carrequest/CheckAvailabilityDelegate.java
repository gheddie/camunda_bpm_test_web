package de.gravitex.bpmtest.processref.delegate.carrequest;

import javax.inject.Named;

import org.apache.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;

import de.gravitex.bpmtest.processref.delegate.AbstractProcessDelegate;

@Named
public class CheckAvailabilityDelegate extends AbstractProcessDelegate {

	private static Logger logger = Logger.getLogger(CheckAvailabilityDelegate.class);

	public void execute(DelegateExecution execution) throws Exception {
		logger.info(" ### CheckAvailabilityDelegate ### ");
		displayVariableValues(execution, this);
		execution.setVariable("reqAvailable", true);
	}
}
