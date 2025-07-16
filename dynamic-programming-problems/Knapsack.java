public class Knapsack {

    static int KP(int[] val, int[] wt, int capacity, int n){
        int[][] dp = new int[n+1][capacity+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=capacity;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else if (wt[i-1]<=j) {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]]+val[i-1]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] val = {14,27,19,44};
        int[] wt = {6,7,8,9};
        int capacity = 15;
        int n = val.length;
        System.out.println(KP(val,wt,capacity,n));
    }
}
