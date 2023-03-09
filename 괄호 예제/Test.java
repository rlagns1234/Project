package 괄호;

import java.util.LinkedList;

public class Test {
	private  String s;
	private int fp; // 완전괄호 개수
	private int pp; // 한쌍괄호 개수
	private int ip; // 불완전괄호 개수
	private LinkedList<String> p = new LinkedList<>(); // 스택 리스트
	
	//실행 메소드
	public void run(String s) {
		this.s = d(s);	//문자열 가공, 저장
		p.add("0");
		check();	//괄호 분류
		fin();		//결산
		print();	//출력
	}
	
	//문자열 가공 메소드( '(' , ')' 문자 빼고 모두 제거)
	private String d(String s) {
		String result = "";
		for(int i = 0; i < s.length(); i++) {
			if((s.charAt(i)+"").equals("(") || (s.charAt(i)+"").equals(")")) {
				result += s.charAt(i);
			}
		}
		//문자열 괄호 뺴고 모두 삭제 로직 구현
		return result;
	}

	//괄호 분류 메소드
	private void check() {
		while(true) {
			//만약 현재 괄호가 ')'이고 이전 괄호가 '('라면
			if(s.substring(0,1).equals(")") && p.getLast().equals("(")) {
				fp += 1;	//완전괄호+1
				p.remove(p.getLast());	//이전괄호 스택에서 제거
				s = s.substring(1, s.length());
			} else {
				p.add(s.substring(0,1));	//스택에 현재 괄호 추가
				s = s.substring(1, s.length());
			}
			
			if(s.equals("")) {
				break;
			}
		}
	}
	
	//결산 메소드
	private void fin() {
		ip += p.size()-1; // 불완전괄호+스택에 남은 괄호 수
		pp = ip / 2; // 한쌍괄호 = 불완전괄호/2
		ip = ip % 2; // 불완전괄호/2의 나머지만 저장
	}
	
	//출력메소드
	private void print() {
		System.out.println("완전괄호 개수 : "+fp);
		System.out.println("한쌍괄호 개수 : "+pp);
		System.out.println("불완전괄호 개수 : "+ip);
	}
	
}
