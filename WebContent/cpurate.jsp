<%@ page import="xjp.cpuInfo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Set the Cpu Ratio</title>
</head>
<body>
<%
	Integer cpuratio = (Integer)request.getAttribute("rate");
	int setRatio = cpuratio.intValue();
	CpuInformation c = new CpuInformation();
	c.setCpuRatio(setRatio);
	String ratio = c.GetCpuRatio();
%>
<p>Set the cpu ratio successfully, now the cpu ratio is <%= ratio %></p>
</body>

</html>