package com.swift.io.net;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.swift.model.Account;
import com.swift.model.Network;
import com.swift.tasks.Status;
import com.swift.tasks.results.OperationResult;

public class OperatorIntegrationTest {

	private static final Status SUCCESS = Status.SUCCESS;
	private static final String SUCCESS_MESSAGE = "Message sent!";

	private List<String> recipients = new ArrayList<>();

	@Before
	public void setup() {
		recipients.add("<RECIPIENT>");
	}

	@Test
	public void testOldMeteor() {
		final Account account = new Account("<USERNAME>", "Meteor", "<PASSWORD>", Network.METEOR);
		final Operator operator = OperatorFactory.getOperator(account);

		final OperationResult result = operator.send(recipients, "Hello World!");

		assertEquals(SUCCESS_MESSAGE, result.getMessage());
		assertEquals(SUCCESS, result.getStatus());
	}

	@Test
	public void testMeteor() {
		final Account account = new Account("<USERNAME>", "Meteor", "<PASSWORD>", Network.METEOR);
		final Operator operator = OperatorFactory.getOperator(account);

		final OperationResult result = operator.send(recipients, "Hello World!");

		assertEquals(SUCCESS_MESSAGE, result.getMessage());
		assertEquals(SUCCESS, result.getStatus());
	}

	@Test
	public void testThree() {
		final Account account = new Account("<USERNAME>", "Three", "<PASSWORD>", Network.THREE);
		final Operator operator = OperatorFactory.getOperator(account);

		final OperationResult result = operator.send(recipients, "Hello World!");

		assertEquals(SUCCESS_MESSAGE, result.getMessage());
		assertEquals(SUCCESS, result.getStatus());
	}

	@Test
	public void testTesco() {
		final Account account = new Account("<USERNAME>", "Tesco", "<PASSWORD>", Network.TESCO);
		final Operator operator = OperatorFactory.getOperator(account);

		final OperationResult result = operator.send(recipients, "Hello World!");

		assertEquals(SUCCESS_MESSAGE, result.getMessage());
		assertEquals(SUCCESS, result.getStatus());
	}

}
