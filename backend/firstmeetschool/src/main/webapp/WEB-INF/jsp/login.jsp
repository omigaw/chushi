<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="css/login.css">
    <title>初识在校园</title>
</head>
<body>
    <h2 align="center">欢迎登录</h2>

    <!--<%=basePath%>-->
     <%--https://localhost:443/chance/--%>
    <form name="loginForm" action="login/verify" method="post">
        <table align="center">
            <tr>
                <td>用户名:</td><td><input type="text" name="userName" /></td>
            </tr>
            <tr>
                <td>密码:</td><td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td colspan="2", align="center">
                    <input type="submit" value="submit" />
                    <input type="reset" value="reset" />
                </td>
            </tr>
        </table>
    </form>
</body>

</html>