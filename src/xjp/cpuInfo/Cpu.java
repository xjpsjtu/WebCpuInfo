package xjp.cpuInfo;

import org.hyperic.sigar.CpuPerc;

public class Cpu {
    String cpuMhz, vendor, model, cachesize;
    String userratio, sysratio, waitratio, niceratio, idleratio, combineratio;

    public String getCombineratio(){
	return this.combineratio;
    }
    public void printInfo() {
	System.out.println("total MHz:    " + this.cpuMhz);
	System.out.println("CPU producer:    " + this.vendor);
	System.out.println("CPU type:    " + this.model);
	System.out.println("CPU cache size:    " + this.cachesize);
    }

    public void printRatio() {
	System.out.println("CPU user ratio:    " + this.userratio);
	System.out.println("CPU system ratio:    " + this.sysratio);
	System.out.println("CPU current waiting ratio:    " + this.waitratio);
	System.out.println("CPU current error ratio:    " + this.niceratio);
	System.out.println("CPU current free ratio    " + this.idleratio);
	System.out.println("CPU total usage ratio    " + this.combineratio);
    }
}
