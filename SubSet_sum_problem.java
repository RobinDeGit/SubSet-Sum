package subset;

//A Java program to count all subsets with given sum. 
import java.util.ArrayList; 
public class SubSet_sum_problem 
{ 

	static boolean[][] dp; 
	static ArrayList<Integer> final_p = new ArrayList<Integer>();
	
	static void display(ArrayList<Integer> v) 
	{ 
	System.out.println(v); 
	} 
	

	static void printSubsetsRec(int arr[], int i, int sum, 
										ArrayList<Integer> p) 
	{ 
		if (i == 0 && sum != 0 && dp[0][sum]) 
		{ 
			p.add(arr[i]); 
			display(p); 
			int m = final_p.size();
			if(p.size() > final_p.size()) final_p = (ArrayList<Integer>)p.clone();
			p.clear(); 
			return; 
		} 
	
		if (i == 0 && sum == 0) 
		{ 
			display(p); 
			if(p.size() > final_p.size()) final_p = (ArrayList<Integer>)p.clone();
			p.clear(); 
			return; 
		} 
	
		if (dp[i-1][sum]) 
		{ 
			
			ArrayList<Integer> b = new ArrayList<>(); 
			b.addAll(p); 
			
			printSubsetsRec(arr, i-1, sum, b); 
		} 
	
		if (sum >= arr[i] && dp[i-1][sum-arr[i]]) 
		{ 
			p.add(arr[i]); 
			printSubsetsRec(arr, i-1, sum-arr[i], p); 
		} 
	} 
	
	static void printAllSubsets(int arr[], int n, int sum) 
	{ 
		if (n == 0 || sum < 0) 
		return; 
	
		dp = new boolean[n][sum + 1]; 
		for (int i=0; i<n; ++i) 
		{ 
			dp[i][0] = true; 
		} 
	
		if (arr[0] <= sum) 
		dp[0][arr[0]] = true; 
	

		for (int i = 1; i < n; ++i) 
			for (int j = 0; j < sum + 1; ++j) 
				dp[i][j] = (arr[i] <= j) ? (dp[i-1][j] || 
										dp[i-1][j-arr[i]]) 
										: dp[i - 1][j]; 
		if (dp[n-1][sum] == false) 
		{ 
			System.out.println("There are no subsets with" + 
												" sum "+ sum); 
			return; 
		} 
	
		ArrayList<Integer> p = new ArrayList<>(); 
		printSubsetsRec(arr, n-1, sum, p); 
	} 
	

	public static void main(String args[]) 
	{ 
		int arr[] = {1, 2, 3, 4, 5, 10, 13, 17, 11, 12, 10, 13, 1, 2, 3, 4, 5, 10, 13, 17, 11, 12, 10, 13,
				10, 13, 1, 2, 3, 4, 5, 10, 13}; 
		int n = arr.length; 
		int sum = 82; 
		printAllSubsets(arr, n, sum); 
		
		System.out.println("The final result is: ");
		display(final_p);
	} 
} 
//This code is contributed by Sumit Ghosh 

