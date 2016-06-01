<%@ page import="java.io.PrintWriter" contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
	<head>
		<title>index.jsp</title>
		<meta charset="utf-8" name="viewport" content="user-scalable=no, width=device-width" />
	</head>
	<body>
		<pre>
<%
out.println("hello jsp: "+this);
Throwable throwable=new RuntimeException("jsp");
PrintWriter printer=new PrintWriter(out,true);
throwable.printStackTrace(printer);
%>
		</pre>
	</body>
</html>
