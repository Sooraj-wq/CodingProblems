
import java.util.Arrays;

public class LongestCommonSub {
    static int LCS(String str1, String str2){

        int m = str1.length();
        int n = str2.length();
        int max=0;
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<m;i++){

            Arrays.fill(dp[i],0);

        }

        for(int i=1;i<=m;i++){

            for(int j=1;j<=n;j++){

                if(str1.charAt(i-1)==str2.charAt(j-1)){

                    dp[i][j]=1+dp[i-1][j-1];

                }else{

                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

                if(dp[i][j]>max){

                    max=dp[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

        String str1 = "abcde";
        String str2 = "ace";
        System.out.println(LCS(str1,str2));
        
    }
}
