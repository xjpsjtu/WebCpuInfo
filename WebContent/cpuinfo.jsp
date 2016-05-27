<%@ page import="xjp.cpuInfo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cpu Info Detail</title>
</head>
<body>
	<%
		CpuInformation cpuInfo = new CpuInformation();
		out.println("Now the Cpu Ratio is: " + cpuInfo.GetCpuRatio() + "<br>");
		org.hyperic.sigar.CpuInfo[] infos = cpuInfo.getCpuInfo();
		out.println("<br>");
		out.println("There are " + cpuInfo.getCpuNum() + " CPU(s)" + "<br>");
		for (int i = 0; i < infos.length; i++) {
			out.println("<br>");
			org.hyperic.sigar.CpuInfo info = infos[i];
			out.println("------------ CPU " + (i + 1) + "-------------" + "<br>");
			out.println("Mhz: " + info.getMhz() + "<br>");
			out.println("Vendor: " + info.getVendor() + "<br>");
			out.println("Model: " + info.getModel() + "<br>");
			out.println("Cache size: " + info.getCacheSize() + "<br>");
		}
	%>
</body>
</html>