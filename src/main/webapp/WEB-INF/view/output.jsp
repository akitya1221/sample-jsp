<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.OutputDto" %>
<%
// リクエストスコープに保存されたHealthを取得
OutputDto output_data = (OutputDto) request.getAttribute("output_data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>計算結果</h2>
	<label>BMI：</label><%= String.valueOf(output_data.getBmi()) %><br>
	
	<h2>登録情報</h2>
	<%-- <%= for (int i = 0; i < select_data.length; i++) { %> --%>
		<%-- <p><%= select_data %></p> --%>
	<%-- <%=	} %>  --%>
	
</body>
</html>