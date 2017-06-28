package report.youngha.r0002;

public class Test {

	public void printMultipleTable(int initNum,int maxNum){
		for(int i=initNum;i<=maxNum;i++){
			int a=1;
			for(a=initNum; a<maxNum;a++){
				
				System.out.print(i + " X " + a + " = " + (i*a) + "	");
			}
			System.out.println(i + " X " + a + " = " + (i*a));
		}
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.printMultipleTable(1,5);

			}
}

	
