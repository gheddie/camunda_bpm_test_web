package de.gravitex.bpmtest.processref.delegate.carrequest;

import javax.inject.Named;

import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.delegate.DelegateExecution;

import de.gravitex.bpmtest.ejb.common.BpmnMessages;
import de.gravitex.bpmtest.processref.delegate.AbstractProcessDelegate;

@Named
public class RequestLicenseDelegate extends AbstractProcessDelegate {

	public void execute(DelegateExecution arg0) throws Exception {
		System.out.println(" ### RequestLicenseDelegate ### ");
		BpmPlatform.getDefaultProcessEngine().getRuntimeService().correlateMessage(BpmnMessages.CarRequestMessages.MSG_REQ_DRIVER_LICENCE);
	}
}
