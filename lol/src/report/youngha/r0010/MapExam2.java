package report.youngha.r0010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapExam2 extends HashMap<String,Integer> {
//HashMap을 상속받아주세요
//키타입 String,벨류타입 Integer로 선언
//키는 아무거나 넣어도 됨 벨류는 반드시 숫자만입력
//총 10개의 키값을 생성.
//toString()함수를 오버라이딩 해서
//해당 해쉬맵이 가지고있는 전체 숫자를 더한 값을 출력해주세요.
	public String toString(){
		String result="";
		List<String> keyList = new ArrayList<>(keySet());
		int sum=0;
		for(int i=0;i<keyList.size();i++){
			String key=keyList.get(i);
			sum+=get(key);
		}
		result+=sum;
		return result;
	}
	public static void main(String[]args){
		MapExam2 me2=new MapExam2();
		for(int i=0;i<=10;i++){
		me2.put(""+i,i);
		}
		System.out.println(me2);
	
	}
	}