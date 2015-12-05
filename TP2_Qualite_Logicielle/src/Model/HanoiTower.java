package Model;

public class HanoiTower {
	protected Stack[] tower;
	protected int size;
	
	public HanoiTower(int size) throws IllegalStateException
	{
		this.size = size;
		tower = new Stack[3];
		
		for(int i = 0 ; i < 3 ; i++)
		{
			tower[i] = new Stack(size);
		}
		
		for(int i = size; i > 0; i--)
		{
			tower[0].push(i);
		}
	}
	
	public Stack getTower(int i){
		return this.tower[i];
	}
	
	public void move(int towerDepart, int towerArrival) throws IllegalStateException
	{
		if(!tower[towerDepart].isEmpty())
		{
			if(tower[towerArrival].isEmpty())
			{
				tower[towerArrival].push(tower[towerDepart].head());
				tower[towerDepart].pop();
			}
			
			else if(tower[towerDepart].head() < tower[towerArrival].head())
			{
				tower[towerArrival].push(tower[towerDepart].head());
				tower[towerDepart].pop();
			}
			else throw new IllegalStateException("You cannot place a disk on a smaller one. Try something else.");
		}
		else throw new IllegalStateException("Your departure tower is empty, there is no disk to move.");
	}
	
	public boolean checkVictory()
	{
		if(tower[2].isFull())
		{
			Integer[] array = tower[2].getStackInt();
			for(int i = 0; i<size; i++)
			{
				if(array[i] != i+1)
				{
					return false;
				}
			}
			return true;
		}
		else return false;
		
	}
	
	public void print() throws IllegalStateException
	{
		int[] step = { 0, 0, 0};
		for(int j = 0; j < size ; j++)
		{
			System.out.print("||");
			for(int i = 0 ; i < 3 ; i++)
			{
				if(tower[i].getNumberOfElements() - step[i] == size - j)
				{
					System.out.print(tower[i].getStackInt()[step[i]]);
					step[i]++;
				}
				else System.out.print(" ");
				System.out.print("||");
			}
			System.out.println();
		}
	}
}
