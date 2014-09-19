package de.gravitex.bpmtest.processref.delegate.carrequest;

import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import de.gravitex.bpmtest.ejb.common.BpmnMessages;

public class LicenceProvidedDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println(" ### LicenceProvidedDelegate ### ");
		BpmPlatform.getDefaultProcessEngine().getRuntimeService().correlateMessage(BpmnMessages.CarRequestMessages.MSG_LICENCE_PROVIDED, "", execution.getVariables());
	}
}
