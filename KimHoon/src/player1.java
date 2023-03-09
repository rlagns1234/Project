
public class player1 extends player{
	player1(int No) {
		super(No);
	}

	public void die(int A) {
		if(A == r) {
			System.out.println(A+"Á¤´ä!");
		} else if(A < r) {
			System.out.println("UP");
		} else if(A > r) {
			System.out.println("DOWN");
		} 
	}

}
