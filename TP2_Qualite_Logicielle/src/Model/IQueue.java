package Model;

public interface IQueue {
	public void Enqueue(int var) throws IllegalStateException;
	public void Dequeue() throws IllegalStateException;
	public int head() throws IllegalStateException;
	int getNumberOfElements();
	int getSize();
	boolean isFull();
	boolean isEmpty();
	int back() throws IllegalStateException;
}
