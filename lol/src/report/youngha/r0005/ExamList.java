package report.youngha.r0005;

import java.util.ArrayList;
import java.util.List;

public class ExamList {
	public static void main(String[]args){
		ArrayList<Cal> list = new ArrayList<Cal>();//데이터가 차례대로 공간을 생성하여 저장됨
		for(int i =0;i<3;i++){
		Cal c = new Cal(i);
		list.add(c);//최초 데이터입력 0번방
		}
		for(int i =0;i<3;i++){
		Cal c2 = list.get(i);
		System.out.println(c2.a);

	}
}
}