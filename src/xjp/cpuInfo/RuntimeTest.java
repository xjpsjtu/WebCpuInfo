package xjp.cpuInfo;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;

public class RuntimeTest {
    public static void main(String[] args) {
	// System.out.println("Hello world");
	// TODO Auto-generated method stub
	CpuCpu[] cpu = RuntimeTest.getCpu();
	for(int i = 0; i < cpu.length; i++){
	    cpu[i].printInfo();
	    cpu[i].printRatio();
	}
	System.out.println("------------------");
    }
    
    public static CpuCpu[] getCpu(){
	try{
	    Sigar sigar = new Sigar();
	    CpuInfo infos[] = sigar.getCpuInfoList();
	    CpuPerc cpuList[] = null;
	    cpuList = sigar.getCpuPercList();
	    int l = infos.length;
	    CpuCpu[] cpu = new CpuCpu[l];
	    for(int i = 0; i < l; i++){
		CpuInfo info = infos[i];
		cpu[i] = new CpuCpu();
		cpu[i].cpuMhz = Integer.toString(info.getMhz());
		cpu[i].vendor = info.getVendor();
		cpu[i].model = info.getModel();
		cpu[i].cachesize = Long.toString(info.getCacheSize());
		CpuPerc cpuPerc = cpuList[i];
		cpu[i].userratio = CpuPerc.format(cpuPerc.getUser());
		cpu[i].sysratio = CpuPerc.format(cpuPerc.getSys());
		cpu[i].waitratio = CpuPerc.format(cpuPerc.getWait());
		cpu[i].niceratio = CpuPerc.format(cpuPerc.getNice());
		cpu[i].idleratio = CpuPerc.format(cpuPerc.getIdle());
		cpu[i].combineratio = CpuPerc.format(cpuPerc.getCombined());
	    }
	    return cpu;
	}catch(Exception e){
	    e.printStackTrace();
	    return null;
	}
    }
    public static void cpu() {
	// TODO Auto-generated method stub
	try {
	    Sigar sigar = new Sigar();
	    CpuInfo infos[] = sigar.getCpuInfoList();
	    CpuPerc cpuList[] = null;
	    cpuList = sigar.getCpuPercList();
	    for (int i = 0; i < infos.length; i++) {
		CpuInfo info = infos[i];
		System.out.println("information of the CPU " + (i + 1));
		System.out.println("total MHz:    " + info.getMhz());
		System.out.println("CPU producer:    " + info.getVendor());
		System.out.println("CPU type:    " + info.getModel());
		System.out.println("CPU cache size:    " + info.getCacheSize());
		printCpuPerc(cpuList[i]);
		System.out.println("-----------------");
	    }
	} catch (Exception e) {

	}

    }

    private static void printCpuPerc(CpuPerc cpu) {
	// TODO Auto-generated method stub
	System.out
		.println("CPU user ratio:    " + CpuPerc.format(cpu.getUser()));
	System.out.println(
		"CPU system ratio:    " + CpuPerc.format(cpu.getSys()));
	System.out.println("CPU current waiting ratio:    "
		+ CpuPerc.format(cpu.getWait()));
	System.out.println(
		"CPU current error ratio:    " + CpuPerc.format(cpu.getNice()));
	System.out.println(
		"CPU current free ratio    " + CpuPerc.format(cpu.getIdle()));
	System.out.println("CPU total usage ratio    "
		+ CpuPerc.format(cpu.getCombined()));
    }

}
