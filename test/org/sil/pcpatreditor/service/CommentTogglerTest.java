package org.sil.pcpatreditor.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommentTogglerTest {

	String result = "";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void commentTogglerTest() {
		result = CommentToggler.insertComments("");
		assertEquals("", result);
		result = CommentToggler.removeComments("");
		assertEquals("", result);
//		result = CommentToggler.toggleComments("\n");
//		assertEquals("\n", result);
		result = CommentToggler.insertComments("a");
		assertEquals("|a", result);
		result = CommentToggler.removeComments("|a");
		assertEquals("a", result);
		result = CommentToggler.insertComments("a\nb");
		assertEquals("|a\n|b", result);
		result = CommentToggler.removeComments("|a\n|b");
		assertEquals("a\nb", result);
		result = CommentToggler.insertComments("all my stars\nbelong to him\n");
		assertEquals("|all my stars\n|belong to him\n", result);
		result = CommentToggler.removeComments("|all my stars\n|belong to him\n");
		assertEquals("all my stars\nbelong to him\n", result);
		result = CommentToggler.insertComments("all my stars\nbelong to him\n\n");
		assertEquals("|all my stars\n|belong to him\n|\n", result);
		result = CommentToggler.removeComments("|all my stars\n|belong to him\n\n");
		assertEquals("all my stars\nbelong to him\n\n", result);
		result = CommentToggler.insertComments("all my stars\nbelong to him\n\n\n");
		assertEquals("|all my stars\n|belong to him\n|\n|\n", result);
		result = CommentToggler.removeComments("|all my stars\n|belong to him\n|\n|\n");
		assertEquals("all my stars\nbelong to him\n\n\n", result);
		result = CommentToggler.removeComments("|all my stars\n|belong to him\n|\nor so\n");
		assertEquals("all my stars\nbelong to him\n\nor so\n", result);
	}
}
