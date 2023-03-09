package NYPC;

import java.util.Scanner;

public class Practice_problem_1 {

	public static boolean checkPassword1(String pw) {
		boolean result = false;
		if(pw.length() > 7 && pw.length() < 16) {
			if(pw.matches("(?=.*[A-Z]).*")) {	
				if(pw.matches("(?=.*[a-z]).*")) {	
					if(pw.matches("(?=.*[0-9]).*")) {	
						if(pw.matches("(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\\\"\\|,.<>\\/?~`]).*")) {	
//						if(pw.matches("[!@#$%^&*\\(\\)-=_+\\|;:'\"/?,.<>~\\[\\]\\{\\}\\`]*")) {
							result = true;
						}
					}
				}
			}
		}
		
		if(result == true) {
			System.out.println("valid");
		} else {
			System.out.println("invalid");
		}
		return result;
	}

	public static boolean checkPassword(String pw) {
		boolean result = false;
		if(pw.matches("(?=.*[A-Z]+)(?=.*[a-z]+){8,15}")) {	
//			if(pw.matches("(?=.*[A-Z])(?=.*[a-z]).*")) {	
//					if(pw.matches("(?=.*[0-9]).*")) {	
//						if(pw.matches("(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\\\"\\|,.<>\\/?~`]).*")) {	
							result = true;
//						}
//					}
//			}
		}
		
		if(result == true) {
			System.out.println("valid");
		} else {
			System.out.println("invalid");
		}
		return result;
	}

	public static void testCase() {
		checkPassword("NZYP");
		checkPassword("NZYPCADFFJJCADFFJJCADFFJJ");
		checkPassword("NZYPCADFFJJ");
		checkPassword("NzYPCADFFJJ");
		checkPassword("N1YPCADFFJJ");
		checkPassword("Nz1YPCADFFJJ");
		checkPassword("N{z1YPCADFFJJ");
		//checkPassword("{NYPC2019}");
		//checkPassword("{NyPC2019}");
		//checkPassword("{NyPC}");
	}
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//String pw = sc.next();
		//checkPassword(pw);
		testCase();
	}
	
}
