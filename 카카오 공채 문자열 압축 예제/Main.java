package Compression;

public class Main {
	public static void main(String[] args) {
		String input = "ababcdcdababcdcd";	//입력값
		String result = "";							//결과값
		
		S_Compression Compression_Module = new S_Compression();	//압축 모듈 선언
		result = Compression_Module.re_String(input);			//실행, 결과값 받기
		
		System.out.println(result);									//결과값 출력
		System.out.println("압축 단위 : "+Compression_Module.re_Unit());	//압축단위 출력
	}
}
