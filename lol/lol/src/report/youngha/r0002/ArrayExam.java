package report.youngha.r0002;

public class ArrayExam {

	public void printMultipleTable(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				System.out.print(b[j] + " X " + a[i] + " = " + (a[i] * b[j]) + "	");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ArrayExam ae = new ArrayExam();
		ae.printMultipleTable(a, b);
	}
}
