package org.swiftsms.tasks.results;

import org.swiftsms.tasks.Status;

public class Success extends OperationResult {

	public static final OperationResult MESSAGE_SENT = new Success("Message sent!");
	public static final OperationResult LOGGED_IN = new Success("Login successful");

	private Success(final String message) {
		super(message, 0xff00e111, Status.SUCCESS);
	}

}