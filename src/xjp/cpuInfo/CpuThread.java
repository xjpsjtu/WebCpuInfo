package xjp.cpuInfo;

public class CpuThread extends Thread{
	int i = 0;
	//int time = 100;
	long nowtime = 0;
	long starttime = 0;
	public void run(){
		while(true){
			nowtime = System.currentTimeMillis();
			if(nowtime - starttime > 1){
				try {
					sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				starttime = System.currentTimeMillis();
			}
		}
	}
}
