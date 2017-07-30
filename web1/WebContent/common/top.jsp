<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    boolean login = Boolean.parseBoolean(request.getParameter("login"));
    String loginStr="로그아웃";
    if(login){
    	loginStr="로그아웃";
    }
    
    %>
<div class="navbar navbar-defaul navbar-fixed-top">
        <a class="navbar-brand" href="/main.jsp">IOT_HOME</a>
      </div>
      <ul class="nav nav-tabs" role="tablist">
        <li role="presentation"><a href="/main.jsp">MAIN</a></li>
        <li role="presentation"><a href="/board/board_select.jsp">게시판</a></li>
        <li role="presentation"><a href="/user/user_info.jsp">유저정보</a></li>
        <li role="presentation"><a href="/role/role_select.jsp">권한정보</a></li>
        <li><a href="/user/logout_ok.jsp"><%=loginStr%></a></li>
      </ul>
      </div>
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      <%-- <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/main.jsp">IOT MAIN</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="/board/board_select.jsp">게시판가기</a></li>
            <li><a href="/user/user_info.jsp">유저정보가기</a></li>
            <li><a href="/role/role_select.jsp">권한정보가기</a></li>
            <li><a href="/user/logout_ok.jsp"><%=loginStr%></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav> --%>