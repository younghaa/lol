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

import com.test.service.UserService;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");

		String name1 = req.getParameter("name");
		String pwd1 = req.getParameter("pass");
		System.out.println("input html에서 너님이 던진값 =>" + name1 + pwd1);

		// html화면에서 던진 값을 각각 String 변수로 받기 시작
		String command = req.getParameter("command");
		if (command == null) {
			return;
		}
		// UserService에 있는 insertUser(HashMap hm)이라는 함수를 호출하기 위해
		// UserService로 us 레퍼런스 변수를 생성
		UserService us = new UserService();
		if (command.equals("SIGNIN")) {
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String class_num = req.getParameter("class_num");
			String age = req.getParameter("age");

			// 위에서 받은 String 변수를 출력해줌(Tomcat 콘솔창에)
			System.out.println(id + "," + pwd + "," + name + "," + class_num + ", " + age);

			// 해쉬맵 생성
			HashMap hm = new HashMap();
			// html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
			hm.put("id", id);
			// html화면에서 던진 pwd값을 "pwd"라는 키로 해쉬맵에 저장
			hm.put("pwd", pwd);
			// html화면에서 던진 name값을 "name"라는 키로 해쉬맵에 저장
			hm.put("name", name);
			// html화면에서 던진 class_num값을 "class_num"라는 키로 해쉬맵에 저장
			hm.put("class_num", class_num);
			// html화면에서 던진 age값을 "age"라는 키로 해쉬맵에 저장
			hm.put("age", age);
			// 위에서 생성한 us레퍼런스 변수를 사용해 insertUser함수를 호출하는데 파라메터값은
			// 위에서 생성하고 값을 저장한 HashMap인 hm레퍼런스 변수를 같이 던짐
			if (us.insertUser(hm)) {
				doProcess(resq, "저장 잘 됬꾸만!!!!");
			} else {
				doProcess(resq, "값 똑바로 입력 안하냐잉~");
			}
		} else if (command.equals("DELETE")) {
			String num = req.getParameter("num");
			HashMap hm = new HashMap();
			hm.put("num", num);
			boolean isDelete = us.deleteUser(hm);
			String result = "";
			if (isDelete) {
				result = "삭제 됬다!!";
			} else {
				result = "안됬네 안됬어!!";
			}
			doProcess(resq, result);
		} else if (command.equals("UPDATE")) {
			String num = req.getParameter("num");
			System.out.println("업데이트할 번호 : " + num);

			String name = req.getParameter("name");
			String class_num = req.getParameter("class_num");
			String age = req.getParameter("age");

			// 해쉬맵 생성
			HashMap hm = new HashMap();
			// html화면에서 던진 name값을 "name"라는 키로 해쉬맵에 저장
			hm.put("name", name);
			// html화면에서 던진 class_num값을 "class_num"라는 키로 해쉬맵에 저장
			hm.put("class_num", class_num);
			// html화면에서 던진 age값을 "age"라는 키로 해쉬맵에 저장
			hm.put("age", age);
		} else if (command.equals("SELECT")) {
			String name = req.getParameter("name");
			System.out.println("이름 : " + name);
			HashMap hm = new HashMap();
			if (name != null && !name.equals("")) {
				hm.put("name", "%" + name + "%");
			}
			List<Map> userList = us.selectUser(hm);
			String result = "<script>";

			result += "function deleteUser(num){";
			result += "location.href = 'delete_user.user?command=DELETE&num=' + num;";//foreign key설정되어있을경우안지워짐
			result += "}";
			result += "</script>";
			result += "<form action='/test_web/sign.user'>";
			result += "이름 : <input type='text' name='name' id='name'/> <input type='submit' value='검색'/>";
			result += "<input type='hidden' name='command' value='SELECT'/>";
			result += "</form>";
			result += "<table border='1'>";
			result += "<tr>";
			result += "<td>유저번호</td>";
			result += "<td>유저아이디</td>";
			result += "<td>유저비밀번호</td>";
			result += "<td>유저이름</td>";
			result += "<td>클래스번호</td>";
			result += "<td>삭제버튼</td>";
			result += "</tr>";
			for (Map m : userList) {
				result += "<tr align='center'>";
				result += "<td>" + m.get("num") + "</td>";
				result += "<td>" + m.get("id") + "</td>";
				result += "<td>" + m.get("pwd") + "</td>";
				result += "<td>" + m.get("name") + "</td>";
				result += "<td>" + m.get("class_num") + "</td>";
				result += "<td><input type='button' value='삭제' onclick='deleteUser(" + m.get("num") + ")'/></td>";
				result += "</tr>";
			}
			result += "</table>";
			doProcess(resq, result);
		}

	}

	public void dePost(HttpServletRequest req, HttpServletResponse reqs) throws IOException {

	}

	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);

	}
}