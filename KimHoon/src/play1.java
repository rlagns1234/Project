import java.util.Scanner;
public class play1 {

	public void play1Run() {
		player1 p1 = new player1(1);
		while(p1.dead == true) {
			System.out.println("값을 입력해주세요    예)p1.34");
			Scanner Sc = new Scanner(System.in);
			p1.sc(Sc);
			if(p1.N == "p"+p1.No) {
				p1.die(p1.attack);
			} else {
				System.out.println("값을 다시 입력해주세요.  예)p1.34");
			}
		}
	}
}
