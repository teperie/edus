
public class WrapperTest1 {
	public static void main(String[] args) {
		Integer n = 100; // boxing
		Object obj1 = n; // upcasting
		Object obj11 = 200; // boxing & upcasting

		Object obj2 = "asdf";
		Object obj3 = 'a';
		Object obj4 = 1.3f;

		double d = Double.parseDouble("3.15");
		int nn = Integer.parseInt("1000");
		boolean b = Boolean.parseBoolean("true");
		short s = Short.parseShort("10");
		byte bt = Byte.parseByte("1");
		float f = Float.parseFloat("2.12");
		Long l = Long.parseLong("1231241241212321142");
		char c = Character.toLowerCase('C');
	}
}
