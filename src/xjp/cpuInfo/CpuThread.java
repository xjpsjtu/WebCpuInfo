package xjp.cpuInfo;

public class CpuThread extends Thread{
	int i = 0;
	//int time = 100;
	long nowtime = 0;
	long starttime = 0;
	public void run(){
		long origintime = System.currentTimeMillis();
		while(nowtime - origintime <= 500){
			nowtime = System.currentTimeMillis();
			if(nowtime - starttime > 20){
				try {
					sleep(17);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				starttime = System.currentTimeMillis();
			}
		}
	}
}
