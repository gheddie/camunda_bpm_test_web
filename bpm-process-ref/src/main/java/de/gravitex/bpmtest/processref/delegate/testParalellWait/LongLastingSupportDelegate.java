package de.gravitex.bpmtest.processref.delegate.testParalellWait;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class LongLastingSupportDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println(" ### LongLastingSupportDelegate ### ");
		for (int i=0;i<100000;i++) {
			System.out.println(i);
		}
	}
}
