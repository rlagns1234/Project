import java.util.Scanner;
public class play1 {

	public void play1Run() {
		player1 p1 = new player1(1);
		while(p1.dead == true) {
			System.out.println("���� �Է����ּ���    ��)p1.34");
			Scanner Sc = new Scanner(System.in);
			p1.sc(Sc);
			if(p1.N == "p"+p1.No) {
				p1.die(p1.attack);
			} else {
				System.out.println("���� �ٽ� �Է����ּ���.  ��)p1.34");
			}
		}
	}
}
