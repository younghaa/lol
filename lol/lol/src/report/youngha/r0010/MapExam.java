package report.youngha.r0010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class MapExam extends HashMap {

	public String put(String key){
		if(!containsKey(key)){
			put(key,"test");
			return "잘들어갔어요";
		}
		return "이미있다";
	}

	public String toString(){
		String result="";
		List<String>keys= new ArrayList<>(keySet());
		for (int i=0;i<keys.size();i++){
			String key =keys.get(i);			
			Object value=(Object)this.get(key);
			result += "["+key+","+value+"]";
		}
		if(result.equals("")){
			return "아무것도없다";
		}
		return result;
	}
	public static void main(String[] args) {
		MapExam me = new MapExam();
		me.put("A군", 50);
		me.put("B군", 60);
		System.out.println(me);
	}
}
