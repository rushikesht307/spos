import java.util.Scanner;

class FCFS{
	
	static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args){
		int n;
		float avgWaiting=0,avgTAT=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No of processes");
		n = sc.nextInt();
		
		int PID[] = new int[n]; 
		int AT[] = new int[n];
		int BT[] = new int[n];
		int WT[] = new int[n];
		int CT[] = new int[n];
		int TAT[] = new int[n];
		
		// input
		for(int i=0;i<n;i++){
			System.out.println("Enter Arrival Time And Burst Time of process" + (i+1));
			AT[i] = sc.nextInt();
			BT[i] = sc.nextInt();
			
			PID[i]= i+1;
		}
		
		// sort processes according to arrival time
		for(int i=0;i<n-1;i++){
			int minIndex = i;
			for(int j=i+1;j<n;j++){
				if(AT[j] < AT[minIndex]){
					minIndex = j;
				}
			}
			swap(AT,i,minIndex);
			swap(BT,i,minIndex);
			swap(PID,i,minIndex);
			
		}
		
		// Computing CT,TAT,WT
		
		for(int i=0;i<n;i++){
			if(i==0){
				CT[i] = AT[i] + BT[i];
			}
			else{
				// If Arrival of time of current process is larger than CT of previous process
				if(AT[i] > CT[i-1]){
					CT[i] = AT[i] + BT[i];
				}
				else{
					// Directly add burst time of current process to CT of previous
					CT[i] = CT[i-1] + BT[i];
				}
			}
			
			TAT[i] = CT[i]-AT[i];
			WT[i] = TAT[i] - BT[i];
			
			avgWaiting =  avgWaiting + WT[i];
			avgTAT = avgTAT + TAT[i];
		}
		
		System.out.println("\nPID \t AT \t BT \t CT \t TAT \t WT");
		for(int i=0;i<n;i++){
			System.out.println(PID[i] + "\t" + AT[i] + "\t" + BT[i] + "\t" + CT[i] +"\t"+ TAT[i]+"\t"+ WT[i]);
		}
		
		System.out.println("Average TAT is " + (float) (avgTAT / n));
        System.out.println("average WT is " + (float) (avgWaiting / n));
		
	}
}