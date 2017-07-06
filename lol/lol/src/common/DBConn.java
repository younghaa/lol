package common;

public class DBConn {
			static int a;
			int getInt() throws Exception{
				int a = Integer.parseInt("str");
				return a;
			}
			public static void main(String[]args){
				DBConn bdc = new DBConn();
				try {
					int a = bdc.getInt();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
