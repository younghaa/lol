package report.youngha.r0004;

public class Exam2 {

	public static void main(String[] args) {
		int[] a = new int[5];
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1; //배열값설정
		}
		for (int i = 0; i < 5; i++) { //출력되는숫자범위설정
			System.out.print("a[" + i + "]=" + a[i]+"\t");//i=방번호 a[i]는값
		}
	}
}
