package de.gravitex.bpmtest.processref.delegate.carrequest;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class CancelReservationDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println(" ### CancelReservationDelegate ### ");
	}
}
