package report.youngha.r0003;

public class ArrayExam7 {

	
	public int checkNum(int[] a){
		int random = (int)(Math.random()*45)+1;
		for(int i=0;i<a.length;i++){
			if(a[i]==random){
				random = (int)(Math.random()*45)+1;
				System.out.println(i + ":" + random);
				i=-1;
			}
		}
		return random;
	}
	public static void main(String[] args){
		int[] a = new int[45];
		ArrayExam7 ae5 = new ArrayExam7();
		for(int i=0;i<45;i++){
			a[i] = ae5.checkNum(a);
		}
		
		for(int i=0;i<45;i++){
			for(int j=i+1;j<45;j++){
				if(a[i]<a[j]){
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}

		for(int i=0;i<45;i++){
			System.out.println(i + "번째 로또번호는 : " + a[i]);
		}
	}
}
