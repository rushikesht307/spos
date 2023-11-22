import java.util.Scanner;
class MemoryAllocation{
	

	void firstFit( int blockSize[],int m, int processSize[],int n,int allocation[]){
		for(int i=0;i<n;i++){
			allocation[i]=-1;
		}
		// pick each process and find suitable blocks 
        for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(blockSize[j] >= processSize[i]){
					// allocate block j to p[i] process 
					allocation[i] = j;
					 // Reduce available memory in this block. 
                    blockSize[j] = blockSize[j] - processSize[i]; 
					
					break;
				}
			}
		}
		
		System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
        for (int i = 0; i < n; i++) 
        { 
            System.out.print(" " + (i) + "\t\t" +  
                             processSize[i] + "\t\t"); 
            if (allocation[i] != -1) 
                System.out.print(allocation[i]); 
            else
                System.out.print("Not Allocated"); 
            System.out.println(); 
        } 
		
	}
	
	
	void nextFit( int blockSize[],int m, int processSize[],int n,int allocation[]){
		for(int i=0;i<n;i++){
			allocation[i]=-1;
		}
		
		int j=0,t=m-1;
		// pick each process and find suitable blocks 
        for(int i=0;i<n;i++){
			// Do not start from beginning
			while(j<m){
				if(blockSize[j] >= processSize[i]){
					// allocate block j to p[i] process 
					allocation[i] = j;
					 // Reduce available memory in this block. 
                    blockSize[j] = blockSize[j] - processSize[i]; 
					
					// sets a new end point
					t = (j - 1) % m;
					break;
				}
				if (t == j){
					// sets a new end point
					t = (j - 1) % m;
					// breaks the loop after going through all memory block
					break;
				}
             
				// mod m will help in traversing the
				// blocks from starting block after
				// we reach the end.
				j = (j + 1) % m;
			}
			
			
		}
		
		
		System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
        for (int i = 0; i < n; i++) 
        { 
            System.out.print(" " + (i) + "\t\t" +  
                             processSize[i] + "\t\t"); 
            if (allocation[i] != -1) 
                System.out.print(allocation[i]); 
            else
                System.out.print("Not Allocated"); 
            System.out.println(); 
        } 
		
	}
	
	void bestFit( int blockSize[],int m, int processSize[],int n,int allocation[]){
		for(int i=0;i<n;i++){
			allocation[i]=-1;
		}
		for(int i=0;i<n;i++){
			int index=-1;
			for(int j=0;j<m;j++){
				if(blockSize[j] >= processSize[i]){
					if(index== -1)
						index = j;
					else if(blockSize[index] > blockSize[j])
						index = j;
				}
			}
			
			 // If we could find a block for current process 
            if (index != -1) 
            { 
                // allocate block j to p[i] process 
                allocation[i] = index; 
       
                // Reduce available memory in this block. 
                blockSize[index] = blockSize[index] - processSize[i]; 
            } 
		}
		
		System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
        for (int i = 0; i < n; i++) 
        { 
            System.out.print(" " + (i) + "\t\t" +  
                             processSize[i] + "\t\t"); 
            if (allocation[i] != -1) 
                System.out.print(allocation[i]); 
            else
                System.out.print("Not Allocated"); 
            System.out.println(); 
        } 
	}
	
	void worstFit( int blockSize[],int m, int processSize[],int n,int allocation[]){
		for(int i=0;i<n;i++){
			allocation[i]=-1;
		}
		for(int i=0;i<n;i++){
			int index=-1;
			for(int j=0;j<m;j++){
				if(blockSize[j] >= processSize[i]){
					if(index== -1)
						index = j;
					else if(blockSize[index] < blockSize[j])
						index = j;
				}
			}
			
			 // If we could find a block for current process 
            if (index != -1) 
            { 
                // allocate block j to p[i] process 
                allocation[i] = index; 
       
                // Reduce available memory in this block. 
                blockSize[index] = blockSize[index] - processSize[i]; 
            } 
		}
		
		System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
        for (int i = 0; i < n; i++) 
        { 
            System.out.print(" " + (i) + "\t\t" +  
                             processSize[i] + "\t\t"); 
            if (allocation[i] != -1) 
                System.out.print(allocation[i]); 
            else
                System.out.print("Not Allocated"); 
            System.out.println(); 
        } 
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		MemoryAllocation obj = new MemoryAllocation();
		int m,n;
		
		System.out.println("Enter No of blocks -> ");
		m = sc.nextInt();
		int[] blockSize = new int[m];
		System.out.println("Enter No of Processess -> ");
		n = sc.nextInt();
		int[] processSize = new int[n];
		
		for(int i=0;i<m;i++){
			System.out.println("Enter Size of Block " + i);
			blockSize[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++){
			System.out.println("Enter Size of Process " + i);
			processSize[i] = sc.nextInt();
		}
		
		// To store Block ID of Block Allocated to process
		int allocation[] = new int[n];
		
		// obj.worstFit(blockSize,m,processSize,n,allocation);
	}
}