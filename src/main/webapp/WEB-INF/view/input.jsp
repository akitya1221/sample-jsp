<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>
	<h1>JSP学習</h1>
	<p>TestClassから呼び出されました。</p>
	<h2>登録</h2>
	<form action="/sample-jsp/Test" method="post">
		<label>名前：</label><input type="text" name="name"><br>
		<label>身長：</label><input type="text" name="height">(cm)<br>
		<label>体重：</label><input type="text" name="weight">(kg)<br>
		<input type="submit" value="診断">
	</form>
</body>
</html>