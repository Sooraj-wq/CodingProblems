//Program to calculate the number of subsets that give us the required target sum
import java.util.*;

public class SubsetSumForward {
    public static int countSubsets(int[] arr, int target) {
        int n = arr.length;
        Map<String, Integer> memo = new HashMap<>();
        return countHelper(arr, 0, 0, target, memo);
    }

    private static int countHelper(int[] arr, int index, int currentSum, int target, Map<String, Integer> memo) {
        if (currentSum == target) {
            return 1; 
        }
        if (index == arr.length || currentSum > target) {
            return 0; 
        }

        String key = index + "," + currentSum;
        if (memo.containsKey(key)) return memo.get(key);

        // Include current element
        int include = countHelper(arr, index + 1, currentSum + arr[index], target, memo);

        // Exclude current element
        int exclude = countHelper(arr, index + 1, currentSum, target, memo);

        memo.put(key, include + exclude);
        return include + exclude;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int target = 10;
        System.out.println("Count of subsets with sum " + target + ": " + countSubsets(arr, target));
    }
}
