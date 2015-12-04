package Model;

public class Queue implements IQueue {
	protected Stack input;
	protected Stack output;
	protected int size = 6;
	protected int numberOfElements = 0;
	
	public Queue()
	{
		input = new Stack();
		output = new Stack();
	}
	
	public Queue(int size)
	{
		this.size = size;
		input = new Stack(size);
		output = new Stack(size);
	}
	
	public Queue(int size, int[] array) throws IllegalStateException
	{
		this.size = size;
		numberOfElements = array.length;
		
		input = new Stack(size, array);
		output = new Stack(size);
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
	public Stack getInput(){
		return this.input;
	}
	
	@Override
	public Stack getOutput(){
		return this.output;
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
	public void Enqueue(int var) throws IllegalStateException {
		if(!isFull())
		{
			// problem is input is full
			if(input.isFull())
			{
				// push to output
				// problem: what of data already in output?
				// solution: add it to a brand new array and Q it for the push.
				if(!output.isEmpty())
				{
					// First out, last back in
					int[] tmp = new int[output.getNumberOfElements()];
					for(int i = 0; i < tmp.length ; i++)
					{
						tmp[i] = output.head();
						output.pop();
					}
					
					while(!input.isEmpty()){
						output.push(input.head());
						input.pop();
					}
					
					for(int i = tmp.length-1 ; i <= 0 ; i--)
					{
						output.push(tmp[i]);
					}
				}
				// no problem: no data in output
				else
				{
					while(!input.isEmpty()){
						output.push(input.head());
						input.pop();
					}
				}
			}
			// no problem or problem solved
			input.push(var);
			numberOfElements ++;
		}
		else throw new IllegalStateException("Queue is full.");
	}
	
	@Override
	public void Dequeue() throws IllegalStateException {
		if(!isEmpty())
		{
			// problem if output is empty
			// solution : refill
			if(output.isEmpty())
			{
				// must refill output
				while(!input.isEmpty()){
					output.push(input.head());
					input.pop();
				}
			}
			// no problem or problem solved
			output.pop();
			numberOfElements--;
		}
		else throw new IllegalStateException("Queue is empty.");
	}
	
	@Override
	public int head() throws IllegalStateException {
		if(!isEmpty())
		{
			// problem is output is empty
			// solution : refill
			if(output.isEmpty())
			{
				// must refill output
				while(!input.isEmpty()){
					output.push(input.head());
					input.pop();
				}
			}
			// no problem or problem solved
			return output.head();
		}
		else throw new IllegalStateException("Queue is empty.");
	}
	
	@Override
	public int back() throws IllegalStateException {
		if(!isEmpty())
		{
			// problem is input is empty
			// solution : refill
			if(input.isEmpty())
			{
				// must refill input
				while(!output.isEmpty())
				{
					input.push(output.head());
					output.pop();
				}
			}
			// no problem or problem solved
			return input.head();
		}
		else throw new IllegalStateException("Queue is empty.");
	}
	
}
