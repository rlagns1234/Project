package s20191805;

public class Info {
	String FirstTime;
	String LastTime;
	int Interval;
	Info(String f, String l, int i){
		this.FirstTime = f;
		this.LastTime = l;
		this.Interval = i;
	}
	public void printAll() {
		System.out.println(FirstTime);
		System.out.println(LastTime);
		System.out.println(Interval);
	}
}
