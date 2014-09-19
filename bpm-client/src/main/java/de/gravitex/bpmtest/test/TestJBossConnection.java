package de.gravitex.bpmtest.test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import de.gravitex.bpmtest.ejb.common.BpmnVariables;
import de.gravitex.bpmtest.ejb.common.ProcessDefinitionKeys;
import de.gravitex.bpmtest.ejb.logic.wstest.WSTestRemote;
import de.gravitex.bpmtest.ejb.remoting.EngineProviderRemote;
import de.gravitex.bpmtest.lookup.JB7Lookup;

public class TestJBossConnection {

	public static void main(String[] args) {		
//		testWebservice();
//		testWebserviceSimple();
//		testParallelWait();
	}

	private static void testParallelWait() {
		try {
			InitialContext context = JB7Lookup.getServerContext();
			EngineProviderRemote engineProvider = JB7Lookup.lookupRemoteInterface(EngineProviderRemote.class, context);
//			engineProvider.startProcessInstance("testParallelWait", null);
			engineProvider.completeTask("17d60901-3758-11e4-9ed7-1a1320524153");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static void testWebserviceSimple() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(WSTestRemote.class);
		factory.setAddress("http://192.168.0.5:8484/bpm-ejb-1.0-SNAPSHOT/HelloWorldWS?wsdl");
		WSTestRemote ws = (WSTestRemote) factory.create();
		ws.triggerWebserviceSimple(null, null);
	}

	private static void testWebservice() {
		
		//BY JNDI
		try {
			InitialContext context = JB7Lookup.getServerContext();
			JB7Lookup.lookupRemoteInterface(WSTestRemote.class, context).triggerWebservice("fg123ggg", 0, 0);
		} catch (NamingException e) {
			e.printStackTrace();
		}
			
		//BY WS CALL
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(WSTestRemote.class);
		factory.setAddress("http://localhost:8484/bpm-ejb-1.0-SNAPSHOT/HelloWorldWS?wsdl");
		WSTestRemote ws = (WSTestRemote) factory.create();
		int result = ws.triggerWebservice("hello from web service !", 6, 7);
		System.out.println("result in client is "+result+".");
	}
}
