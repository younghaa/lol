package report.youngha.r0003;

public class ArrayExam6 {
	
	public int[] getArrVar(int[] params){
		int []a=new int[params[0]];
		for(int i=params[1];i<=params[2];i++){
			a[i]=(i+1)*2;
		}
		return a;
		
	}
	public void printArrVar(int[]a){
		for (int i=1;i<=10;i++){
			System.out.println(a[i-1]);
		}
	}
	public static void main(String[] args){
		ArrayExam6 ae=new ArrayExam6();
		int[] params={10,0,9};
		int[] a=ae.getArrVar(params);
		ae.printArrVar(a);
	}
}

// 1부터 100까지의 수 중 임의의 열개의 숫자를 나타내라.
/*	int[] a = new int[10];

	public int[] arrayNum() {

		for (int i = 1; i <= 10; i++) {
			int random = (int) (Math.random() * 100);
			a[10 - i] = random;
		}
		return a;
	}

	public void arrayNum2(int[]a) {
		for (int i = 0; i <= 10; i++) {
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {
		ArrayExam6 ae6= new ArrayExam6();
		int[] a = ae6.arrayNum();
		ae6.arrayNum2(a);
		}
	}*/
		
		


