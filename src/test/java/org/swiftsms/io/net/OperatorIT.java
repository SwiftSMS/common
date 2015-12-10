package org.swiftsms.io.net;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import org.swiftsms.model.Account;
import org.swiftsms.model.Network;
import org.swiftsms.tasks.Status;
import org.swiftsms.tasks.results.OperationResult;

public class OperatorIT {

	private static final Status SUCCESS = Status.SUCCESS;
	private static final String SUCCESS_MESSAGE = "Message sent!";

	private static final Random rand = new Random();
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

		operator.login();
		operator.getRemainingSMS();
		operator.getCharacterLimit();
		final OperationResult result = operator.send(recipients, rand.nextInt(99999) + ": Hello World from Old Meteor!");

		assertEquals(SUCCESS_MESSAGE, result.getMessage());
		assertEquals(SUCCESS, result.getStatus());
	}

	@Test
	public void testMeteor() {
		final Account account = new Account(props.getProperty("meteor.username"), "Meteor", props.getProperty("meteor.password"), Network.METEOR);
		final Operator operator = OperatorFactory.getOperator(account);

		operator.login();
		operator.getRemainingSMS();
		final OperationResult result = operator.send(recipients, rand.nextInt(99999) + ": Hello World from Meteor!");

		assertEquals(SUCCESS_MESSAGE, result.getMessage());
		assertEquals(SUCCESS, result.getStatus());
	}

	@Test
	public void testThree() {
		final Account account = new Account(props.getProperty("three.username"), "Three", props.getProperty("three.password"), Network.THREE);
		final Operator operator = OperatorFactory.getOperator(account);

		operator.login();
		operator.getRemainingSMS();
		final OperationResult result = operator.send(recipients, rand.nextInt(99999) + ": Hello World from Three!");

		assertEquals(SUCCESS_MESSAGE, result.getMessage());
		assertEquals(SUCCESS, result.getStatus());
	}

	@Test
	public void testTesco() {
		final Account account = new Account(props.getProperty("tesco.username"), "Tesco", props.getProperty("tesco.password"), Network.TESCO);
		final Operator operator = OperatorFactory.getOperator(account);

		operator.login();
		operator.getRemainingSMS();
		final OperationResult result = operator.send(recipients, rand.nextInt(99999) + ": Hello World from Tesco!");

		assertEquals(SUCCESS_MESSAGE, result.getMessage());
		assertEquals(SUCCESS, result.getStatus());
	}

	@Test
	public void testO2() {
		final Account account = new Account(props.getProperty("o2.username"), "O2", props.getProperty("o2.password"), Network.O2);
		final Operator operator = OperatorFactory.getOperator(account);

		operator.login();
		operator.getRemainingSMS();
		final OperationResult result = operator.send(recipients, rand.nextInt(99999) + ": Hello World from O2!");

		assertEquals(SUCCESS_MESSAGE, result.getMessage());
		assertEquals(SUCCESS, result.getStatus());
	}

}
