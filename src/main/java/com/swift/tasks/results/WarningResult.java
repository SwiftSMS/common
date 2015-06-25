package com.swift.tasks.results;

import com.swift.tasks.Status;

public class WarningResult extends OperationResult {

	public WarningResult(final String message) {
		super(message, 0xff16a1b5, Status.CANCELLED);
	}

}