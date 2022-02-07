package SubsetSum;

import java.util.ArrayList;

public class SubSet_sum_problem
{

    static boolean[][] dp;
    static ArrayList<Integer> final_p = new ArrayList<Integer>();
    static boolean is_found_flag = false;
    static ArrayList<Integer> final_p_index = new ArrayList<>();

    static void display(ArrayList<Integer> v)
    {
        System.out.println(v);
    }
    static void display_index(ArrayList<Integer> v_index) {System.out.println(v_index);}


    static void printSubsetsRec(int arr[], int i, int sum,
                                ArrayList<Integer> p, ArrayList<Integer> p_index)
    {
        if(is_found_flag == true) return;

        if (i == 0 && sum != 0 && dp[0][sum])
        {
            p.add(arr[i]);
            p_index.add(i);
            int m = final_p.size();
            if(p.size() > final_p.size())
            {
                final_p = (ArrayList<Integer>)p.clone();
                final_p_index = (ArrayList<Integer>) p_index.clone();
            }
            is_found_flag = true;
            p.clear();
            p_index.clear();
            return;
        }

        if (i == 0 && sum == 0)
        {
//            display(p);
            if(p.size() > final_p.size())
            {
                final_p = (ArrayList<Integer>)p.clone();
                final_p_index = (ArrayList<Integer>) p_index.clone();
            }
            is_found_flag = true;
            p.clear();
            p_index.clear();
            return;
        }

        if (dp[i-1][sum])
        {

            ArrayList<Integer> b = new ArrayList<>();
            ArrayList<Integer> b_index = new ArrayList<>();
            b.addAll(p);
            b_index.addAll(p_index);

            printSubsetsRec(arr, i-1, sum, b, b_index);
        }

        if (sum >= arr[i] && dp[i-1][sum-arr[i]])
        {
            p.add(arr[i]);
            p_index.add(i);
            printSubsetsRec(arr, i-1, sum-arr[i], p, p_index);
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
        ArrayList<Integer> p_index = new ArrayList<>();
        printSubsetsRec(arr, n-1, sum, p, p_index);
    }


    public static void main(String args[])
    {
        int arr[] = {1, 2, 3, 4, 5, 10, 13, 1, 2, 3, 1, 5, 1, 1, 1, 11, 12, 10, 13, 1, 2, 3, 4, 5, 10, 13, 17, 11, 12, 10, 13,
                10, 13, 1, 2, 3, 4, 5, 10, 13, 1, 1, 1, 1, 1, 2, 1, 3, 1, 1};
        int n = arr.length;
        int sum = 52;
        printAllSubsets(arr, n, sum);

        System.out.println("The final result is: ");
        display(final_p);
        System.out.println(("The final result index is: "));
        display_index(final_p_index);
 //       display(final_p_index);
    }
}
