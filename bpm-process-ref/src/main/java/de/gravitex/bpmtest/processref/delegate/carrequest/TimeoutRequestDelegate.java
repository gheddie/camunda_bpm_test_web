package de.gravitex.bpmtest.processref.delegate.carrequest;

import javax.inject.Named;

import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import de.gravitex.bpmtest.ejb.common.BpmnMessages;

@Named
public class TimeoutRequestDelegate implements JavaDelegate {

	public void execute(DelegateExecution arg0) throws Exception {
		System.out.println(" ### TimeoutRequestDelegate ### ");
		BpmPlatform.getDefaultProcessEngine().getRuntimeService().correlateMessage(BpmnMessages.CarRequestMessages.MSG_REQ_TIMED_OUT);
	}
}
