package NYPC;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		cooking();
	}
	
	public static void cooking() {
		Scanner sc = new Scanner(System.in);
		int food = 0;
		System.out.println("�Է� ���� : \n3  //����� ������\n" + 
				"6 3 5  //�� ����� ����\n" + 
				"1 1 2  //����µ� �ʿ��� �� ����� ����\n" + 
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
						System.out.println("�Է� ������ ����� ���� �Է��� ����� ���� ���� �ʽ��ϴ�.");
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
			System.out.println("�Է� ������ ���� �ѵ��� 0 �̻�, 100 ���� �Դϴ�.");
		}
		return check;
	}
}
