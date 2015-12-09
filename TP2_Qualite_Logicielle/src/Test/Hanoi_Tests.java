package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.IllegalStateException;
import Model.Stack;
import Model.HanoiTower;

public class Hanoi_Tests {

	
	@Test
	public void constructorSuccess() throws IllegalStateException {
		int size=3;
		int[] array = {3,2,1};
		Stack stack = new Stack(size, array);
		
		HanoiTower ht = new HanoiTower(size);
		
		assertArrayEquals(stack.getStackInt(), ht.getTower(0).getStackInt());
	}
	
	@Test
	public void moveSuccessTest() throws IllegalStateException {
		int size=3;
		
		int[] array1 = {3,2};
		Stack stack1 = new Stack(size, array1);
		int[] array2 = {1};
		Stack stack2 = new Stack(size, array2);
		
		HanoiTower ht = new HanoiTower(size);
		
		ht.move(0, 1);
		

		assertArrayEquals(stack1.getStackInt(), ht.getTower(0).getStackInt());
		assertArrayEquals(stack2.getStackInt(), ht.getTower(1).getStackInt());
	}
	
	@Test
	public void moveFailureEmptyTowerTest() throws IllegalStateException {
		int size=0;
		
		String message=null;
		
		HanoiTower ht = new HanoiTower(size);
		
		try {
			ht.move(0, 1);
		}
		catch (IllegalStateException ex){
			message = ex.getMessage();
		}
		
		assertEquals(message, "Your departure tower is empty, there is no disk to move.");
	}
	
	@Test
	public void moveFailureSmallerDiskTest() throws IllegalStateException {
		int size=3;
		
		String message=null;
		
		HanoiTower ht = new HanoiTower(size);
		
		try {
			ht.move(0, 1);
			ht.move(0, 1);
		}
		catch (IllegalStateException ex){
			message = ex.getMessage();
		}
		
		assertEquals(message, "You cannot place a disk on a smaller one. Try something else.");
	}
	
	@Test
	public void victorySuccessTest() throws IllegalStateException {
		int size = 3;
		HanoiTower ht = new HanoiTower(size);
		
		ht.move(0, 2);
		ht.move(0, 1);
		ht.move(2, 1);
		ht.move(0, 2);
		ht.move(1, 0);
		ht.move(1, 2);
		ht.move(0, 2);
		
		assertTrue(ht.checkVictory());
	}
	
	@Test
	public void victoryFailureTest() throws IllegalStateException {
		int size = 3;
		HanoiTower ht = new HanoiTower(size);
		
		ht.move(0, 2);
		
		assertFalse(ht.checkVictory());
	}
	
	@Test
	public void autoMoveTest() throws IllegalStateException {
		int size=5;
		
		int[] array = {5,4,3,2,1};
		int[] arrayEmpty = {};
		
		HanoiTower ht = new HanoiTower(size);
		
		Stack stackFull = new Stack(size, array);
		Stack stackEmpty = new Stack(size, arrayEmpty);
		
		
		ht.autoMove(size, 0, 2, 1);

		assertArrayEquals(stackEmpty.getStackInt(), ht.getTower(0).getStackInt());
		assertArrayEquals(stackEmpty.getStackInt(), ht.getTower(1).getStackInt());
		assertArrayEquals(stackFull.getStackInt(), ht.getTower(2).getStackInt());
	}
	
	@Test
	public void autoMoveEmptyTest() throws IllegalStateException {
		int size=0;
		
		HanoiTower ht = new HanoiTower(size);
		
		int[] arrayEmpty = {};
		Stack stackEmpty = new Stack(size, arrayEmpty);
		
		
		ht.autoMove(size, 0, 2, 1);

		assertArrayEquals(stackEmpty.getStackInt(), ht.getTower(0).getStackInt());
		assertArrayEquals(stackEmpty.getStackInt(), ht.getTower(1).getStackInt());
		assertArrayEquals(stackEmpty.getStackInt(), ht.getTower(2).getStackInt());
	}
	
	@Test(expected=IllegalStateException.class)
	public void autoMoveFailure() throws IllegalStateException {
		int size=5;
		
		HanoiTower ht = new HanoiTower(size);
		
		ht.autoMove(size, 2, 0, 2);
	}
	
	@Test(expected=IllegalStateException.class)
	public void autoMoveTooBig() throws IllegalStateException {
		int size = 5;
		
		HanoiTower ht = new HanoiTower(size);
		
		ht.autoMove(size+1, 0, 2, 1);
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void autoMoveOutOfBounds() throws ArrayIndexOutOfBoundsException, IllegalStateException {
		int size=5;
		
		HanoiTower ht = new HanoiTower(size);
		
		ht.autoMove(size, 17, 12, -10);
	}
	
}
