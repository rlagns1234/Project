package Compression;

public class S_Compression {
	String input_String;	//�Է� ���ڿ�
	String return_String;	//����(����)���ڿ�
	int unit = 1;
	
	//���� ���ڿ� ����(�Լ�)
	public String re_String(String input) {
		input_String = input;
		
		for(int n = 2; n < input_String.length()/2; n++) {
			select_String(n);	//���� ���� ���ڿ� ���(�Լ�)
		}
		
		return return_String;
	}
	
	//���� ���� ����
	public int re_Unit() {
		return unit;
	}
	
	//2~N/2 ũ���� ���� ���ڿ� ���̸� ���Ͽ� �� ���̰� ª�� ���ڿ��� ���� ���� ���ڿ��� ����(�Լ�)
	private void select_String(int n) {
		int count_return = input_String.length();	//���� ���� ���ڿ��� ���� ����
		
		String test = comp_String(n);	//���ڿ� ����(�Լ�)
		
		int count = count_String(test);	//���� �������� ���ڿ��� ���� ����
		if(count < count_return) {
			count_return = count;	//���� �������� ���ڿ��� ���� ���̸� ���� ���� ���ڿ��� ���� ���̿��� ����
			return_String = test;	//���� �������� ���ڿ��� ���� ���� ���ڿ��� ����
			unit = n;	//���� �������� ���ڿ��� ���� ������ ���� ���� ���� ������ ����
		}
	}
	
	//������ n��ŭ�� ũ��� ����(�Լ�)
	private String comp_String(int n) {
		String result = ""; //���� ���ڿ�
		String test = input_String;	//�׽�Ʈ ���ڿ�(�����̽�)
		String test_back = test;	//�׽�Ʈ ���ڿ��� �����̽� ���� ���ڿ�
		int count = 0;	//���� ī��Ʈ
		while(true) {
			String comp = test_back.substring(0, n);	//���� ���ڿ� nũ�⸸ŭ ����
			
			//���� ���ڿ��� �׽�Ʈ ���ڿ��� ��� ���ڿ��� ���ٸ�
			if(comp.equals(test.substring(0, n))) {
				count++;	//ī��Ʈ �߰�
				test_back = test;	//�׽�Ʈ�� �ʱ�ȭ
				test = test.substring(n, test_back.length());	//���� ��� ���ڿ� ���ֱ�
			} else {
				
				//ī��Ʈ�� 1�̶��
				if(count == 1) {
					result += test_back.substring(0, 1);	//���� ���ڿ��� �� �� ���ڸ� �߰�
					test = test_back.substring(1, test_back.length());	//�׽�Ʈ ���ڿ��� �� �� ���� ����
				}
				
				//ī��Ʈ�� 1���� ũ�ٸ�
				else if(count > 1) {
					result += count+comp;	//���� ���ڿ��� ������ ���ڿ� �߰�
				}
				
				test_back = test;	//�׽�Ʈ�� �ʱ�ȭ
				count = 0;	//ī��Ʈ �ʱ�ȭ
				
				//�׽�Ʈ ���� ���ڿ��� ù��° ���ڰ� 0�̶��(���̻� Ȯ���� ���ڰ� ���ٸ�)
				if(test_back.substring(0, 1).equals("0")) {
					break;
				}
			}
			
			//�׽�Ʈ�� ���ڿ� ���̰� n���� �۴ٸ�
			if(test.length() < n) {
				for(int j = 0; j <= n; j++) {
					test += "0";	//n��ŭ �е� �߰�
				}
			}
			
			//�׽�Ʈ ���� ���ڿ� ���̰� n���� �۴ٸ�
			if(test_back.length() < n) {
				for(int j = 0; j <= n; j++) {
					test_back += "0";	//n��ŭ �е� �߰�
				}
			}
		}
		return result;
	}
	
	//����� ���ڿ��� ���� ���� ����(���� ��ī��Ʈ)(�Լ�)
	private int count_String(String s) {
		int count = 0;
		String deletNum = s.replaceAll("\\d", "");	//���� ����
		count = deletNum.length();	//���� ������ ���ڿ� ���� ī��Ʈ
		return count;
	}
}
