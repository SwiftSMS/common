package org.swiftsms.tasks.results;

import org.swiftsms.tasks.Status;

public class WarningResult extends OperationResult {

	public WarningResult(final String message) {
		super(message, 0xff16a1b5, Status.CANCELLED);
	}

}