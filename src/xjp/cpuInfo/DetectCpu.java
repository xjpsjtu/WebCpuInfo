package xjp.cpuInfo;

public class DetectCpu extends Thread{
	public void run(){
		while(true){
			System.out.println("now the Cpu ratio is: " + CpuInfo.GetCpuRatio());
		}
	}
}
