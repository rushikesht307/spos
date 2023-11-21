import java.util.Scanner;

class SJF{
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Enter No of processes");
		n = sc.nextInt();
		
		int PID[] = new int[n]; 
		int AT[] = new int[n];
		int BT[] = new int[n];
		int tempBurst[] = new int[n];
		int WT[] = new int[n];
		int CT[] = new int[n];
		int TAT[] = new int[n];
		int flag[] = new int[n];
		
		float avgWaiting=0,avgTAT=0;
		int currentTime = 0,totalCompleted=0;
		
		
		// input
		for(int i=0;i<n;i++){
			System.out.println("Enter Arrival Time And Burst Time of process" + (i+1));
			AT[i] = sc.nextInt();
			BT[i] = sc.nextInt();
			tempBurst[i] = BT[i];
			PID[i]= i+1;
		}
		
		while(true){
			if(totalCompleted == n){
				break;
			}
			// set minimum to max value and index to total processes
			int min=100 , index = n;
			
			// Find the process with the shortest remaining burst time that has arrived
			for(int i=0;i<n;i++){
				//check if processes is arrived ---> (AT[i] <= currentTime)
                //haven't been completed (flag[i] == 0) 
				//and have a burst time shorter than the current minimum (BT[i] < min).
				if(AT[i] <= currentTime && flag[i]==0 && BT[i] < min){
					min = BT[i];
					index = i;
				}
			}	
			
			// This condition means that no process is ready to execute at the current time 
			if(index == n){
				currentTime++;
			}
			else{
			   // decrement Burst Time
			   BT[index]--;
			   currentTime++;
			   // If the remaining burst time is now zero, the process has completed its execution.
			   if(BT[index]==0){
				  CT[index] = currentTime;
		          flag[index] = 1;
			      totalCompleted++; 
			   }

			}
			
		}
		// compute TAT, WT 
		for(int i=0;i<n;i++){
			TAT[i] = CT[i]-AT[i];
			WT[i] = TAT[i] - tempBurst[i];			
			avgWaiting =  avgWaiting + WT[i];
			avgTAT = avgTAT + TAT[i];
		}	

        System.out.println("\nPID \t AT \t BT \t CT \t TAT \t WT");
		for(int i=0;i<n;i++){
			System.out.println(PID[i] +"\t"+ AT[i] +"\t"+ tempBurst[i] +"\t"+ CT[i] +"\t"+ TAT[i]+"\t"+ WT[i]);
		}		
		
        System.out.println("Average TAT is " + (float) (avgTAT / n));
        System.out.println("average WT is " + (float) (avgWaiting / n));		
		
	}
}	