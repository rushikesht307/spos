// Non-Premptive
import java.util.Scanner;

public class Priority {

	public static void main(String[] args){
		int n;
		float avgWaiting=0,avgTAT=0;
		int currentTime = 0,totalCompleted=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No of processes");
		n = sc.nextInt();
		
		int PID[] = new int[n];  // Process ID
		int AT[] = new int[n];  // Arrival Time
		int BT[] = new int[n];  // Burst Time
		int WT[] = new int[n];  // Waiting time
		int CT[] = new int[n];  // Completion Time
		int TAT[] = new int[n];  // Turn-Around Time
		int PRIORITY[] = new int[n]; // Priority of process
		int flag[] = new int[n];
		
		// input
		for(int i=0;i<n;i++){
			System.out.println("Enter Arrival Time , Burst Time and Priority of process -> " + (i+1));
			AT[i] = sc.nextInt();
			BT[i] = sc.nextInt();
			PRIORITY[i] = sc.nextInt();
			PID[i]= i+1;
		}
	
	
		while(true){
			if(totalCompleted == n){
				break;
			}
			// set minimum to max value and index to total processes
			int maxPriority=100 , index = n;
			
			// Find the process with the highesst priority that has arrived
			for(int i=0;i<n;i++){
				//check if processes is arrived ---> (AT[i] <= currentTime)
                //haven't been completed (flag[i] == 0) 
				//and have a Priority higher than the current maxPriority
				if(AT[i] <= currentTime && flag[i]==0  && PRIORITY[i] < maxPriority){
					maxPriority = PRIORITY[i];
					index = i;
				}
			}	
			
			// This condition means that no process is ready to execute at the current time 
			if(index == n){
				currentTime++;
			}
			else{
			   currentTime = currentTime + BT[index];
				CT[index] = currentTime;
			    totalCompleted++;
				flag[index] = 1;
			}
			
		}
		// compute TAT, WT 
		for(int i=0;i<n;i++){
			TAT[i] = CT[i]-AT[i];
			WT[i] = TAT[i] -BT[i];			
			avgWaiting =  avgWaiting + WT[i];
			avgTAT = avgTAT + TAT[i];
		}	
				
		System.out.println("\nPID \t AT \t BT \t PT \t CT \t TAT \t WT");
		for(int i=0;i<n;i++){
			System.out.println(PID[i] + "\t" + AT[i] + "\t" + BT[i] + "\t" +PRIORITY[i] +" \t"+ CT[i] +"\t"+ TAT[i]+"\t"+ WT[i]);
		}
		
		System.out.println("Average TAT is " + (float) (avgTAT / n));
        System.out.println("average WT is " + (float) (avgWaiting / n));
		
	}
		
}

