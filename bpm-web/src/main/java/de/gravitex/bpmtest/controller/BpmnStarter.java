package de.gravitex.bpmtest.controller;

import java.util.Date;

import javax.ejb.Stateful;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;

import de.gravitex.bpmtest.ejb.remoting.EngineProvider;
import de.gravitex.bpmtest.ejb.util.DateHelper;

@Stateful
@Model
public class BpmnStarter {
	
	private static Logger logger = Logger.getLogger(BpmnStarter.class);

	@Inject
	EngineProvider engineProvider;
	
	@NotNull
	private String fromDateStr;

	@NotNull
	private String untilDateStr;
	
	@NotNull
	private int numOfSeats;
	
	public String getFromDateStr() {
		return fromDateStr;
	}

	public void setFromDateStr(String fromDateStr) {
		this.fromDateStr = fromDateStr;
	}

	public String getUntilDateStr() {
		return untilDateStr;
	}

	public void setUntilDateStr(String untilDateStr) {
		this.untilDateStr = untilDateStr;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}
	
	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}
	
	//---
	
	public String startPoolCarRequestProcess() {
		Date fromDate = DateHelper.parseDate(fromDateStr);
		Date untilDate = DateHelper.parseDate(untilDateStr);
		logger.info(" ### starting pool car request process (fromDate:"+fromDate+"|untilDate:"+untilDate+"|numOfSeats:"+numOfSeats+") ### ");
		return "index";
	}

	public void startVerySimpleProcess() {
		System.out.println(" ### starting simple process ### ");
		// start process
		if (engineProvider != null) {
			engineProvider.startProcessInstance("verySimpleProcess", null);
		} else {
			System.out.println("engineProvider NULL");
		}
	}
}
