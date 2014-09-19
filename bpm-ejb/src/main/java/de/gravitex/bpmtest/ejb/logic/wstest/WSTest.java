package de.gravitex.bpmtest.ejb.logic.wstest;

import javax.ejb.Local;
import javax.jws.WebService;

@Local
@WebService
public interface WSTest extends WSTestRemote {

}
