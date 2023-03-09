package t200613;

public class FAO {
	
	private static int Four_Arithmetic_Operations(String ip){
		int result = 0;
		String input = ip;
		int point = 0;
		int a = 0;
		String b = "";
		for(int k = 1; k <= 2; k++){
			for(int i = 0; i < input.length(); i++){
				if(ip.substring(i, i+1).equals("\\D")){
					if(a == 1){
						if(k == 1){
							if(b.contains("*") || b.contains("/")){
								input = input.substring(0, point) + calculate(input.substring(point, i)) + input.substring(i, input.length());
							}
						} else {
							input = input.substring(0, point) + calculate(input.substring(point, i)) + input.substring(i, input.length());
						}
						point += 2;
					} else {
						a = 1;
					}
					b = ip.substring(i, i+1);
				}
			}
		}
		return result;
	}
	
//	private int Repeater(String ip, boolean tf){
//		int result = 0;
//		if(ip.contains("+") || ip.contains("-")){
//			if(tf == true){
//				
//			}
//		} else {
//			
//		}
//		
//		return result;
//	}
	
	private static int calculate(String ip){
		int result = 0;
		String[] s = ip.split("\\D");
		if(ip.contains("*")){
			result = Integer.parseInt(s[0]) * Integer.parseInt(s[1]);
		} else if(ip.contains("/")){
			result = Integer.parseInt(s[0]) / Integer.parseInt(s[1]);
		} else if(ip.contains("+")){
			result = Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
		} else if(ip.contains("-")){
			result = Integer.parseInt(s[0]) - Integer.parseInt(s[1]);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Four_Arithmetic_Operations("5+4*3/2-1"));
	}

}
