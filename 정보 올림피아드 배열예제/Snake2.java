package 개인;

public class Snake2 extends Snake {
	int pad;
	
	public static void main(String[] args) {
		int input = 5;	//입력값
		int padding = 3;	//패딩 값
		Snake2 s2 = new Snake2(input, padding);	//객체 선언
		s2.run();
//		s2.printIndex();	//x, y 인덱스 출력
		s2.printList();	//최종 배열 출력
	}
	Snake2(int n, int p) {
		super(n);
		pad = p;	//패딩 값 저장
	}
	
	public void index(){
		int in = pad-1;	//패딩 변수에 패딩-1(배열 인덱스화) 저장
		for(int i = 0; i < Num*Num; i++){
			//패딩변수가 배열 길이보다 값이 낮아질때까지 반복
			while(in >= Num*Num){
				in = (in)-Num*Num;	//오버슈팅된 패딩변수의 값에서 배열 길이만큼 차감
			}
			list[x[in]][y[in]] = i+1;	//리스트에 값 넣기
			in += pad;	//패딩변수를 패딩만큼 더 증감
		}
	}
}
