package report.youngha.r0005;

public class Exam2 {

		public static void main(String[]args){
			Cal[]c=new Cal[5];//Cal(int a)의 배열설정

			for(int i=0;i<c.length;i++){
				c[i]=new Cal(i+1);
				//Cal(int a) {
				//System.out.println(a + "인트형 변수 파라메터 한개를 가진 생성자를 호출하셨네요");
				//}
				//Cal(int a)=Cal(i+1)
			}
			for(int i=0;i<=4;i++){
				System.out.println(c[i].a);//public class Cal {
										   //int a;
										   //}

			}
		}
}
