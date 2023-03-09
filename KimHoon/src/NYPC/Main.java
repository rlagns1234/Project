package NYPC;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		cooking();
	}
	
	public static void cooking() {
		Scanner sc = new Scanner(System.in);
		int food = 0;
		System.out.println("입력 예시 : \n3  //재료의 가짓수\n" + 
				"6 3 5  //각 재료의 개수\n" + 
				"1 1 2  //만드는데 필요한 각 재료의 개수\n" + 
				"");
		int length = sc.nextInt();
		if(check(length) == true) {
			sc.nextLine();
			String[] material = sc.nextLine().split(" ");
			if(check2(material) == true) {
				String[] recipe = sc.nextLine().split(" ");;
				if(check2(recipe) == true) {
					if(material.length == length && recipe.length == length) {
						for(int i = 0; i < length; i++) {
							if(food == 0 || food > ((int)Integer.parseInt(material[i]) / (int)Integer.parseInt(recipe[i]))) {
								food = (int)Integer.parseInt(material[i]) / (int)Integer.parseInt(recipe[i]);
							}
						}
					} else {
						System.out.println("입력 가능한 재료의 수와 입력한 재료의 수가 맞지 않습니다.");
					}
				}
			}
		}
		System.out.println(food);
	}
	
	public static boolean check2(String[] a) {
		boolean check = true;
		for(int i = 0; i < a.length; i++) {
			check = check(Integer.parseInt(a[i]));
			if(check == false) {
				break;
			}
		}
		return check;
	}
	
	public static boolean check(int a) {
		boolean check = true;
		if(a < 0 || a > 100) {
			check = false;
			System.out.println("입력 가능한 숫자 한도는 0 이상, 100 이하 입니다.");
		}
		return check;
	}
}
