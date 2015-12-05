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
	
}
