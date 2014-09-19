package de.gravitex.bpmtest.perl;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import de.gravitex.bpmtest.ejb.logic.ComponentState;
import de.gravitex.bpmtest.ejb.logic.wstest.WSTestRemote;

public class PerlWebServiceConnectorFixedParameters {

	public static void main(String[] args) {
		triggerWebservice(args);	
	}

	private static void triggerWebservice(String[] args) {
		/*
		JFrame fr = new JFrame();
		fr.setSize(800, 600);
		fr.setVisible(true);
		*/
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(WSTestRemote.class);
		factory.setAddress("http://192.168.0.5:8484/bpm-ejb-1.0-SNAPSHOT/HelloWorldWS?wsdl");
//		factory.setAddress("http://192.168.0.5:8484/bpm-ejb-1.0-SNAPSHOT/HelloWorldWS?wsdl");
		WSTestRemote ws = (WSTestRemote) factory.create();
		ws.triggerWebserviceSimple("123-456-789", ComponentState.OPEN);
	}
}
