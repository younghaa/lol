package report.youngha.r0013;

public class Plus implements InterfaceExam{

	@Override
	public String getString() {
		
		return "Test의 getString() 함수 호출";
	}

	@Override
	public void setString(String str) {
		System.out.println("Test의 setString()함수 호출!"+str);
		
	}
	
	public int cal(int a, int b){
		return a+b;
	}


}
