package org.sil.pcpatreditor.service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sil.pcpatreditor.Constants;

public class FindReplaceOperatorTest {

	String content;
	FindReplaceOperator findReplaceOperator;
	Locale locale;
	
	@Before
	public void setUp() throws Exception {
		locale = new Locale("en");
		File file = new File(Constants.UNIT_TEST_DATA_FILE);
		try {
			content = new String(Files.readAllBytes(file.toPath()),
					StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findReplaceOperator = FindReplaceOperator.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void findForwardNotCaseNotWholeWordTest() {
		findReplaceOperator.initializeParameters(true, true, false, false, false, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.find("head");
		assertEquals(396, result);
		result = findReplaceOperator.find("Head");
		assertEquals(396, result);
		result = findReplaceOperator.find("absolutive");
		assertEquals(1245, result);
		result = findReplaceOperator.find("absoluTive");
		assertEquals(1245, result);
		result = findReplaceOperator.find("abs");
		assertEquals(1245, result);
		result = findReplaceOperator.find("-absolutive");
		assertEquals(1335, result);
		result = findReplaceOperator.find("-abSOLutive");
		assertEquals(1335, result);
	}

	@Test
	public void findForwardNotCaseWholeWordTest() {
		findReplaceOperator.initializeParameters(true, true, false, true, false, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.find("head");
		assertEquals(396, result);
		result = findReplaceOperator.find("Head");
		assertEquals(396, result);
		result = findReplaceOperator.find("absolutive");
		assertEquals(1245, result);
		result = findReplaceOperator.find("absoluTive");
		assertEquals(1245, result);
		result = findReplaceOperator.find("-absolutive");
		assertEquals(-1, result);
		result = findReplaceOperator.find("abs");
		assertEquals(-1, result);
	}

	@Test
	public void findForwardCaseNotWholeWordTest() {
		findReplaceOperator.initializeParameters(true, true, true, false, false, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.find("head");
		assertEquals(396, result);
		result = findReplaceOperator.find("Head");
		assertEquals(-1, result);
		result = findReplaceOperator.find("absolutive");
		assertEquals(1245, result);
		result = findReplaceOperator.find("absoluTive");
		assertEquals(-1, result);
		result = findReplaceOperator.find("abs");
		assertEquals(1245, result);
		result = findReplaceOperator.find("-absolutive");
		assertEquals(1335, result);
		result = findReplaceOperator.find("-abSOLutive");
		assertEquals(-1, result);
	}


	@Test
	public void findForwardCaseWholeWordTest() {
		findReplaceOperator.initializeParameters(true, true, true, true, false, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.find("head");
		assertEquals(396, result);
		result = findReplaceOperator.find("Head");
		assertEquals(-1, result);
		result = findReplaceOperator.find("absolutive");
		assertEquals(1245, result);
		result = findReplaceOperator.find("absoluTive");
		assertEquals(-1, result);
		result = findReplaceOperator.find("-absolutive");
		assertEquals(-1, result);
		result = findReplaceOperator.find("abs");
		assertEquals(-1, result);
	}


	@Test
	public void findBackwardNotCaseNotWholeWordTest() {
		findReplaceOperator.initializeParameters(false, true, false, false, false, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.find("head");
		assertEquals(412837, result);
		result = findReplaceOperator.find("Head");
		assertEquals(412837, result);
		result = findReplaceOperator.find("absolutive");
		assertEquals(6661, result);
		result = findReplaceOperator.find("absoluTive");
		assertEquals(6661, result);
		result = findReplaceOperator.find("abs");
		assertEquals(6661, result);
		result = findReplaceOperator.find("-absolutive");
		assertEquals(1335, result);
		result = findReplaceOperator.find("-abSOLutive");
		assertEquals(1335, result);
	}

	@Test
	public void findBackwardNotCaseWholeWordTest() {
		findReplaceOperator.initializeParameters(false, true, false, true, false, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.find("head");
		assertEquals(412837, result);
		result = findReplaceOperator.find("Head");
		assertEquals(412837, result);
		result = findReplaceOperator.find("absolutive");
		assertEquals(6661, result);
		result = findReplaceOperator.find("absoluTive");
		assertEquals(6661, result);
		result = findReplaceOperator.find("-absolutive");
		assertEquals(-1, result);
		result = findReplaceOperator.find("abs");
		assertEquals(-1, result);
	}

	@Test
	public void findBackwardCaseNotWholeWordTest() {
		findReplaceOperator.initializeParameters(false, true, true, false, false, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.find("head");
		assertEquals(412837, result);
		result = findReplaceOperator.find("Head");
		assertEquals(-1, result);
		result = findReplaceOperator.find("absolutive");
		assertEquals(6661, result);
		result = findReplaceOperator.find("absoluTive");
		assertEquals(-1, result);
		result = findReplaceOperator.find("abs");
		assertEquals(6661, result);
		result = findReplaceOperator.find("-absolutive");
		assertEquals(1335, result);
		result = findReplaceOperator.find("-abSOLutive");
		assertEquals(-1, result);
	}


	@Test
	public void findBackwardCaseWholeWordTest() {
		findReplaceOperator.initializeParameters(false, true, true, true, false, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.find("head");
		assertEquals(412837, result);
		result = findReplaceOperator.find("Head");
		assertEquals(-1, result);
		result = findReplaceOperator.find("absolutive");
		assertEquals(6661, result);
		result = findReplaceOperator.find("absoluTive");
		assertEquals(-1, result);
		result = findReplaceOperator.find("-absolutive");
		assertEquals(-1, result);
		result = findReplaceOperator.find("abs");
		assertEquals(-1, result);
	}
}
