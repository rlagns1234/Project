package s20191805;
import java.util.Random;
import javax.swing.JOptionPane;
public class numberbaseball {
	public static void main(String[] args) {
		numberbaseball();
	}
	
	public static void numberbaseball() {
		Random random = new Random();
		int R = random.nextInt(1000);
		while(R < 99) {
			R = random.nextInt(1000);
		}
		int a = 0;
		while(true) {
			int r[] = new int[] {R/100, (R%100)/10, R%10};
			String s = "";
			String b = "";
			int sc = 0;
			int bc = 0;
			String S = JOptionPane.showInputDialog("세자리수 숫자 입력");
			int number = s20191805.number.numberInteger(S);
			int input[] = new int[] {number/100, (number%100)/10, number%10};
			if(number == R) {
				System.out.println(number+" - 3스트라이크");
				break;
			} else {
				for(int i = 0; i < r.length; i++) {
					if(r[i] == input[i]) {
						++sc;
						s = sc+"스트라이크";
						r[i] = -1; input[i] = -2;
					}
				}
				
				for(int j = 0; j < input.length; j++) {
					for(int k = 0; k < r.length; k++) {
						if(r[k] != -1) {
							if(input[j] == r[k]) {
								++bc;
								b = bc+"볼";
								r[k] = -1; input[j] = -2;
							}
						}
					}
				}
				System.out.println(number+" - "+s+" "+b);
			}
			a++;
		}
		System.out.println("도전 횟수 : "+a);
	}
}
