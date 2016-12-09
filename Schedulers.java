/*Done By: Milton Acosta
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Schedulers {
	
	public static final int MAX_JOB=20; //Numbers of jobs  
	
	/*CPU burst is the amount of time the process uses the processor before 
	it is no longer ready.
	*/
	
	public static List<Process> getProcess()
	{
		List<Process> processes = new ArrayList<Process>();
		Random ar = new Random(); // This is the random Arrival time
		Random br = new Random(); // This is the random Burst Time
		
		for(int i=0;i<MAX_JOB;i++)
		{
			int arrivalTime = ar.nextInt(30);
			int burstTime = 1+br.nextInt(30);
			//System.out.println("Job: " +i+" "+arrivalTime +" "+burstTime);
			processes.add(new Process(arrivalTime, burstTime));
		}
		Collections.sort(processes,new Comparator<Process>() {

			@Override
			public int compare(Process o1, Process o2) {
				return o1.arrivalTime-o2.arrivalTime;
			}
		});
		return processes;
	}
	
	
	public static List<Process> copyProcess(List<Process> ps)
	{
		List<Process> toReturn = new ArrayList<Process>();
		for(Process p: ps)
		{
			toReturn.add(new Process(p.arrivalTime, p.burstTime));
		}
		return toReturn;
	}
	
	public static void main(String args[])
	{  
		System.out.println("Getting " + MAX_JOB +" processes for simulation ");
		List<Process> theJobs = getProcess();
		List<Process> theJobs1 = copyProcess(theJobs);
		System.out.println("Running Shortest Jobs First Simulation");
		SJF.simulateSJF(theJobs);
		System.out.println("Running Shortest Time To Completion First Simulation");
		STTCF.simulate(theJobs1);
	} 


}
