import java.util.Random;
import java.util.Scanner;
public class player {
	int No;
	String N;
	int attack;
	Random random = new Random();
	int r = random.nextInt(100);
	boolean dead = true;
	
	player(int No){
		this.No = No;
	}
	
	public void sc(Scanner sc) {
		String S = sc.next();
		String[] s = S.split(".");
		int c = Integer.parseInt(s[2]);
		if(s[1].equals("p"+No) && c < 100 && c > 0) {
//			N = Integer.s[1].charAt(1);
			attack = c;
		} else {
			System.out.println("입력값이 틀렸습니다.");
		}
	}
	
	public void die (int A) {
		if(A == r) {
			System.out.println("플레이어"+No+" die");
		} else if(A < r) {
			System.out.println("p"+No+".UP");
		} else if(A > r) {
			System.out.println("p"+No+".DOWN");
		} 
	}
}
