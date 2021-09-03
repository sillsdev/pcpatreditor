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
		int result = findReplaceOperator.find(-1, "");
		assertEquals(-1, result);
		result = findReplaceOperator.find(-1, "head");
		assertEquals(-1, result);
		result = findReplaceOperator.find(content.length(), "head");
		assertEquals(-1, result);
		result = findReplaceOperator.find(0, "head");
		assertEquals(396, result);
		result = findReplaceOperator.find(397, "head");
		assertEquals(486, result);
		result = findReplaceOperator.find(0, "Head");
		assertEquals(396, result);
		result = findReplaceOperator.find(0, "absolutive");
		assertEquals(1245, result);
		result = findReplaceOperator.find(0, "absoluTive");
		assertEquals(1245, result);
		result = findReplaceOperator.find(0, "abs");
		assertEquals(1245, result);
		result = findReplaceOperator.find(0, "-absolutive");
		assertEquals(1335, result);
		result = findReplaceOperator.find(0, "-abSOLutive");
		assertEquals(1335, result);
		// check for wrapping
		result = findReplaceOperator.find(6662, "absolutive");
		assertEquals(-1, result);
		findReplaceOperator.setWrapSearch(true);
		result = findReplaceOperator.find(6662, "absolutive");
		assertEquals(1245, result);
		}

	@Test
	public void findForwardNotCaseWholeWordTest() {
		findReplaceOperator.initializeParameters(true, true, false, true, false, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.find(0, "head");
		assertEquals(396, result);
		result = findReplaceOperator.find(0, "Head");
		assertEquals(396, result);
		result = findReplaceOperator.find(0, "absolutive");
		assertEquals(1245, result);
		result = findReplaceOperator.find(0, "absoluTive");
		assertEquals(1245, result);
		result = findReplaceOperator.find(0, "-absolutive");
		assertEquals(-1, result);
		result = findReplaceOperator.find(0, "abs");
		assertEquals(-1, result);
	}

	@Test
	public void findForwardCaseNotWholeWordTest() {
		findReplaceOperator.initializeParameters(true, true, true, false, false, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.find(0, "head");
		assertEquals(396, result);
		result = findReplaceOperator.find(0, "Head");
		assertEquals(-1, result);
		result = findReplaceOperator.find(0, "absolutive");
		assertEquals(1245, result);
		result = findReplaceOperator.find(0, "absoluTive");
		assertEquals(-1, result);
		result = findReplaceOperator.find(0, "abs");
		assertEquals(1245, result);
		result = findReplaceOperator.find(0, "-absolutive");
		assertEquals(1335, result);
		result = findReplaceOperator.find(0, "-abSOLutive");
		assertEquals(-1, result);
	}


	@Test
	public void findForwardCaseWholeWordTest() {
		findReplaceOperator.initializeParameters(true, true, true, true, false, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.find(0, "head");
		assertEquals(396, result);
		result = findReplaceOperator.find(0, "Head");
		assertEquals(-1, result);
		result = findReplaceOperator.find(0, "absolutive");
		assertEquals(1245, result);
		result = findReplaceOperator.find(0, "absoluTive");
		assertEquals(-1, result);
		result = findReplaceOperator.find(0, "-absolutive");
		assertEquals(-1, result);
		result = findReplaceOperator.find(0, "abs");
		assertEquals(-1, result);
	}


	@Test
	public void findBackwardNotCaseNotWholeWordTest() {
		findReplaceOperator.initializeParameters(false, true, false, false, false, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.find(-1, "");
		assertEquals(-1, result);
		result = findReplaceOperator.find(-1, "head");
		assertEquals(-1, result);
		result = findReplaceOperator.find(content.length(), "head");
		assertEquals(-1, result);
		result = findReplaceOperator.find(0, "head");
		assertEquals(412837, result);
		result = findReplaceOperator.find(412836, "head");
		assertEquals(412794, result);
		result = findReplaceOperator.find(0, "Head");
		assertEquals(412837, result);
		result = findReplaceOperator.find(0, "absolutive");
		assertEquals(6661, result);
		result = findReplaceOperator.find(0, "absoluTive");
		assertEquals(6661, result);
		result = findReplaceOperator.find(0, "abs");
		assertEquals(6661, result);
		result = findReplaceOperator.find(0, "-absolutive");
		assertEquals(1335, result);
		result = findReplaceOperator.find(0, "-abSOLutive");
		assertEquals(1335, result);
		// check for wrapping
		result = findReplaceOperator.find(1244, "absolutive");
		assertEquals(-1, result);
		findReplaceOperator.setWrapSearch(true);
		result = findReplaceOperator.find(1244, "absolutive");
		assertEquals(6661, result);
	}

	@Test
	public void findBackwardNotCaseWholeWordTest() {
		findReplaceOperator.initializeParameters(false, true, false, true, false, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.find(0, "head");
		assertEquals(412837, result);
		result = findReplaceOperator.find(0, "Head");
		assertEquals(412837, result);
		result = findReplaceOperator.find(0, "absolutive");
		assertEquals(6661, result);
		result = findReplaceOperator.find(0, "absoluTive");
		assertEquals(6661, result);
		result = findReplaceOperator.find(0, "-absolutive");
		assertEquals(-1, result);
		result = findReplaceOperator.find(0, "abs");
		assertEquals(-1, result);
	}

	@Test
	public void findBackwardCaseNotWholeWordTest() {
		findReplaceOperator.initializeParameters(false, true, true, false, false, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.find(0, "head");
		assertEquals(412837, result);
		result = findReplaceOperator.find(0, "Head");
		assertEquals(-1, result);
		result = findReplaceOperator.find(0, "absolutive");
		assertEquals(6661, result);
		result = findReplaceOperator.find(0, "absoluTive");
		assertEquals(-1, result);
		result = findReplaceOperator.find(0, "abs");
		assertEquals(6661, result);
		result = findReplaceOperator.find(0, "-absolutive");
		assertEquals(1335, result);
		result = findReplaceOperator.find(0, "-abSOLutive");
		assertEquals(-1, result);
	}


	@Test
	public void findBackwardCaseWholeWordTest() {
		findReplaceOperator.initializeParameters(false, true, true, true, false, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.find(0, "head");
		assertEquals(412837, result);
		result = findReplaceOperator.find(0, "Head");
		assertEquals(-1, result);
		result = findReplaceOperator.find(0, "absolutive");
		assertEquals(6661, result);
		result = findReplaceOperator.find(0, "absoluTive");
		assertEquals(-1, result);
		result = findReplaceOperator.find(0, "-absolutive");
		assertEquals(-1, result);
		result = findReplaceOperator.find(0, "abs");
		assertEquals(-1, result);
	}

	@Test
	public void findRegularExpressionForwardNotCaseTest() {
		findReplaceOperator.initializeParameters(true, true, false, false, true, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.findRegularExpression(-1, "");
		assertEquals(-1, result);
		result = findReplaceOperator.findRegularExpression(-1, "head .+ject");
		assertEquals(-1, result);
		result = findReplaceOperator.findRegularExpression(content.length(), "head .+ject");
		assertEquals(-1, result);
		result = findReplaceOperator.findRegularExpression(0, "head .+ject");
		assertEquals(574, result);
		result = findReplaceOperator.findRegularExpression(575, "head .+ject");
		assertEquals(663, result);
		result = findReplaceOperator.findRegularExpression(0, "Head .+ject");
		assertEquals(574, result);
		result = findReplaceOperator.findRegularExpression(0, "[au]tive");
		assertEquals(63, result);
		result = findReplaceOperator.findRegularExpression(0, "[au]Tive");
		assertEquals(63, result);
		// check for wrapping
		result = findReplaceOperator.findRegularExpression(412890, "[au]tive");
		assertEquals(-1, result);
		findReplaceOperator.setWrapSearch(true);
		result = findReplaceOperator.findRegularExpression(412890, "[au]tive");
		assertEquals(63, result);
		}

	@Test
	public void findRegularExpressionForwardCaseTest() {
		findReplaceOperator.initializeParameters(true, true, true, false, true, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.findRegularExpression(0, "head .+ject");
		assertEquals(574, result);
		result = findReplaceOperator.findRegularExpression(575, "head .+ject");
		assertEquals(663, result);
		result = findReplaceOperator.findRegularExpression(0, "Head .+ject");
		assertEquals(-1, result);
		result = findReplaceOperator.findRegularExpression(0, "[au]tive");
		assertEquals(63, result);
		result = findReplaceOperator.findRegularExpression(0, "[au]Tive");
		assertEquals(-1, result);
		}

	@Test
	public void findRegularExpressionBackwardNotCaseTest() {
		findReplaceOperator.initializeParameters(false, true, false, false, true, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.findRegularExpression(0, "head .+ject");
		assertEquals(408887, result);
		result = findReplaceOperator.findRegularExpression(408886, "head .+ject");
		assertEquals(405039, result);
		result = findReplaceOperator.findRegularExpression(0, "Head .+ject");
		assertEquals(408887, result);
		result = findReplaceOperator.findRegularExpression(0, "[au]tive");
		assertEquals(412866, result);
		result = findReplaceOperator.findRegularExpression(0, "[au]Tive");
		assertEquals(412866, result);
		result = findReplaceOperator.findRegularExpression(0, "[au]Tive");
		assertEquals(412866, result);
		result = findReplaceOperator.findRegularExpression(0, "-abs");
		assertEquals(1335, result);
		result = findReplaceOperator.findRegularExpression(1336, "-abs");
		assertEquals(-1, result);
		result = findReplaceOperator.findRegularExpression(0, "\\+abs");
		assertEquals(-1, result);
		// check for wrapping
		result = findReplaceOperator.findRegularExpression(16, "[au]tive");
		assertEquals(-1, result);
		findReplaceOperator.setWrapSearch(true);
		result = findReplaceOperator.findRegularExpression(16, "[au]tive");
		assertEquals(412866, result);
		}

	@Test
	public void findRegularExpressionBackwardCaseTest() {
		findReplaceOperator.initializeParameters(false, true, true, false, true, false, false);
		findReplaceOperator.setContent(content);
		int result = findReplaceOperator.findRegularExpression(0, "head .+ject");
		assertEquals(408887, result);
		result = findReplaceOperator.findRegularExpression(408886, "head .+ject");
		assertEquals(405039, result);
		result = findReplaceOperator.findRegularExpression(0, "Head .+ject");
		assertEquals(-1, result);
		result = findReplaceOperator.findRegularExpression(0, "[au]tive");
		assertEquals(412866, result);
		result = findReplaceOperator.findRegularExpression(0, "[au]Tive");
		assertEquals(-1, result);
		}

}