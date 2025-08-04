package chapter6;

class Data {
	int num;
}

public class ParamTest1 {

	public static void increment(Data data) {
		data.num++;
	}
	
	public static void increment(int num) {
		num++;
	}
	
	public static void main(String[] args) {
		Data data = new Data();
		data.num = 100;
		
		increment(data.num);
		
		System.out.println(data.num);
		
		increment(data);
		
		System.out.println(data.num);
	}

}
