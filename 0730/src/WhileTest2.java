
public class WhileTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for (int j = 1; j <= 9; j++) {
//			for (int i = 2; i <= 9; i++) {
//				System.out.print(String.format("%d x %d =%3d\t", i, j, i * j));
//			}
//			System.out.println();
//		}
		int i = 1;
		while (i <= 9) {
			int dan = 2;
			while (dan <= 9) {
				System.out.print(String.format("%d x %d =%3d\t", dan, i, dan * i));
				dan++;
			}
			System.out.println();
			i++;
		}
	}

}
