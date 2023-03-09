package s20191805;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
public class MapEx {
	
	public static void same(Info first, Info second) {
		System.out.println("동일 배차 시간을 찾습니다.\n=============");
		List<List<Integer>> firstTime = put(first);
		List<List<Integer>> secondTime = put(second);
		int count = 0;
		for(List<Integer> i : firstTime) {
			if(secondTime.contains(i)) {
					System.out.println(re(i.get(0), (i.get(1))));
					count++;
			}
		}
		System.out.println("=============");
		if(count == 0) {
			System.out.println("동일한 배차 시간이 없습니다.");
		} else {
			System.out.println("동일 배차 횟수 : "+count+"번");
		}
	}
	
	private static List<List<Integer>> put(Info info) {
		List<List<Integer>> result = new ArrayList<>();
		String[] s = info.FirstTime.split(":");
		int time = number.numberInteger(s[0]);
		int start = number.numberInteger(s[1]);
		for(int i = 0; i < (((number.numberInteger(info.LastTime.split(":")[0])-number.numberInteger(info.FirstTime.split(":")[0]))*60)+(number.numberInteger(info.LastTime.split(":")[1])-number.numberInteger(info.FirstTime.split(":")[1])))/info.Interval; i++) {
			List<Integer> put = new ArrayList<>();
			if(start > 59) {
				start %= 60;
				time++;
			}
			put.add(time);
			put.add(start);
			result.add(put);
			start+=info.Interval;
		}
		return (List<List<Integer>>) result;
	}
	
	private static String re(Integer integers, Integer integers2) {
		String result = "";
		result = (stringint(integers)+":"+stringint(integers2));
		return result;
	}
	
	private static String stringint(Integer integers) {
		String result = "";
		if(integers < 10) {
			result += "0"+integers;
		} else {
			result += integers;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Map <String, Info>infoMap = new HashMap<>();
		infoMap.put("metro", new Info("05:00","07:00",5));
		infoMap.put("bus", new Info("05:05","07:00",6));
		same(infoMap.get("metro"), infoMap.get("bus"));	
	}

}
