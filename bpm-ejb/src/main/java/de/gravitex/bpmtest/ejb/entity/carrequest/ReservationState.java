package de.gravitex.bpmtest.ejb.entity.carrequest;

public enum ReservationState {

	/** steht im Fuhrpark */
	IDLE,
	
	/** steht im Fuhrpark und wurde reserviert */
	REQUESTED,
	
	/** unterwegs */
	IN_SERVICE
}
