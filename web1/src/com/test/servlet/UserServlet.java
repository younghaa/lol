package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
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

		// request도 map을 가지고 있으며
		// keyset의 iterator를 사용하여 while문(반복문)을 돌리게 되면
		// 키값과 밸류값을 자동으로 받아 올 수 있다.
		Map<String, String[]> reqMap = req.getParameterMap();
		System.out.println(reqMap);
		Iterator<String> it = reqMap.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			// System.out.println(key + "," + reqMap.get(key)[0]);
		}
		// html화면에서 던진 값을 각각 String 변수로 받기 시작
		String command = req.getParameter("command");
		if (command == null) {
			return;
		}
		// UserService에 있는 insertUser(HashMap hm)이라는 함수를 호출하기 위해
		// UserService로 us 레퍼런스 변수를 생성
		UserService us = new UserService();
		if (command.equals("LOGIN")) {
			String userId = req.getParameter("userid");
			String userPwd = req.getParameter("userpwd");
			
			HashMap hm = new HashMap();
			hm.put("userid", userId);
			hm.put("userpwd", userPwd);
			us.loginUser(hm);
		}
		else if (command.equals("SIGNIN")) {
			String userId = req.getParameter("userid");
			String userPwd = req.getParameter("userpwd");
			String userName = req.getParameter("username");
			String address = req.getParameter("address");
			String hp1 = req.getParameter("hp1");
			String hp2 = req.getParameter("hp2");
			String hp3 = req.getParameter("hp3");
			String age = req.getParameter("age");
			// 해쉬맵 생성
			HashMap hm = new HashMap();
			// html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
			hm.put("userid", userId);
			// html화면에서 던진 pwd값을 "pwd"라는 키로 해쉬맵에 저장
			hm.put("userpwd", userPwd);
			// html화면에서 던진 name값을 "name"라는 키로 해쉬맵에 저장
			hm.put("username", userName);
			// html화면에서 던진 class_num값을 "class_num"라는 키로 해쉬맵에 저장
			hm.put("address", address);
			// html화면에서 던진 age값을 "age"라는 키로 해쉬맵에 저장
			hm.put("hp1", hp1);
			hm.put("hp2", hp2);
			hm.put("hp3", hp3);
			hm.put("age", age);
			// 위에서 생성한 us레퍼런스 변수를 사용해 insertUser함수를 호출하는데 파라메터값은
			// 위에서 생성하고 값을 저장한 HashMap인 hm레퍼런스 변수를 같이 던짐
			if (us.insertUser(hm)) {
				doProcess(resq, "저장 잘 됬꾸만!!!!");
			} else {
				doProcess(resq, "값 똑바로 입력 안하냐잉~");
			}
		} else if (command.equals("DELETE")) {
			String usernum = req.getParameter("usernum");
			HashMap hm = new HashMap();
			hm.put("usernum", usernum);
			boolean isDelete = us.deleteUser(hm);
			String result = "";
			if (isDelete) {
				result = "삭제 됐다!!";
			} else {
				result = "안됬네 안됐어!!";
			}
			doProcess(resq, result);
			
		} else if (command.equals("UPDATE")) {
			String userum = req.getParameter("usernum");


			String username = req.getParameter("username");
			String userid = req.getParameter("userid");
			String age = req.getParameter("age");

			// 해쉬맵 생성
			HashMap hm = new HashMap();
			// html화면에서 던진 name값을 "name"라는 키로 해쉬맵에 저장
			hm.put("username", username);
			// html화면에서 던진 class_num값을 "class_num"라는 키로 해쉬맵에 저장
			hm.put("userid", userid);
			// html화면에서 던진 age값을 "age"라는 키로 해쉬맵에 저장
			hm.put("age", age);
			
		} else if (command.equals("SELECT")) {
			String name = req.getParameter("username");
			System.out.println("이름 : " + name);
			HashMap hm = new HashMap();
			if (name != null && !name.equals("")) {
				hm.put("name", "%" + name + "%");
			}
			List<Map> userList  = us.selectUser(hm);
			String result="번호{/}이름{/}아이디{/}나이{+}";
			result+="dis{/}en{/}en{/}en{+}";
			for(Map m : userList){
				result += m.get("usernum") + "{/}" + m.get("username") + "{/}" + m.get("userid") + "{/}" + m.get("age") + "{+}"; 
			}
			result = result.substring(0, result.length()-3);
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