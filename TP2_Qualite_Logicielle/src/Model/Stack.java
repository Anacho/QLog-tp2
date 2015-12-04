package Model;

public class Stack implements IStack {
	protected Integer[] stackInt;
	protected int size = 6;
	protected int numberOfElements = 0;
	
	public Stack()
	{
		this.size = 6;
		numberOfElements = 0;
		stackInt = new Integer[size];
	}
	
	public Stack(int size)
	{
		this.size = size;
		numberOfElements = 0;
		stackInt = new Integer[size];
	}

	public Stack(int size, int[] array) throws IllegalStateException
	{
		this.size = size;
		stackInt = new Integer[size];
		if(array.length > size)
			throw new IllegalStateException();
		else for(int i = 0 ; i < array.length ; i++)
		{
			stackInt[i] = array[i];
		}
		numberOfElements = array.length;
	}
	
	public Integer[] getStackInt()
	{
		return stackInt;
	}
	
	@Override
	public int getSize() {
		return size;
	}


	@Override
	public int getNumberOfElements() {
		return numberOfElements;
	}

	
	@Override
	public boolean isFull() {
		if(numberOfElements == size)
			return true;
		return false;
	}


	@Override
	public boolean isEmpty() {
		if(numberOfElements == 0)
			return true;
		return false;
	}


	@Override
	public void push(int x) throws IllegalStateException {
		if(!this.isFull())
		{
			for(int i = numberOfElements - 1; i >= 0; i--)
			{
				stackInt[i+1] = stackInt[i];
			}
			stackInt[0] = x;
			numberOfElements ++;
		}
		else throw new IllegalStateException("Stack is full.");
	}


	@Override
	public int head() throws IllegalStateException {
		if(!isEmpty())
		{
			return stackInt[0];
		}
		else throw new IllegalStateException("Stack is empty.");
	}


	@Override
	public void pop() throws IllegalStateException {
		if(!isEmpty())
		{
			for(int i = 0 ; i < numberOfElements - 1 ; i++)
			{
				stackInt[i] = stackInt[i+1];
			}
			stackInt[numberOfElements - 1] = null;
			numberOfElements --;
		}
		else throw new IllegalStateException("Stack is empty.");
	}
}
