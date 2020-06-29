/*You are climbing a stair case. It takes n steps to reach to the top.

        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

        Example 1:

        Input: 2
        Output: 2
        Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps
        Example 2:

        Input: 3
        Output: 3
        Explanation: There are three ways to climb to the top.
        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step*/

//We can solve this using DYNAMIC PROGRAMMING.





// The number of ways to reach nth flight = number of ways to reach (n-1)th step + number of ways to reach (n-2)th step. because we can reach nth step only from these two places



import java.util.Scanner;

public class leet70 {
    public static int climbStairs(int n)
    {
        if(n==1)
            return n;
        int [] ways=new int[n+1];//creating an array that we'll be using from 1 to n instead of 0 to n-1
        ways[1]=1;//ways to reach the 1st step
        ways[2]=2;
        for(int i=3;i<=n;i++)
        {
            ways[i]=ways[i-1]+ways[i-2];
        }
        return ways[n];


    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("The number of ways to reach = "+climbStairs(scanner.nextInt()));
    }
}
