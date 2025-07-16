import java.util.Arrays;
import java.util.Scanner;

public class fibonaccidp{

    static int topdown(int n, int[] memo){
        if(n<=1){
            return n;
        }
        else if(memo[n]!=-1){
            return memo[n];
        }
        memo[n]=topdown(n-1,memo)+topdown(n-2,memo);
        return memo[n];
    } 

    static int bottomup(int n){
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        System.out.print("Top down approach result: ");
        System.out.println(topdown(n, memo));
        System.out.print("Bottom up approach result: ");
        System.out.println(bottomup(n));
        scanner.close();
    }
}