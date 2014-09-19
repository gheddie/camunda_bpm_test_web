package de.gravitex.bpmtest.perl;

import java.util.Properties;

import javax.swing.JFrame;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import de.gravitex.bpmtest.ejb.logic.ComponentState;
import de.gravitex.bpmtest.ejb.logic.wstest.WSTestRemote;

public class PerlWebServiceConnector {

	private static final String PROP_COMPONENT_ID = "componentId";
	
	private static final String PROP_COMPONENT_STATE = "componentState";

	public static void main(String[] args) {
		triggerWebservice(args);	
	}

	private static void triggerWebservice(String[] args) {
		Properties properties = parseCommandLine(args);
		if (properties == null) {			
			return;
		}
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
		WSTestRemote ws = (WSTestRemote) factory.create();
		String propertyComponentState = null;
		ComponentState state = null;
		try {
			propertyComponentState = properties.getProperty(PROP_COMPONENT_STATE);
			state = ComponentState.valueOf(propertyComponentState);
			ws.triggerWebserviceSimple(properties.getProperty(PROP_COMPONENT_ID), state);	
		} catch (IllegalArgumentException e) {
			System.out.println("'"+propertyComponentState+"' can not be parsed as component state ---> returning.");
		}
	}
	
	private static Properties parseCommandLine(String[] args) {
		BasicParser parser = new BasicParser();
		CommandLine commandLine = null;
		Options options = new Options();
		options.addOption(PROP_COMPONENT_ID, true, null);
		options.addOption(PROP_COMPONENT_STATE, true, null);
		try {			
			commandLine = parser.parse(options, args);
		} catch (ParseException e) {
			System.out.println("could not parse command line ---> returning.");
			return null;
		}
		if (commandLine.getOptionValue(PROP_COMPONENT_ID) == null) {
			System.out.println("unsufficient arguments, component id (-" + PROP_COMPONENT_ID + ") required ---> returning.");
			return null;
		}
		if (commandLine.getOptionValue(PROP_COMPONENT_STATE) == null) {
			System.out.println("unsufficient arguments, component state (-" + PROP_COMPONENT_STATE + ") required ---> returning.");
			return null;
		}
		Properties properties = new Properties();
		properties.put(PROP_COMPONENT_ID, commandLine.getOptionValue(PROP_COMPONENT_ID));
		properties.put(PROP_COMPONENT_STATE, commandLine.getOptionValue(PROP_COMPONENT_STATE));
		return properties;
	}	
}
