package report.youngha.r0003;

public class ArrayExam5 {

	public static void main(String[] args) {

		System.out.println("로또번호생성기\n중복 숫자는 알아서 바꿔서 찍으세요");
		/*
		 * for (int i = 1; i <= 10; i++) { a[i - 1] = 11 - i; } for (int i = 1;
		 * i <= 10; i++) { System.out.println(a[i - 1]); } for (int i = 1; i <=
		 * 100; i++) { if (i % 10 == 0) { System.out.println(); }
		 */
		int[] a = new int[20];

		for (int i = 0; i < 20; i++) {
			int random = (int) (Math.random() * 45) + 1;
			a[i] = random;
			// System.out.print(a[i] + " ");
			for (int j = i + 1; j >= 0; j--) {
				if (a[j] == a[i] && i != j) {
					j = 0;
					i--;
				}
			}
		}
		for (int i = 0; i < 20; i++) {
			System.out.println((i + 1) + "번째 로또번호는 : " + a[i]);
		}
	}
}

// for (int j=1;j<=i;j++){
// int random2=(int)(Math.random() * 45) + 1;
// if(a[i]==random2){
// }
// }

// }
