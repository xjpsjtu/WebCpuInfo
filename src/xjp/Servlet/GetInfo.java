package xjp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hyperic.sigar.cmd.CpuInfo;

import xjp.cpuInfo.RuntimeTest;
import xjp.cpuInfo.*;

/**
 * Servlet implementation class GetInfo
 */
public class GetInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String k = request.getParameter("rate");
		CpuInformation cpuInfo = new CpuInformation();
		if(k == null){
			out.println("Now the Cpu Ratio is: " + cpuInfo.GetCpuRatio() + "<br>");
			org.hyperic.sigar.CpuInfo[] infos = cpuInfo.getCpuInfo();
			out.println("There are " + cpuInfo.getCpuNum() + " CPU(s)" + "<br>");
			for(int i = 0; i < infos.length; i++){
				out.println("<br>");
				org.hyperic.sigar.CpuInfo info = infos[i];
				out.println("------------ CPU " + (i+1) + "-------------" + "<br>");
				out.println("Mhz: " + info.getMhz() + "<br>");
				out.println("Vendor: " + info.getVendor() + "<br>");
				out.println("Model: " + info.getModel() + "<br>");
				out.println("Cache size: " + info.getCacheSize() + "<br>");
			}
			
		}else{
			int rate = Integer.valueOf(k);
			cpuInfo.setCpuRatio(rate);
			out.println("Successfully change the CPU ratio, now the CPU ratio is: " + cpuInfo.GetCpuRatio() + "<br>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
