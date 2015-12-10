package org.swiftsms.tasks.results;

import org.swiftsms.tasks.Status;

/**
 * Notifications for ICC Activities
 * 
 * @author Rob Powell
 */
public abstract class OperationResult {

	private final String message;
	private final Status status;
	private final int colourResource;

	public OperationResult(final String message, final int colourResource, final Status status) {
		this.message = message;
		this.colourResource = colourResource;
		this.status = status;
	}

	public String getMessage() {
		return this.message;
	}

	public Status getStatus() {
		return this.status;
	}

	public int getColourResource() {
		return this.colourResource;
	}
}