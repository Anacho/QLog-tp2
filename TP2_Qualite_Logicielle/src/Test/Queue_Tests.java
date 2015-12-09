package Test;

import static org.junit.Assert.*;

import Model.Queue;

import org.junit.Test;

import Model.IllegalStateException;

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
			newArray[newArray.length-1-i] = queue.getInput().getStackInt()[i];
		}
		
		assertEquals(size, queue.getInput().getStackInt().length);
		assertEquals(size, queue.getOutput().getStackInt().length);
		assertArrayEquals(newArray, array);
	}
	
	@Test
	public void testGetSize() {
		Queue queue = new Queue();
		
		assertEquals(6, queue.getSize());
	}
	
	@Test
	public void testHeadSuccess() throws IllegalStateException
	{
		int size = 6;
		int[] array = {1, 2, 3};
		
		Queue queue = new Queue(size, array);
		int head = queue.head();
		
		assertEquals(head, array[0]);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testHeadFailure() throws IllegalStateException
	{
		Queue queue = new Queue();
		int head = queue.head();
	}
	
	@Test
	public void testBackSuccess() throws IllegalStateException
	{
		int size = 6;
		int[] array = {1, 2, 3};
		
		Queue queue = new Queue(size, array);
		int back = queue.back();
		
		assertEquals(back, array[array.length-1]);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testBackFailure() throws IllegalStateException
	{
		Queue queue = new Queue();
		int back = queue.back();
	}
	
	@Test
	public void testBackInputEmpty() throws IllegalStateException
	{
		int size = 6;
		int[] array = {1, 2, 3};
		Queue queue = new Queue(size, array);
		queue.Dequeue();
		int back = queue.back();
		
		assertEquals(back, 3);
	}
	
	@Test
	public void testDequeueSuccess() throws IllegalStateException
	{
		int size = 6;
		int[] array = {1, 2, 3};
		
		Queue queue = new Queue(size, array);
		
		queue.Dequeue();
		int[] newArray = new int[queue.getNumberOfElements()];
		
		for(int i=0; i<newArray.length; i++){
			newArray[i] = queue.getOutput().getStackInt()[i];
		}
		
		int[] arr = {2, 3};
		
		assertEquals(array.length-1, queue.getOutput().getNumberOfElements());
		assertEquals(0, queue.getInput().getNumberOfElements());
		assertArrayEquals(arr, newArray);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testDequeueFailure() throws IllegalStateException
	{
		int size = 6;
		Queue queue = new Queue(size);
		queue.Dequeue();
	}
	
	@Test
	public void testEnqueueSuccess() throws IllegalStateException
	{
		int size = 6;
		Queue queue = new Queue(size);
		queue.Enqueue(1);
		
		assertEquals(queue.back(), 1);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testEnqueueFailureTooSmall() throws IllegalStateException
	{
		int size = 3;
		int[] array = {1, 2, 3};
		
		Queue queue = new Queue(size, array);
		queue.Enqueue(10);
	}
}
