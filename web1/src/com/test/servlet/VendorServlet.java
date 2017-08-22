package com.test.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.dto.Vendor;
import com.test.service.ServiceFactory;
import com.test.service.VendorService;

public class VendorServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	private VendorService vs;
	private Gson g = new Gson();	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{	
		request.setCharacterEncoding("UTF-8");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");

	    String command = request.getParameter("command");
	    String jsonStr = "";
	    vs = ServiceFactory.getVendorService();
	    if(command.equals("list")){
	    	String viName = request.getParameter("viName");
	    	List<Vendor> vendorList = vs.selectVendorsList(viName);
	    	jsonStr = g.toJson(vendorList);
	    	System.out.println(jsonStr);
//	    	for(Vendor v : vendorList){
//	    		result += "<tr>";
//	    		result += "<td>" + v.getViNum() + "</td>";
//	    		result += "<td>" + v.getViName() + "</td>";
//	    		result += "<td>" + v.getViDesc() + "</td>";
//	    		result += "<td>" + v.getViAddress() + "</td>";
//	    		result += "<td>" + v.getViPhone() + "</td>";
//	    		result += "</tr>";
//	    	}
	    }else if(command.equals("view")){
	    }else if(command.equals("delete")){
	    }else if(command.equals("insert")){
	    }else if(command.equals("xml")){
	        response.setContentType("text/xml");
	        
	        URLConnection conn;
	        BufferedReader br;
	         
	        conn = new URL("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%3D%22USDKRW%22&format=xml&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys").openConnection();
	         
	        br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

	        String line = null;
	        while( (line=br.readLine())!=null ){
	        	jsonStr += line;
	        }
	        System.out.println(jsonStr);
	    }
	    doProcess(response, jsonStr);
	}
	
	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);
		out.close();
	}
}
