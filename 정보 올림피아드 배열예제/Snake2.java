package ����;

public class Snake2 extends Snake {
	int pad;
	
	public static void main(String[] args) {
		int input = 5;	//�Է°�
		int padding = 3;	//�е� ��
		Snake2 s2 = new Snake2(input, padding);	//��ü ����
		s2.run();
//		s2.printIndex();	//x, y �ε��� ���
		s2.printList();	//���� �迭 ���
	}
	Snake2(int n, int p) {
		super(n);
		pad = p;	//�е� �� ����
	}
	
	public void index(){
		int in = pad-1;	//�е� ������ �е�-1(�迭 �ε���ȭ) ����
		for(int i = 0; i < Num*Num; i++){
			//�е������� �迭 ���̺��� ���� ������������ �ݺ�
			while(in >= Num*Num){
				in = (in)-Num*Num;	//�������õ� �е������� ������ �迭 ���̸�ŭ ����
			}
			list[x[in]][y[in]] = i+1;	//����Ʈ�� �� �ֱ�
			in += pad;	//�е������� �е���ŭ �� ����
		}
	}
}
