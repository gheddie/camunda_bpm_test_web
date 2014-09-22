package de.gravitex.bpmtest.ejb.remoting;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.task.Task;

import de.gravitex.bpmtest.ejb.util.MailHelper;

@Stateless(name = "EngineProvider")
@Local(EngineProvider.class)
@Remote(EngineProviderRemote.class)
public class EngineProviderBean implements EngineProvider {
	
	@PersistenceContext
	EntityManager em;
	
	@Resource(mappedName = "java:global/camunda-bpm-platform/process-engine/default")
	private ProcessEngine processEngine;	
	
	public void startProcessInstance(String processDefinitionKey, Map<String, Object> variables) {
		System.out.println("starting process instance by key : '"+processDefinitionKey+"' [process engine='"+processEngine+"'].");
		processEngine.getRuntimeService().startProcessInstanceByKey(processDefinitionKey, variables);
		pollTasks();
	}

	private void pollTasks() {
		try {
			MailHelper.sendEmail("noreply@bcc.de", "stefan.schulz.1976@googlemail.com", null, null, "subject", "body");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public List<Task> queryTasks() {
		List<Task> tasks = processEngine.getTaskService().createTaskQuery().list();
		System.out.println("i have "+tasks.size()+" tasks at the moment");
		return tasks;
	}
	
	public void completeTask(String taskId) {
		processEngine.getTaskService().complete(taskId);
	}

	public void sayMoo() {
		System.out.println("this is NOT the end...");
	}
}
