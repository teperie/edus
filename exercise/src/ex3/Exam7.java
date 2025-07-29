package ex3;

public class Exam7 {
	public static void main(String[] args) {
		int fahrenheit = 100;
		float celcius = 5f / 9 + (fahrenheit - 32);
		System.out.println("Farenheit: " + fahrenheit);
		System.out.println("Celcius: " + ((int)(celcius * 100 + 0.5)) / 100f);

	}

}
