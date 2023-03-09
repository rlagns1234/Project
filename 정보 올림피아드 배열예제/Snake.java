package 개인;
public class Snake {
	int Num;	//정수값
	int x[];	//x인덱스 배열
	int y[];	//y인덱스 배열
	int list[][];	//최종 출력 배열
	public static void main(String[] args) {
		int input = 3;
		Snake s = new Snake(input);
//		s.printIndex();	//x, y 인덱스 출력
		s.printList();	//최종 배열 출력
	}
	
	Snake(int n){
		this.Num = n;	//입력 정수 저장
		x = new int[Num*Num];	//입력값에 맞게 x인덱스 저장 배열 선언
		y = new int[Num*Num];	//입력값에 맞게y인덱스 저장 배열 선언
		list = new int[Num][Num];	//최종 출력 배열 선언;
		inputIndex();	//인덱스 저장
		index();	//값 넣기
	}
	
	//x, y 인덱스 구하는 메소드
	public void inputIndex(){
		int n = Num*Num;	//배열 총 길이 저장
		inputX(n);	//x인덱스 구하기
		inputY(n);	//y인덱스 구하기
	}
	
	//x 인덱스 구하는 메소드
	public void inputX(int n){
		int s = 0;	//배열 인덱스의 최소값
		int e = (int)Math.sqrt(n); //배열 인덱스의 최대값
		int c = 0;	//값을 넣은 개수, 다음번 값을 넣을 배열 인덱스 값
		while(c < n){	//c가 n이하일 동안 반복
			if(e - s == 1){	//e-s가 1이면 == 남은 인덱스가 정가운데 하나 뿐이면
				x[c] = s;	//가운데에 값 넣기
				c++;	//카운트 증가
			}else{
				for(int k = 0; k < 2; k++){	//2번 반복, x,y 값 증가 한번, x,y값 감소 한번
					int abs = 1;	//증가량, 감소량 (증가량 +1)
					int st = s;	//배열 값 넣는 인덱스 시작값
					int en = e;	//배열 값 넣는 인덱스 최종값
					int enIn = e-1; //연속 입력값
					if(k == 1){	//2번째 루프라면
						abs = -1;	//역수
						st = e-1;	//인덱스 역수
						en = s-1;	//인덱스 역수
						enIn = s;	//연속 입력값 역수
					}
					for(int i = st; (i < en)||(i > en); i+=abs){	//i = 시작값, i가 최종값보다 작거나 클때, i+(증가, 감소값)
						x[c] = i;	//배열에 값 넣기
						c++;	//카운트 증가
					}
					int jindex = (e-s)-2;
					if(jindex < 0) jindex = 0;
					for(int j = 0; j < jindex; j++){	//인덱스 수(최종값-시작값) - 2만큼 인덱스 최종값 넣기
						x[c] = enIn;	//배열에 값 넣기
						c++;	//카운트 증가
					}
				}
			}
			s++;	//최소값 증가
			e--;	//최대값 감소
		}
	}
	
	//y 인덱스 구하는 메소드
	public void inputY(int n){
		int s = 0;	//배열 인덱스의 최소값
		int e = (int)Math.sqrt(n); //배열 인덱스의 최대값
		int c = 0;	//값을 넣은 개수, 다음번 값을 넣을 배열 인덱스 값
		int in = (int)Math.sqrt(n);
		while(c < n){	//c가 n이하일 동안 반복
			if(e - s == 1){	//e-s가 1이면 == 남은 인덱스가 정가운데 하나 뿐이면
				y[c] = s;	//가운데에 값 넣기
				c++;	//카운트 증가
			}else{
				for(int k = 0; k < 2; k++){	//2번 반복, x,y 값 증가 한번, x,y값 감소 한번
					int abs = 1;	//증가량, 감소량 (증가량 +1)
					int en = e;	//배열 값 넣는 인덱스 최종값
					int stIn = s; //연속 입력값
					if(k == 1){	//2번째 루프라면
						abs = -1;	//역수
						en = s-1;	//인덱스 역수
						stIn = e-1;	//연속 입력값 역수
					}
					
					for(int i = 0; i < in; i++){	//i < 중복 인덱스 개수 값
						y[c] = stIn;	//배열에 값 넣기
						c++;	//카운트 증가
					}
					
					stIn += abs;
					for(int j = stIn; (j < en-1)||(j > en+1); j+=abs){
						y[c] = j;	//배열에 값 넣기
						c++;	//카운트 증가
					}
				}
			}
			s++;	//최소값 증가
			e--;	//최대값 감소
			in -= 2;	//in 2씩 감소
			if(in < 0){	//in이 0이하면 0으로 고정
				in = 0;
			}
		}
	}
	
	//최종 배열에 값 넣는 메소드
	public void index(){
		int n = Num*Num;	//배열 총 길이 저장
		for(int i = 0; i < n; i++){
			list[x[i]][y[i]] = i+1;	//값 각 인덱스에 맞게 넣기
		}
	}	
	
	//x, y 인덱스 출력 메소드
	public void printIndex(){
		//x 인덱스 출력
		for(int i = 0; i < x.length; i++){
			System.out.print(x[i]+" ");
		}
		System.out.println();
		//y 인덱스 출력
		for(int i = 0; i < y.length; i++){
			System.out.print(y[i]+" ");
		}
		System.out.println();
	}
	
	//최종 배열 출력 메소드
	public void printList(){
		//리스트 출력
		for(int i = 0; i < list.length; i++){
			for(int j = 0; j < list[i].length; j++){
				System.out.print(list[j][i]+"\t");
			}
			System.out.println();
		}
	}
}
