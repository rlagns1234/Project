import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class play2 {
	public void main (int args) {
		List<player> list = new ArrayList<>();
		for(int i = 0 ; i < args ; i++) {
			player p = new player(i);
			list.add(p);
		}
		
		while(list.size() > 0) {
			for(player p : list) {
				System.out.println("값을 입력해주세요    예)p1.34");
				Scanner sc = new Scanner(System.in);
			}
		}
	}
	
}
