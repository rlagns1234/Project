import java.util.Scanner;
public class UPDOWN {
	public static void main(){
		play1 play1Obj = new play1();
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("플레이어 수를 입력해주세요:");
			if(sc.nextInt() == 1) {
				play1Obj.play1Run();
			}
			sc.close();
		}
	}
}
