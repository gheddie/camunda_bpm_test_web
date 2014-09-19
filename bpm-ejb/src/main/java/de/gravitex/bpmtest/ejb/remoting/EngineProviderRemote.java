package de.gravitex.bpmtest.ejb.remoting;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import org.camunda.bpm.engine.task.Task;

@Remote
public interface EngineProviderRemote {

	public void startProcessInstance(String processDefinitionKey, Map<String, Object> variables);

	public List<Task> queryTasks();
	
	public void completeTask(String taskId);
	
	public void sayMoo();
}
