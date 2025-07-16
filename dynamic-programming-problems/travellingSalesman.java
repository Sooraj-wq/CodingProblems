import java.util.Arrays;

public class travellingSalesman{

    static int function(int[][] cost, int n){ 
        
        int[][] dp = new int[4][3];

        for(int i=0;i<3;i++){
            Arrays.fill(dp[i], 0);
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                dp[j][i]+=cost[i][j];
            }
        }

    }
    public static void main(String[] args) {
        int[][] cost = {{0,16,11,6},{8,0,13,16},{4,7,0,9},{5,12,2,0}};
        int n = cost.length;

        System.out.println(function(cost,n));
    }
}