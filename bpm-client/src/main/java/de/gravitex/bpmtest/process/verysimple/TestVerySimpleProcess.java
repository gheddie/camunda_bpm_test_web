package de.gravitex.bpmtest.process.verysimple;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.gravitex.bpmtest.ejb.remoting.EngineProviderRemote;
import de.gravitex.bpmtest.lookup.JB7Lookup;

public class TestVerySimpleProcess {

	public static void main(String[] args) {
		try {
			InitialContext context = JB7Lookup.getServerContext();
			JB7Lookup.lookupRemoteInterface(EngineProviderRemote.class, context).startProcessInstance("verySimpleProcess", null);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
