/*Done By: Milton Acosta
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class SJF {
	
	
	/*Shortest Job First runs the shortest job first, then the next shortest
	 * It is an non-preemptive scheduler
	 */
	
	
	
	//Method to simulate Shortest Job First Algorithm. 
	public static void simulateSJF(List<Process> ps)
	{
		int sz = ps.size();
		int totalTurnAroundTime=0;
		int mycurrentTime=ps.get(0).arrivalTime;
		
		
		for(int i=0;i<sz;i++)
		{
			List<Process> filteringJob = new ArrayList<Process>();
			for(Process p: ps)
			{
				if(p.arrivalTime<mycurrentTime)
				{
					filteringJob.add(p);
				}
				
			}
			if(filteringJob.size()==0)
			{
				//System.out.println("filter job is 0");
				filteringJob.add(ps.get(0));
				mycurrentTime=ps.get(0).arrivalTime;
			}
			
			Collections.sort(filteringJob, new Comparator<Process>() 
			{
				@Override
				public int compare(Process o1, Process o2) 
				{
					if(o1.burstTime==o2.burstTime)
						return o1.arrivalTime-o2.arrivalTime;
					return o1.burstTime-o2.burstTime;
				}
			});
			
			Process executing = filteringJob.get(0);
			ps.remove(executing);
			totalTurnAroundTime=mycurrentTime+executing.burstTime-executing.arrivalTime+totalTurnAroundTime;
			mycurrentTime=mycurrentTime+executing.burstTime;
		}
		System.out.println("Average Turnaround Time: " + (totalTurnAroundTime*1.0)/Schedulers.MAX_JOB);
		
	}

}
