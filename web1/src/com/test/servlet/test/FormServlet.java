package com.test.servlet.test;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends CommonServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{	
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		String result = "니가 입력한 그 아이디 : " + id;
		result += "<br>니가 입력한 그 비밀번호 : " + pwd;
		doProcess(response, result);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{	
		HashMap hm = g.fromJson(request.getReader(), HashMap.class);
		String id = (String)hm.get("id");
		String pwd = (String)hm.get("pwd");

		hm.put("msg1", "니가 입력한 그 아이디");
		hm.put("msg2", "니가 입력한 그 비밀번호");
		hm.put("value1", id);
		hm.put("value2", pwd);
		
		String result = g.toJson(hm);
		doProcess(response,result);
	}
}
