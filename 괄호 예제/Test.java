package ��ȣ;

import java.util.LinkedList;

public class Test {
	private  String s;
	private int fp; // ������ȣ ����
	private int pp; // �ѽְ�ȣ ����
	private int ip; // �ҿ�����ȣ ����
	private LinkedList<String> p = new LinkedList<>(); // ���� ����Ʈ
	
	//���� �޼ҵ�
	public void run(String s) {
		this.s = d(s);	//���ڿ� ����, ����
		p.add("0");
		check();	//��ȣ �з�
		fin();		//���
		print();	//���
	}
	
	//���ڿ� ���� �޼ҵ�( '(' , ')' ���� ���� ��� ����)
	private String d(String s) {
		String result = "";
		for(int i = 0; i < s.length(); i++) {
			if((s.charAt(i)+"").equals("(") || (s.charAt(i)+"").equals(")")) {
				result += s.charAt(i);
			}
		}
		//���ڿ� ��ȣ ���� ��� ���� ���� ����
		return result;
	}

	//��ȣ �з� �޼ҵ�
	private void check() {
		while(true) {
			//���� ���� ��ȣ�� ')'�̰� ���� ��ȣ�� '('���
			if(s.substring(0,1).equals(")") && p.getLast().equals("(")) {
				fp += 1;	//������ȣ+1
				p.remove(p.getLast());	//������ȣ ���ÿ��� ����
				s = s.substring(1, s.length());
			} else {
				p.add(s.substring(0,1));	//���ÿ� ���� ��ȣ �߰�
				s = s.substring(1, s.length());
			}
			
			if(s.equals("")) {
				break;
			}
		}
	}
	
	//��� �޼ҵ�
	private void fin() {
		ip += p.size()-1; // �ҿ�����ȣ+���ÿ� ���� ��ȣ ��
		pp = ip / 2; // �ѽְ�ȣ = �ҿ�����ȣ/2
		ip = ip % 2; // �ҿ�����ȣ/2�� �������� ����
	}
	
	//��¸޼ҵ�
	private void print() {
		System.out.println("������ȣ ���� : "+fp);
		System.out.println("�ѽְ�ȣ ���� : "+pp);
		System.out.println("�ҿ�����ȣ ���� : "+ip);
	}
	
}
