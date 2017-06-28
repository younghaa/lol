package report.youngha.r0004;

public class Exam {

	public void printPlusResult(int a,int b){
		System.out.println("더한결과값 : "+(a+b));
	}
	public int getPlusReset(int a,int b){
	return a+b;
	
	}
	public static void main(String[] args){
		Exam e =new Exam();
		e.printPlusResult(1,3);
	int result=e.getPlusReset(1,3); //getPlusReset 호출하여 return값 a+b에 대입 한 결과를 int i에 대입(저장)
		System.out.println("더한결과값 : "+ result);
	}
}
//"더한결과값 : 4" 첫번째 결과값은 a+b만을 출력
//"더한결과값 : 4" 두번째 결과값은 getPlusReset에서 호출한 값을 return a+b에 대입하여 값을 출력