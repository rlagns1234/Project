package Compression;

public class Main {
	public static void main(String[] args) {
		String input = "ababcdcdababcdcd";	//�Է°�
		String result = "";							//�����
		
		S_Compression Compression_Module = new S_Compression();	//���� ��� ����
		result = Compression_Module.re_String(input);			//����, ����� �ޱ�
		
		System.out.println(result);									//����� ���
		System.out.println("���� ���� : "+Compression_Module.re_Unit());	//������� ���
	}
}
