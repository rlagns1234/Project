package 개인;

import java.util.Stack;

public class Tower_of_Hanoi {
	/*
	public Element push(Element item); // 데이터 추가
	public Element pop(); // 최근에 추가된(Top) 데이터 삭제
	public Element peek(); // 최근에 추가된(Top) 데이터 조회
	public boolean empty(); // stack의 값이 비었는지 확인, 비었으면 true, 아니면 false
	public int seach(Object o); // 인자값으로 받은 데이터의 위치 반환, 그림으로 설명하겠음
	 */
	int Num;
	@SuppressWarnings("rawtypes")
	Stack[] t = {new Stack<>(), new Stack<>(), new Stack<>()};	//스택 배열 선언
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
		System.out.println("하노이의 탑\n원반 개수 : "+Num+"\n");
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
				//맨 처음 실행할 때 1의 위치를 정해주는 조건문
				if(st == false){
					t[0].pop();	//원래 위치에서 1 지우기
					if(Num % 2 == 0){	//숫자의 개수가 짝수라면
						t[1].push(i);	//2번째 탑에 1 넣기
					} else {	//숫자의 개수가 홀수라면
						t[2].push(i);	//3번쨰 탑에 1 넣기
					}
					print();
					count++;
					st = true;	//시작 조건 비활성화
					continue;	//for문 넘기기
				}
				
				int move = -1;
				int ser[] = serch(i);
				//올라갈 수 있는 원반이 있는지 찾아서 움직일 탑으로 지정
				for(int j = 1; j < ser.length; j++){
					if(t[ser[0]].peek().equals(i)){
						//비어있는 탑이 있는지 찾아서 움직일 탑이 정해지지 않았다면 움직일 탑으로 지정
						if(t[ser[j]].empty()){
							if(move == -1){
								move = ser[j];
							}
							continue;
						}
						//움직일 값이 움직일 탑의 맨 위에 있는 값보다 작다면
						if((int)t[ser[0]].peek() < (int)t[ser[j]].peek()){
							//움직일 값과 움직일 탑의 맨 위에 있는 값 둘 다 짝수, 홀수로 겹치지 않는다면
							if(!((int)t[ser[0]].peek() % 2 == 0 && (int)t[ser[j]].peek() % 2 == 0) &&
									!((int)t[ser[0]].peek() % 2 != 0 && (int)t[ser[j]].peek() % 2 != 0)){
								move = ser[j];
							}
						}
					}
				}
				//값을 움직일 수 있다면 움직이기
				if(move != -1){
					t[ser[0]].pop();
					t[move].push(i);
					print();
					count++;
				} 
			}
		}
	}
	
	//현재 움직여야할 숫자가 있는 탑을 찾는 함수
	private int[] serch(int j){
		int result[] = new int[3];
		int k = 1;
		for(int i = 0; i < 3; i++){
			if(t[i].empty()){	//탑이 비어있을 시
				result[k++] = i;	//배열 첫번째가 아닌 칸에 대입
				continue;
			}
			if(t[i].contains(j)){	//찾아야하는 값과 탑[i]의 첫번째 값이 같을 시
				result[0] = i;	//배열 첫번쨰 칸에 대입
			} else {
				result[k++] = i;
			}
		}
		return result;
	}
	
	//게임이 끝났는지 판단하는 조건
	private boolean end(){
		boolean result = false;
		int n = Num;
		for(int i = 0; i < Num; i++){
			if(t[2].empty()){	//탑이 비어있으면 진행
				result = true;
				break;
			}
			if(t[2].size() < i+1){	//탑이 채워지지 않았다면 진행
				result = true;
				break;
			}
			if(t[2].get(i).equals(n)){	//탑이 채워지고 순서가 맞다면 끝냄
				n--;
			} else {
				result = true;
			}
		}
		if(result == false){
			System.out.println("이동 횟수 : "+count);
		}
		return result;
	}
	
	//현재 진행 상황 출력
	@SuppressWarnings("rawtypes")
	private void print(){
		int[][] p = new int[Num][Num];
		int n = 0;
		int n2 = Num-1;
		//스택에서 값을 순서대로 빼와서 배열에 y값 역순으로 대입 (없으면 0으로 대체)
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
		
		//배열 출력 (0이면 출력 안함)
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
