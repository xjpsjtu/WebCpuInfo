package xjp.cpuInfo;

public class CpuThread extends Thread{
	int i = 0;
	public void run(){
		while(true){
			for(int j = 0; j < 8000000; j++){
				i++;
			}
			try{
				sleep(20);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
