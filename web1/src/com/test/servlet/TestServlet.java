package com.test.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class TestServlet extends HttpServlet{
	
	private Gson g = new Gson();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{	
		String id= request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println("id : " + id);
		System.out.println("pwd : " + pwd);
		HashMap hm = g.fromJson(request.getReader(), HashMap.class);
		System.out.println(hm);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{	
		HashMap hm = g.fromJson(request.getReader(), HashMap.class);
		System.out.println(hm);
		String id= request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println("id : " + id);
		System.out.println("pwd : " + pwd);
	}
	
}
