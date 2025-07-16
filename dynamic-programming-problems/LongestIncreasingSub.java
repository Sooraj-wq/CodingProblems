import java.util.Arrays;

public class LongestIncreasingSub{
    static int LIS(int[] seq){
        int n = seq.length;
        int[] table = new int[n];
        Arrays.fill(table,1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if (seq[j]<seq[i]) {
                    table[i] = Math.max(table[i], table[j] + 1);
                }
            }
            max=Math.max(max,table[i]);
        }
        return max;

    }
    public static void main(String[] args) {
        int[] seq = {3,2,7,6,8,5,9};
        System.out.println(LIS(seq));
    }
}