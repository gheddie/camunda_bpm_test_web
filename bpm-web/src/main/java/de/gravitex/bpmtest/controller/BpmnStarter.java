package de.gravitex.bpmtest.controller;

import javax.ejb.Stateful;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import de.gravitex.bpmtest.ejb.remoting.EngineProvider;

@Stateful
@Model
public class BpmnStarter {

	@Inject
	EngineProvider engineProvider;

	public void start() {
		System.out.println(" ### starting ### ");
		// start process
		if (engineProvider != null) {
			engineProvider.startProcessInstance("verySimpleProcess", null);
		} else {
			System.out.println("engineProvider NULL");
		}
	}
}
