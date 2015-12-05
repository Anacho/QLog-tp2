import Model.HanoiTower;
import Model.IllegalStateException;

public class gameHanoiTower {

	public static void main(String[] args) throws IllegalStateException {
		// TODO Auto-generated method stub
		HanoiTower hanoi = new HanoiTower(5);
		hanoi.print();
		hanoi.move(0, 2);
		hanoi.print();
		hanoi.move(0, 1);
		hanoi.print();
	}

}
