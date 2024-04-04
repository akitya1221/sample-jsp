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
	<label>BMI：</label><%= String.valueOf(output_data.getBmi()) %><br>
</body>
</html>