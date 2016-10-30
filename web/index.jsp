<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.apple.concurrent.Dispatch" %>
<html>
<head>
    <title>第一个JSP</title>
</head>
<body>
<%!
    private static int initVar = 0;
    private static int destroyVar = 0;
%>
<%!
    public void jspInit() {
        initVar++;
        System.out.println("jspInit(): " + initVar);
    }

    public void jspDestroy() {
        destroyVar++;
        System.out.println("jspDestroy(): " + destroyVar);
    }
%>
<h1>第一个JSP</h1>
<h1>hello, <%= request.getParameter("hello")%></h1>
<%
    out.println("内置对象");
%>
</body>
</html>
