package de.gravitex.bpmtest.processref.delegate;

import org.apache.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import de.gravitex.bpmtest.ejb.common.GenericBpmException;

public abstract class AbstractProcessDelegate implements JavaDelegate {
	
	private static Logger logger = Logger.getLogger(AbstractProcessDelegate.class);

	protected void ensureVariableSet(DelegateExecution execution, String variableName, Class<?> variableType) throws GenericBpmException {
		Object variable = execution.getVariable(variableName);
		if (variable == null) {
			throw new GenericBpmException("variable "+variableName+" must be set!");
		}
		if (!(variable.getClass().equals(variableType))) {
			throw new GenericBpmException("variable "+variableName+" must be from type '"+variableType.getCanonicalName()+"' but was'"+variable.getClass().getCanonicalName()+"'!");
		}
	}
	
	protected void displayVariableValue(DelegateExecution execution, String variableName) {
		Object variable = execution.getVariable(variableName);
		if (variable != null) {
			logger.info("variable '"+variableName+"' is set to value '"+variable+"' (class:"+variable.getClass().getCanonicalName()+").");	
		} else {
			logger.info("variable '"+variableName+"' is set to NULL.");
		}
	}
	
	protected void displayVariableValues(DelegateExecution execution, JavaDelegate parent) {
		logger.info(" --------------------- variable values (parent: "+parent.getClass().getCanonicalName()+")");
		for (String variable : execution.getVariableNames()) {
			displayVariableValue(execution, variable);
		}
		logger.info(" ---------------------------------------------------------------------------------------------------------------- ");
	}	
}
