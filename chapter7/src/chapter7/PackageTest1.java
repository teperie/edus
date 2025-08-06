package chapter7;

import pac.MyClass;

public class PackageTest1 {

	public static void main(String[] args) {
		MyClass my = new MyClass();

		pac.MyClass mc = new pac.MyClass();
		mc.getClass();
	}

}
