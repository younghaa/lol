package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.service.BoardService;
import com.test.service.UserService;

public class BoardServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException{	
		req.setCharacterEncoding("UTF-8");
		//html화면에서 던진 값을 각각 String 변수로 받기 시작
		
		String title1=req.getParameter("title");
		String content1=req.getParameter("content");
		System.out.println(title1+content1);
		
		String command = req.getParameter("command");
			if(command==null){
				return;
			}
			BoardService bs = new BoardService();
			
			if(command.equals("SIGNIN")){
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				String writer = req.getParameter("writer");
				
				System.out.println(title+","+content+","+writer);
				
				HashMap hm = new HashMap();
				hm.put("title", title);
				hm.put("content",content);
				hm.put("writer", writer);
				if(bs.insertBoard(hm)){
					doProcess(resq,"저장 오케");
				}else{
					doProcess(resq,"올바른값을넣그라");
				}
			}else if(command.equals("DELETE")){
				String num =req.getParameter("num");
				HashMap hm = new HashMap();
				hm.put("num", num);
				
				}else if(command.equals("UPDATE")){
					String num=req.getParameter("num");
					System.out.println("업뎃할 글번호 : "+num);
					String title = req.getParameter("title");
					String content=req.getParameter("content");
					String writer=req.getParameter("writer");
					
					HashMap hm = new HashMap();
					hm.put("title", title);
					hm.put("content", content);
					hm.put("writer", writer);
			}else if(command.equals("select")){
				String writer = req.getParameter("writer");
				System.out.println("작성자 : "+writer);
				
				HashMap hm = new HashMap();
				if(writer!=null && !writer.equals("")){
					hm.put("writer","&"+writer+"%");
								}
				List<Map> boardList = bs.selectBoard(hm);
				String result="";
				for(Map m: boardList){
					result+=m.toString();					
				}
				doProcess(resq,result);
			}
				}
	
	public void dePost(HttpServletRequest req, HttpServletResponse reqs) throws IOException{
		
	}

	
	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);
		
	}
}