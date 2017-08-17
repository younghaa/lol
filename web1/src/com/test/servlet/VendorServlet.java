package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.dto.Goods;
import com.test.dto.Page;
import com.test.dto.Vendor;
import com.test.service.VendorService;

public class VendorServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	private VendorService vs = new VendorService();
	private Gson g = new Gson();	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{	
		request.setCharacterEncoding("UTF-8");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");

		
		String command = request.getParameter("command");
	    String result="";
	    if(command.equals("list")){
	    	String viName = request.getParameter("viName");
	    	List<Vendor> vendorList = vs.selectVendorsList(viName);
	    	result=g.toJson(vendorList);
/*	    	for(Vendor v : vendorList){
	    		result += "<tr>";
	    		result += "<td>" + v.getViNum() + "</td>";
	    		result += "<td>" + v.getViName() + "</td>";
	    		result += "<td>" + v.getViDesc() + "</td>";
	    		result += "<td>" + v.getViAddress() + "</td>";
	    		result += "<td>" + v.getViPhone() + "</td>";
	    		result += "</tr>";
	    	}*/
	    }else if(command.equals("view")){
	    	
	    }else if(command.equals("delete")){
	    	
	    }else if(command.equals("insert")){
	    	String Vendor = request.getParameter("vendor");
	    	List<Vendor> insertVendor = vs.insertVendor(Vendor);
	    	
	    	result=g.toJson(insertVendor);
	    	
	    }else if(command.equals("update")){
	    }
	    doProcess(response, result);
	}
	
	
	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);
	}
}
