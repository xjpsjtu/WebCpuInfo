package xjp.cpuInfo;

public class CpuThread extends Thread{
	int i = 0;
	int time = 100;
	public void run(){
		while(time-- > 0){
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
