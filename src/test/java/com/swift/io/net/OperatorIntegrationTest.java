package com.swift.io.net;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import com.swift.model.Account;
import com.swift.model.Network;
import com.swift.tasks.Status;
import com.swift.tasks.results.OperationResult;

public class OperatorIntegrationTest {

	private static final Status SUCCESS = Status.SUCCESS;
	private static final String SUCCESS_MESSAGE = "Message sent!";

	private static final Properties props = new Properties();
	private static final List<String> recipients = new ArrayList<>();

	@BeforeClass
	public static void setup() throws IOException {
		final InputStream stream = ClassLoader.getSystemResourceAsStream("credentials.properties");
		props.load(stream);

		recipients.add(props.getProperty("recipients"));
	}

	@Test
	public void testOldMeteor() {
		final Account account = new Account(props.getProperty("oldmeteor.username"), "Meteor", props.getProperty("oldmeteor.password"), Network.METEOR);
		final Operator operator = OperatorFactory.getOperator(account);

		final OperationResult result = operator.send(recipients, "Hello World!");

		assertEquals(SUCCESS_MESSAGE, result.getMessage());
		assertEquals(SUCCESS, result.getStatus());
	}

	@Test
	public void testMeteor() {
		final Account account = new Account(props.getProperty("meteor.username"), "Meteor", props.getProperty("meteor.password"), Network.METEOR);
		final Operator operator = OperatorFactory.getOperator(account);

		final OperationResult result = operator.send(recipients, "HelloWorld");

		assertEquals(SUCCESS_MESSAGE, result.getMessage());
		assertEquals(SUCCESS, result.getStatus());
	}

	@Test
	public void testThree() {
		final Account account = new Account(props.getProperty("three.username"), "Three", props.getProperty("three.password"), Network.THREE);
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
