package subset;

import java.util.Arrays;
import java.util.ArrayList;

public class PerfectSum {
	
private static ArrayList<Double> final_result = new ArrayList<Double>();

public static void printSubsets(double[] set, int n, double sum) {
     int totalSubSets = (1 << n);
     for (int i = 1; i < totalSubSets; ++i) { // loop over all possible subsets
         double curSum = 0;
         for (int j = n - 1; j >= 0; --j) {
             if (((i >> j) & 1) > 0) { // if bit at jth position is 1 take that value
                curSum +=set[j];
             }
         }
         if (curSum == sum) { // valid subset found, then print it
        	 ArrayList<Double> tmp_result = new ArrayList<Double>();
             for (int j = n - 1; j >= 0; --j) { // looping in reverse order to print set in decreasing order
                 if (((i >> j) & 1) > 0) { // if bit at jth position is 1 take that value
//                     System.out.print(set[j] + " ");
                     tmp_result.add(set[j]);
                 }
             }
             System.out.println("");
             if(tmp_result.size() > final_result.size()) {
            	 final_result = tmp_result;
            	 tmp_result = new ArrayList<Double>();
             }
         }
     }
}

public static void main(String[] args) {
    double set[] = {1,2,-36,3,1,3,1,2,1,2,1,2,1,2,1,3,1,1,1,1,1,1,1,2,3,6,4,6,8,9,1,3,2,5,5,7,8,10,11};
    Arrays.sort(set); // To print in non increasing order
    double sum = 0;
    int n = set.length;
    printSubsets(set, n, sum);
    
   System.out.println("So the max-size-subset-with-given-sum is: ");
   for(int i = 0; i < final_result.size(); ++i) {
	   System.out.print(final_result.get(i) + " ");
   }
   
   System.out.println("");
   
   System.out.println("done");
  }
}
