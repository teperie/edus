package chapter9;

class Complex {
	int real;
	int imaginary;

	Complex() {
	}

	Complex(int real, int imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Complex) {
			Complex com = (Complex) obj;
			return this.real == com.real && this.imaginary == com.imaginary;
		} else
			return false;

	}

	@Override
	public String toString() {
		return String.format("%d+%di", real, imaginary);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (real * real + imaginary + "").hashCode();
	}
}

public class EqualsTest2 {
	public static void main(String[] args) {
		Complex com1 = new Complex(3, 5);
		Complex com2 = new Complex(3, 5);
		Complex com3 = new Complex(3, 7);
		Complex com4 = new Complex(7, 5);

		System.out.println(com1.equals(com2));
		System.out.println(com1.equals(com3));
		System.out.println(com1.equals(com4));

		System.out.println(com1);
		System.out.println(com2);
		System.out.println(com3);
		System.out.println(com4);

		System.out.println(com1.hashCode());
		System.out.println(com2.hashCode());
		System.out.println(com3.hashCode());
		System.out.println(com4.hashCode());
	}
}
