import java.util.*;

public class RoundRobin {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Enter No of processes");
		n = sc.nextInt();
		
		int PID[] = new int[n]; 
		int AT[] = new int[n];
		int BT[] = new int[n];
		int remBurst[] = new int[n];
		int WT[] = new int[n];
		int CT[] = new int[n];
		int TAT[] = new int[n];
		int flag[] = new int[n];
		
		float avgWaiting=0,avgTAT=0;
		int currentTime = 0,totalCompleted=0,quantam,executionTime;

        // input
		for(int i=0;i<n;i++){
			System.out.println("Enter Arrival Time And Burst Time of process -> " + (i+1));
			AT[i] = sc.nextInt();
			BT[i] = sc.nextInt();
			remBurst[i] = BT[i];
			PID[i]= i;
		}
        System.out.print("Enter the quantum time: ");
        quantam = sc.nextInt();

		
	// Queue Interface and LinkedList class implements it
	Queue<Integer> ReadyQ = new LinkedList<Integer>();
	ReadyQ.add(0); // add first process
	while(totalCompleted < n){


		
		while(! ReadyQ.isEmpty()){
			
			int index = ReadyQ.poll();  // dequeue front element
			executionTime = Math.min(quantam,remBurst[index]);
			remBurst[index] = remBurst[index] - executionTime;
			currentTime = currentTime + executionTime;
			
			// if process completes its execution
			if(remBurst[index] == 0){
				totalCompleted++;
				CT[index] = currentTime;
				flag[index]=1;
			}

				// till then add eligible processes
				for(int j = index+1;j<n;j++){
					if(remBurst[j] > 0 && AT[j] <= currentTime && flag[j] == 0 && !ReadyQ.contains(j)){
					ReadyQ.add(j);
					}
				}
				// add current process after adding next eligible processes
				if(remBurst[index]!=0)
					ReadyQ.add(index);
		}
		
	}
	
		// compute TAT, WT 
		for(int i=0;i<n;i++){
			TAT[i] = CT[i]-AT[i];
			WT[i] = TAT[i] - BT[i];			
			avgWaiting =  avgWaiting + WT[i];
			avgTAT = avgTAT + TAT[i];
		}	
		
		System.out.println("\nPID \t AT \t BT \t CT \t TAT \t WT");
		for(int i=0;i<n;i++){
			System.out.println(PID[i] +"\t"+ AT[i] +"\t"+ BT[i] +"\t"+ CT[i] +"\t"+ TAT[i]+"\t"+ WT[i]);
		}	
		
        System.out.println("\nAverage Waiting Time = " + (avgWaiting / n));
        System.out.println("Average Turnaround Time = " + (avgTAT / n));
    }
}
