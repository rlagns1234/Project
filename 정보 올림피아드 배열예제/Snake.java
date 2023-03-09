package ����;
public class Snake {
	int Num;	//������
	int x[];	//x�ε��� �迭
	int y[];	//y�ε��� �迭
	int list[][];	//���� ��� �迭
	public static void main(String[] args) {
		int input = 3;
		Snake s = new Snake(input);
//		s.printIndex();	//x, y �ε��� ���
		s.printList();	//���� �迭 ���
	}
	
	Snake(int n){
		this.Num = n;	//�Է� ���� ����
		x = new int[Num*Num];	//�Է°��� �°� x�ε��� ���� �迭 ����
		y = new int[Num*Num];	//�Է°��� �°�y�ε��� ���� �迭 ����
		list = new int[Num][Num];	//���� ��� �迭 ����;
		inputIndex();	//�ε��� ����
		index();	//�� �ֱ�
	}
	
	//x, y �ε��� ���ϴ� �޼ҵ�
	public void inputIndex(){
		int n = Num*Num;	//�迭 �� ���� ����
		inputX(n);	//x�ε��� ���ϱ�
		inputY(n);	//y�ε��� ���ϱ�
	}
	
	//x �ε��� ���ϴ� �޼ҵ�
	public void inputX(int n){
		int s = 0;	//�迭 �ε����� �ּҰ�
		int e = (int)Math.sqrt(n); //�迭 �ε����� �ִ밪
		int c = 0;	//���� ���� ����, ������ ���� ���� �迭 �ε��� ��
		while(c < n){	//c�� n������ ���� �ݺ�
			if(e - s == 1){	//e-s�� 1�̸� == ���� �ε����� ����� �ϳ� ���̸�
				x[c] = s;	//����� �� �ֱ�
				c++;	//ī��Ʈ ����
			}else{
				for(int k = 0; k < 2; k++){	//2�� �ݺ�, x,y �� ���� �ѹ�, x,y�� ���� �ѹ�
					int abs = 1;	//������, ���ҷ� (������ +1)
					int st = s;	//�迭 �� �ִ� �ε��� ���۰�
					int en = e;	//�迭 �� �ִ� �ε��� ������
					int enIn = e-1; //���� �Է°�
					if(k == 1){	//2��° �������
						abs = -1;	//����
						st = e-1;	//�ε��� ����
						en = s-1;	//�ε��� ����
						enIn = s;	//���� �Է°� ����
					}
					for(int i = st; (i < en)||(i > en); i+=abs){	//i = ���۰�, i�� ���������� �۰ų� Ŭ��, i+(����, ���Ұ�)
						x[c] = i;	//�迭�� �� �ֱ�
						c++;	//ī��Ʈ ����
					}
					int jindex = (e-s)-2;
					if(jindex < 0) jindex = 0;
					for(int j = 0; j < jindex; j++){	//�ε��� ��(������-���۰�) - 2��ŭ �ε��� ������ �ֱ�
						x[c] = enIn;	//�迭�� �� �ֱ�
						c++;	//ī��Ʈ ����
					}
				}
			}
			s++;	//�ּҰ� ����
			e--;	//�ִ밪 ����
		}
	}
	
	//y �ε��� ���ϴ� �޼ҵ�
	public void inputY(int n){
		int s = 0;	//�迭 �ε����� �ּҰ�
		int e = (int)Math.sqrt(n); //�迭 �ε����� �ִ밪
		int c = 0;	//���� ���� ����, ������ ���� ���� �迭 �ε��� ��
		int in = (int)Math.sqrt(n);
		while(c < n){	//c�� n������ ���� �ݺ�
			if(e - s == 1){	//e-s�� 1�̸� == ���� �ε����� ����� �ϳ� ���̸�
				y[c] = s;	//����� �� �ֱ�
				c++;	//ī��Ʈ ����
			}else{
				for(int k = 0; k < 2; k++){	//2�� �ݺ�, x,y �� ���� �ѹ�, x,y�� ���� �ѹ�
					int abs = 1;	//������, ���ҷ� (������ +1)
					int en = e;	//�迭 �� �ִ� �ε��� ������
					int stIn = s; //���� �Է°�
					if(k == 1){	//2��° �������
						abs = -1;	//����
						en = s-1;	//�ε��� ����
						stIn = e-1;	//���� �Է°� ����
					}
					
					for(int i = 0; i < in; i++){	//i < �ߺ� �ε��� ���� ��
						y[c] = stIn;	//�迭�� �� �ֱ�
						c++;	//ī��Ʈ ����
					}
					
					stIn += abs;
					for(int j = stIn; (j < en-1)||(j > en+1); j+=abs){
						y[c] = j;	//�迭�� �� �ֱ�
						c++;	//ī��Ʈ ����
					}
				}
			}
			s++;	//�ּҰ� ����
			e--;	//�ִ밪 ����
			in -= 2;	//in 2�� ����
			if(in < 0){	//in�� 0���ϸ� 0���� ����
				in = 0;
			}
		}
	}
	
	//���� �迭�� �� �ִ� �޼ҵ�
	public void index(){
		int n = Num*Num;	//�迭 �� ���� ����
		for(int i = 0; i < n; i++){
			list[x[i]][y[i]] = i+1;	//�� �� �ε����� �°� �ֱ�
		}
	}	
	
	//x, y �ε��� ��� �޼ҵ�
	public void printIndex(){
		//x �ε��� ���
		for(int i = 0; i < x.length; i++){
			System.out.print(x[i]+" ");
		}
		System.out.println();
		//y �ε��� ���
		for(int i = 0; i < y.length; i++){
			System.out.print(y[i]+" ");
		}
		System.out.println();
	}
	
	//���� �迭 ��� �޼ҵ�
	public void printList(){
		//����Ʈ ���
		for(int i = 0; i < list.length; i++){
			for(int j = 0; j < list[i].length; j++){
				System.out.print(list[j][i]+"\t");
			}
			System.out.println();
		}
	}
}
