package xjp.cpuInfo;

public class DetectCpu extends Thread{
	public void run(){
		CpuInformation cpuInfo = new CpuInformation();
		while(true){
			System.out.println("now the Cpu ratio is: " + cpuInfo.GetCpuRatio());
		}
	}
}
