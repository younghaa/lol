package report.youngha.r0003;

public class ArrayExam4 {

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 1; i <= 10; i++) {
			a[10-i] = i * 2;
		}
		for (int i = 1; i <= 10; i++) {
			System.out.println(a[i-1]);
		}
	}
}
