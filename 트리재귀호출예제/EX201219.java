import java.util.LinkedList;


public class EX201219 {
	public static LinkedList<String[]> l = new LinkedList<String[]>();

	public static void main(String[] args) {
		String input[] = {"A","B","C"};
		tree(input, 0);
		
	}
	
	public static void tree(String input[], int n){
		for(int i = n; i < input.length; i++){
			String ex[] = change(input, n, i);
			if(l.contains(ex)){	//���� eq�Լ��� ��ü
				continue;
			} else {
				l.add(ex);
				tree(ex, i);
			}
		}
	}
	
	public static String[] change(String input[], int n1, int n2){
		String result[] = input;
		String temp = result[n1];
		result[n1] = result[n2];
		result[n2] = temp;
		return result;
	}
	
	public static boolean eq(String[] input){
		boolean result = false;
		for(int i = 0; i < l.size(); i++){
			//for������ ����Ʈ ��� �ϳ��� ���ͼ� ��ǲ�� ���ϴ� ���� ����
		}
		return result;
	}
}
