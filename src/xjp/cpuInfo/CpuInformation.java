package xjp.cpuInfo;

import java.text.DecimalFormat;

import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class CpuInformation {
	private static Sigar sigar;
	private CpuPerc perc;
	private int cpuNum; // the number of the Cpus
	public String GetCpuRatio(){
		sigar = new Sigar();
		try{
			Cpu cpu = sigar.getCpu();
			   
			perc = sigar.getCpuPerc();
			DecimalFormat df   = new DecimalFormat("######0.00");
			return df.format(perc.getCombined() * 100) + "%";
		}catch(SigarException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public void setCpuRatio(int k){
		CpuThread[] th = new CpuThread[10];
		for(int i = 0; i < k; i++){
			th[i] = new CpuThread();
			th[i].start();
		}
	}
	public int getCpuNum(){
		try {
			cpuNum = sigar.getCpuList().length;
		} catch (SigarException e) {
			cpuNum = 0;
			e.printStackTrace();
		}
		return cpuNum;
	}
	public CpuInfo[] getCpuInfo(){
		CpuInfo[] infos;
		try {
			infos = sigar.getCpuInfoList();
		} catch (SigarException e) {
			infos = null;
			e.printStackTrace();
		}
		return infos;
	}
	public static void main(String[] args){
		CpuInformation cpuInfo = new CpuInformation();
		cpuInfo.setCpuRatio(1);
		DetectCpu de = new DetectCpu();
		de.start();
//		System.out.println(System.getProperty("java.library.path"));
	}
}
