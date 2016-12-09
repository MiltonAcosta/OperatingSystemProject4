/*Done By: Milton Acosta
 */

import java.util.List;

public class STTCF {
	
	
	/*Shortest Time To Completion First is an algorithm 
	 * when a new job enters the system the STTCF scheduler determines which 
	 * of the remaining jobs including the new jobs has the least time left 
	 * and schedule that one. 
	 */
	
	

	public static int Min(List<Process> ps, int tbt, int r) 
	{
		int j = 0;
		int min = tbt;
		int n = ps.size();
		for (int i = n - 1; i >= 0; i--) 
		{
			if (ps.get(i) .burstTime < min && ps.get(i) .burstTime > 0 && r >= ps.get(i) .arrivalTime) 
			{
				min =ps.get(i) .burstTime;
				j = i;
			}
		}
		return j;
	}

	
	//Method to Simulate the Shortest Time To Completion First Algorithm. 
	public static void simulate(List<Process> jobs)
	{
		int tbt = 0;
		int sz=jobs.size();
		for (int i = 0; i < sz; i++) 
		{
			tbt = tbt + jobs.get(i).burstTime;
		}
		int time[] = new int[tbt];
		int k = 0;
		int q2 = 0;
		for (int i = 0; i < tbt; i++) 
		{
			int q = Min(jobs ,tbt, i);
			if (q != q2) 
			{
				time[k++] = i;
			}
			jobs.get(q).burstTime=jobs.get(q).burstTime-1;
			q2 = q;
		}
		time[k] = tbt;
		
		int theTotalTurnAroundTime = 0;
		
		for(int i=0;i<time.length;i++)
		{
			theTotalTurnAroundTime+=time[i];
		}
		System.out.println("Average Turnaround time: " + (theTotalTurnAroundTime*1.0)/Schedulers.MAX_JOB);

	}

}
