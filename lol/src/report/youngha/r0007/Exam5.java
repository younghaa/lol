package report.youngha.r0007;

public class Exam5 {

	public static void main(String[] args){
		long[] a = new long[11];
		for( int i=0;i<=10;i++){
			a[i] = (long)Math.pow(10,i);
			if(i!=0){
				a[i] += a[i-1];
			}
		}

		for( int i=0;i<=10;i++){
			System.out.println(a[i]);
		}
		
	}
}