package ����;

import java.util.Stack;

public class Tower_of_Hanoi {
	/*
	public Element push(Element item); // ������ �߰�
	public Element pop(); // �ֱٿ� �߰���(Top) ������ ����
	public Element peek(); // �ֱٿ� �߰���(Top) ������ ��ȸ
	public boolean empty(); // stack�� ���� ������� Ȯ��, ������� true, �ƴϸ� false
	public int seach(Object o); // ���ڰ����� ���� �������� ��ġ ��ȯ, �׸����� �����ϰ���
	 */
	int Num;
	@SuppressWarnings("rawtypes")
	Stack[] t = {new Stack<>(), new Stack<>(), new Stack<>()};	//���� �迭 ����
	boolean st = false;
	int count = 0;
	
	public static void main(String[] args) {
		int n = 5;
		Tower_of_Hanoi h = new Tower_of_Hanoi();
		h.play(n);
	}
	
	@SuppressWarnings("unchecked")
	public void start(int n){
		Num = n;
		System.out.println("�ϳ����� ž\n���� ���� : "+Num+"\n");
		st = false;
		for(int i = Num; i > 0; i--){
			t[0].push(i);
		}
		print();
	}
	
	@SuppressWarnings("unchecked")
	public void play(int n){
		start(n);
		while(end()){
			for(int i = 1; i <= Num; i++){
				//�� ó�� ������ �� 1�� ��ġ�� �����ִ� ���ǹ�
				if(st == false){
					t[0].pop();	//���� ��ġ���� 1 �����
					if(Num % 2 == 0){	//������ ������ ¦�����
						t[1].push(i);	//2��° ž�� 1 �ֱ�
					} else {	//������ ������ Ȧ�����
						t[2].push(i);	//3���� ž�� 1 �ֱ�
					}
					print();
					count++;
					st = true;	//���� ���� ��Ȱ��ȭ
					continue;	//for�� �ѱ��
				}
				
				int move = -1;
				int ser[] = serch(i);
				//�ö� �� �ִ� ������ �ִ��� ã�Ƽ� ������ ž���� ����
				for(int j = 1; j < ser.length; j++){
					if(t[ser[0]].peek().equals(i)){
						//����ִ� ž�� �ִ��� ã�Ƽ� ������ ž�� �������� �ʾҴٸ� ������ ž���� ����
						if(t[ser[j]].empty()){
							if(move == -1){
								move = ser[j];
							}
							continue;
						}
						//������ ���� ������ ž�� �� ���� �ִ� ������ �۴ٸ�
						if((int)t[ser[0]].peek() < (int)t[ser[j]].peek()){
							//������ ���� ������ ž�� �� ���� �ִ� �� �� �� ¦��, Ȧ���� ��ġ�� �ʴ´ٸ�
							if(!((int)t[ser[0]].peek() % 2 == 0 && (int)t[ser[j]].peek() % 2 == 0) &&
									!((int)t[ser[0]].peek() % 2 != 0 && (int)t[ser[j]].peek() % 2 != 0)){
								move = ser[j];
							}
						}
					}
				}
				//���� ������ �� �ִٸ� �����̱�
				if(move != -1){
					t[ser[0]].pop();
					t[move].push(i);
					print();
					count++;
				} 
			}
		}
	}
	
	//���� ���������� ���ڰ� �ִ� ž�� ã�� �Լ�
	private int[] serch(int j){
		int result[] = new int[3];
		int k = 1;
		for(int i = 0; i < 3; i++){
			if(t[i].empty()){	//ž�� ������� ��
				result[k++] = i;	//�迭 ù��°�� �ƴ� ĭ�� ����
				continue;
			}
			if(t[i].contains(j)){	//ã�ƾ��ϴ� ���� ž[i]�� ù��° ���� ���� ��
				result[0] = i;	//�迭 ù���� ĭ�� ����
			} else {
				result[k++] = i;
			}
		}
		return result;
	}
	
	//������ �������� �Ǵ��ϴ� ����
	private boolean end(){
		boolean result = false;
		int n = Num;
		for(int i = 0; i < Num; i++){
			if(t[2].empty()){	//ž�� ��������� ����
				result = true;
				break;
			}
			if(t[2].size() < i+1){	//ž�� ä������ �ʾҴٸ� ����
				result = true;
				break;
			}
			if(t[2].get(i).equals(n)){	//ž�� ä������ ������ �´ٸ� ����
				n--;
			} else {
				result = true;
			}
		}
		if(result == false){
			System.out.println("�̵� Ƚ�� : "+count);
		}
		return result;
	}
	
	//���� ���� ��Ȳ ���
	@SuppressWarnings("rawtypes")
	private void print(){
		int[][] p = new int[Num][Num];
		int n = 0;
		int n2 = Num-1;
		//���ÿ��� ���� ������� ���ͼ� �迭�� y�� �������� ���� (������ 0���� ��ü)
		for(int i = 0; i < Num; i++){
			for(Stack k : t){
				if(k.empty()){
					p[n][n2] = 0;
				} if(k.size() < i+1) {
					p[n][n2] = 0;
				} else {
					p[n][n2] = (int)k.get(i);
				}
				n++;
			}
			n = 0;
			n2--;
		}
		
		//�迭 ��� (0�̸� ��� ����)
		for(int i = 0; i < Num; i++){
			for(int j = 0; j < 3; j++){
				if(p[j][i] != 0){
					System.out.print(p[j][i]);
				}
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println("=\t=\t=\n");
	}
}
