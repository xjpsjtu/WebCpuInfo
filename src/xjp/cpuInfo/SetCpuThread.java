package xjp.cpuInfo;

public class SetCpuThread extends Thread{
	public void run(){
		long starttime = 0;
		int totaltime = 100000;
		try {
			starttime = System.currentTimeMillis();

			while (System.currentTimeMillis() - starttime <= totaltime) {
				long start = System.currentTimeMillis();
				while (System.currentTimeMillis() - start <= 6) {
				}
				sleep(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
