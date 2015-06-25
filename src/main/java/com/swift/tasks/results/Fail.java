package com.swift.tasks.results;

import com.swift.tasks.Status;

public class Fail extends OperationResult {

	public static final OperationResult MESSAGE_FAILED = new Fail("Message failed to send");
	public static final OperationResult LOGIN_FAILED = new Fail("Login failed");
	public static final OperationResult OPERATOR_CHANGED = new Fail("Operator website changed");
	public static final OperationResult NO_INTERNET_CONNECTION = new Fail("No internet connection");

	private Fail(final String message) {
		super(message, 0xffce0001, Status.FAILED);
	}

}