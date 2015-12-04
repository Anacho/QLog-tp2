package Test;

import static org.junit.Assert.*;

import org.junit.Before;

import Model.Queue;

import org.junit.Test;

import Model.IllegalStateException;
import Model.Stack;

public class Queue_Tests {
	
	@Test
	public void testConstructorDefault(){
		Queue queue = new Queue();
		assertEquals(6, queue.getInput().getStackInt().length);
		assertEquals(6, queue.getOutput().getStackInt().length);
	}
	
	@Test
	public void testConstructorSize(){
		int size=12;
		
		Queue queue = new Queue(size);
		assertEquals(size, queue.getInput().getStackInt().length);
		assertEquals(size, queue.getOutput().getStackInt().length);
	}
	
	@Test
	public void testConstructorArray() throws IllegalStateException{
		int size=6;
		int[] array = {1,2,3};
		
		Queue queue = new Queue(size, array);
		
		int[] newArray = new int[queue.getNumberOfElements()];
		
		for(int i=0; i<newArray.length; i++){
			newArray[i] = queue.getInput().getStackInt()[i];
		}
		
		// A COMPLETER
	}
}
