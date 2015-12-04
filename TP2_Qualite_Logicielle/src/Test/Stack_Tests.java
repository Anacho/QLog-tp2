package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.IllegalStateException;
import Model.Stack;

public class Stack_Tests {
 
	@Test
	public void testConstructorDefault() {
		Stack stack = new Stack();
		assertEquals(6, stack.getStackInt().length);
	}

	@Test
	public void testConstructorSize() {
		int size = 12;
		Stack stack = new Stack(size);
		assertEquals(size, stack.getStackInt().length);
	}

	@Test
	public void testConstructorArray() throws IllegalStateException {
		int size = 12;
		int[] array = { 1, 2, 3 };
		Stack stack = new Stack(size, array);
		int[] newArray = new int[stack.getNumberOfElements()];
		for (int i = 0; i < array.length; i++) {
			newArray[array.length-1-i] = stack.getStackInt()[i];
		}
		assertArrayEquals(array, newArray);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testConstructorArrayFailure() throws IllegalStateException {
		int size = 2;
		int[] array = { 1, 2, 3, 4 };		
		
		Stack stack = new Stack(size, array);
	}

	@Test
	public void testGetSizeDefault() {
		Stack stack = new Stack();
		assertEquals(6, stack.getSize());
	}

	@Test
	public void testGizeSizeGiven() {
		int size = 12;
		Stack stack = new Stack(size);
		assertEquals(size, stack.getSize());
	}

	@Test
	public void testGetNumberOfElements() throws IllegalStateException {
		int size = 6;
		int[] array = { 1, 2, 3, 4 };
		Stack stack = new Stack(size, array);
		assertEquals(array.length, stack.getNumberOfElements());
	}

	@Test
	public void testIsFullTrue() throws IllegalStateException {
		int size = 3;
		int[] array = { 1, 2, 3 };
		Stack stack = new Stack(size, array);
		assertTrue(stack.isFull());
	}

	@Test
	public void testIsFullFalse() throws IllegalStateException {
		int size = 3;
		int[] array = { 1, 2 };
		Stack stack = new Stack(size, array);
		assertFalse(stack.isFull());
	}

	@Test
	public void testIsEmptyTrue() throws IllegalStateException {
		int size = 3;
		Stack stack = new Stack(size);
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testIsEmptyFalse() throws IllegalStateException {
		int size = 3;
		int[] array = { 1, 2 };
		Stack stack = new Stack(size, array);
		assertFalse(stack.isEmpty());
	}

	@Test 
	public void testPushSuccess() throws IllegalStateException {
		int size = 3;
		int[] array = {1, 2};
		Integer[] arrayFinal1 = {10, null, null};
		Integer[] arrayFinal2 = {1,2,10};
		
		Stack stack1 = new Stack(size);
		Stack stack2 = new Stack(size, array);
		
		try {
			stack1.push(10);
			stack2.push(10);
			
			assertArrayEquals(arrayFinal1, stack1.getStackInt());
			assertArrayEquals(arrayFinal2, stack2.getStackInt());
		} catch (IllegalStateException ex) {
			assertNull(ex.getMessage());
		}
	}

	@Test (expected = IllegalStateException.class)
	public void testPushFailure() throws IllegalStateException {
		int size = 3;
		int[] array = { 1, 2, 3 };
		Stack stack = new Stack(size, array);
		
		stack.push(10);
		
	}

	@Test
	public void testHeadSuccess() throws IllegalStateException {
		int size = 3;
		int[] array = { 1, 2 };
		Stack stack = new Stack(size, array);
		try {
			stack.head();
		} catch (IllegalStateException ex) {
			assertNull(ex.getMessage());
		}
	}
 
	@Test (expected = IllegalStateException.class)
	public void testHeadFailure() throws IllegalStateException {
		int size = 3;
		Stack stack = new Stack(size);

		stack.head();
		
	}

	@Test
	public void testPopSuccess() throws IllegalStateException {
		int size = 3;
		int[] array = { 1, 2, 3 };
		Stack stack = new Stack(size, array);
		try {
			stack.pop();
		} catch (IllegalStateException ex) {
			assertNull(ex.getMessage());
		}
	}

	@Test (expected = IllegalStateException.class)
	public void testPopFailure() throws IllegalStateException {
		int size = 3;
		Stack stack = new Stack(size);
		
		stack.pop();
	}
}
