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
			
			
			double sum = 0;
			for(int i = 0; i < 10000; i++){
				sum += perc.getCombined();
			}
			double avg = sum/10000;
			DecimalFormat df   = new DecimalFormat("######0.00");
			return df.format(avg * 100) + "%";
		}catch(SigarException e){
			e.printStackTrace();
			return null;
		}
	}
//	public int setCpuRatio(int k){
//		CpuInformation c = new CpuInformation();
//		String ratio = c.GetCpuRatio();
//		int nowRatio = (int)Double.parseDouble(ratio.substring(0, ratio.indexOf("%")));
//		if(nowRatio >= k*10){
//			return 0;
//		}else{
//			int setRaio = k * 10 - nowRatio;
//			int num = setRaio / 10;
//			CpuThread[] th = new CpuThread[10];
//			for(int i = 0; i < num; i++){
//				th[i] = new CpuThread();
//				th[i].start();
//			}
//		}
//		return 1;
//	}
	public void setCpuRatio(int rate){
		int num = rate / 10;
		SetCpuThread[] st = new SetCpuThread[10];
		for(int i = 0; i < num; i++){
			st[i] = new SetCpuThread();
			st[i].start();
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
		cpuInfo.setCpuRatio(30);
		DetectCpu de = new DetectCpu();
		de.start();
//		System.out.println(System.getProperty("java.library.path"));
	}
}
