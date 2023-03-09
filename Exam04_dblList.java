package pkg_20190511;

import java.util.ArrayList;
import java.util.List;

public class Exam04_dblList {

	public static void main(String[] args) {
		// 아래와 같이 1~9사이의 정수가 특수문자들과 함께 연결된 문자열이 있다.
		// $4#3@!3%17&78*883^7772#47$15^^63#12%22$9*23#
		
		// 4) 특수문자를 제거하고 남은 정수 문자열을
		// 	 	 NxN형태의 2차원 리스트로 초기화해 리턴하는 함수를 구현
		//		 NxN형태로 초기화 하기 위해 남은 문자열은 버린다.
		/**
		 * 특수문자 제거 : 43317 78883 77724 71563 12229 23
		 * 위의 27개의 문자열을 NxN형태로 초기화한 이중리스트
		 * 	4	3	3	1	7
				7	8	8	8	3
				7	7	7	2	4
				7	1	5	6	3
				1	2	2	2	9
		 */
		// 입력(String) : 위 문자열
		// 출력(List<List<Integer>>) : 위 2차원 배열
		List<List<Integer>> result = makeDblList("$4#3@!3%17&78*883^7772#47$15^^63#12%22$9*23#");
		System.out.println(result);
		replaceList(result);
		System.out.println(result);
	}
	
	static List<List<Integer>> makeDblList(String input) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		String st = "";
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) > 47 && input.charAt(i) < 58) {
				st += input.substring(i,i+1);
			}
		}
		int lenght = (int) Math.sqrt(st.length());
		int a = 0;
		
		for(int i = 0; i < lenght; i++) {
			List<Integer> num = new ArrayList<Integer>();
			for(int j = 0; j < lenght; j++) {
				num.add( st.charAt(a)-48);
				a++;
			}
			result.add(num);
		}
		return result;
	}
	
	static List<List<Integer>> replaceList(List<List<Integer>> input) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int num = 0; //지금은 안씀
		for(List list : input) {
			for(int i = 0; i < list.size(); i++) {
				int a = 0;
				for(int j = 0; j < list.size(); j++) {
					if(list.get(i) == list.get(j)) {
						a++;
					}
				}
				if(a > 2) {
					int n = (Integer) list.get(i);
					for(int k = 0; k < list.size(); k++) {
						if(n == (Integer)list.get(k)) {
							list.set(k, (Integer)list.get(k)*-1);
						}
					}
				}
			}
			result.add(list);
			num++; //지금은 안씀
		}
		
//		List<Integer> copy = new ArrayList<Integer>();
//		for(int t = 0; t < input.size(); t++) {
//			for(List list2 : result) {
//				copy.add((Integer) list2.get(t));
//			}
//			for(int l = 0; l <copy.size(); l++) {
//				int c = 0;
//				for(int q = l+1; q < copy.size(); q++) {
//					if(copy.get(l) == Math.abs(copy.get(q))) {
//						c++;
//					}
//				}
//				if(c > 2) {
//					for(int r = 0; r < copy.size(); r++) {
//						if(copy.get(l) == Math.abs(copy.get(r))) {
//							copy.set(r, 0);
//						}
//					}
//					copy.set(l, 0);
//				}
//			}
//			int o = 0;
//			for(List list3 : input) {
//				list3.set(t, copy.get(o));
//				o++;
//				result.set(t, list3);
//			}
//		}
//		
//		int f = 0;
//		for(List list4 : result) {
//			for(int p = 0; p < result.size(); p++) {
//				int e = (Integer) list4.get(p);
//				if(e < 0) {
//					list4.set(p, 0);
//				}
//			}
//			result.set(f, list4);
//			f++;
//		}
		return result;
	}
	
}
