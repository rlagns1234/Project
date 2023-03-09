package Compression;

public class S_Compression {
	String input_String;	//입력 문자열
	String return_String;	//리턴(압축)문자열
	int unit = 1;
	
	//최종 문자열 리턴(함수)
	public String re_String(String input) {
		input_String = input;
		
		for(int n = 2; n < input_String.length()/2; n++) {
			select_String(n);	//최종 리턴 문자열 얻기(함수)
		}
		
		return return_String;
	}
	
	//압축 단위 리턴
	public int re_Unit() {
		return unit;
	}
	
	//2~N/2 크기의 압축 문자열 길이를 비교하여 더 길이가 짧은 문자열을 최종 리턴 문자열에 저장(함수)
	private void select_String(int n) {
		int count_return = input_String.length();	//최종 리턴 문자열의 압축 길이
		
		String test = comp_String(n);	//문자열 압축(함수)
		
		int count = count_String(test);	//현재 압축중인 문자열의 압축 길이
		if(count < count_return) {
			count_return = count;	//현재 압축중인 문자열의 압축 길이를 최종 리턴 문자열의 압축 길이에다 저장
			return_String = test;	//현재 압축중인 문자열을 최종 리턴 문자열에 저장
			unit = n;	//현재 압축중인 문자열의 압축 단위를 최종 리턴 압축 단위에 저장
		}
	}
	
	//믄지열 n만큼의 크기로 압축(함수)
	private String comp_String(int n) {
		String result = ""; //리턴 문자열
		String test = input_String;	//테스트 문자열(슬라이싱)
		String test_back = test;	//테스트 문자열의 슬라이싱 이전 문자열
		int count = 0;	//압축 카운트
		while(true) {
			String comp = test_back.substring(0, n);	//압축 문자열 n크기만큼 설정
			
			//압축 문자열과 테스트 문자열의 대상 문자열이 같다면
			if(comp.equals(test.substring(0, n))) {
				count++;	//카운트 추가
				test_back = test;	//테스트로 초기화
				test = test.substring(n, test_back.length());	//비교한 대상 문자열 없애기
			} else {
				
				//카운트가 1이라면
				if(count == 1) {
					result += test_back.substring(0, 1);	//리턴 문자열에 맨 앞 문자만 추가
					test = test_back.substring(1, test_back.length());	//테스트 문자열의 맨 앞 문자 제거
				}
				
				//카운트가 1보다 크다면
				else if(count > 1) {
					result += count+comp;	//리턴 문자열에 압축한 문자열 추가
				}
				
				test_back = test;	//테스트로 초기화
				count = 0;	//카운트 초기화
				
				//테스트 이전 문자열의 첫번째 문자가 0이라면(더이상 확인할 문자가 없다면)
				if(test_back.substring(0, 1).equals("0")) {
					break;
				}
			}
			
			//테스트의 문자열 길이가 n보다 작다면
			if(test.length() < n) {
				for(int j = 0; j <= n; j++) {
					test += "0";	//n만큼 패딩 추가
				}
			}
			
			//테스트 이전 문자열 길이가 n보다 작다면
			if(test_back.length() < n) {
				for(int j = 0; j <= n; j++) {
					test_back += "0";	//n만큼 패딩 추가
				}
			}
		}
		return result;
	}
	
	//압축된 문자열의 압축 길이 리턴(숫자 노카운트)(함수)
	private int count_String(String s) {
		int count = 0;
		String deletNum = s.replaceAll("\\d", "");	//숫자 제거
		count = deletNum.length();	//숫자 제거한 문자열 길이 카운트
		return count;
	}
}
