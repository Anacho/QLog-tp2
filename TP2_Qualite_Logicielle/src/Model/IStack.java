package Model;

public interface IStack {
	public int getSize();
	public int getNumberOfElements();
	public boolean isFull();
	public boolean isEmpty();
	public void push(int x) throws IllegalStateException;
	public int head() throws IllegalStateException;
	public void pop() throws IllegalStateException;
}
