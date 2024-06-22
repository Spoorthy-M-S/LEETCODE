package LEETCODE;
import java.util.Arrays;

public class maxProfit {
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxi = Arrays.stream(worker).max().getAsInt();
        int arr[] = new int[maxi + 1];
        int n = difficulty.length;
        for (int i = 0; i < n; i++) {
            if (difficulty[i] <= maxi) {
                arr[difficulty[i]] = Math.max(arr[difficulty[i]], profit[i]);
            }
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(arr[i], arr[i - 1]);
        }
        int p = 0;
        for (int i = 0; i < worker.length; i++) {
            int w = worker[i];
            p += arr[w];
        }
        return p;
    }

    public static void main(String[] args) {
        int diff[] = { 2, 4, 6, 8, 10 };
        int p[] = { 10, 20, 30, 40, 50 };
        int w[] = { 4, 5, 6, 7 };
        System.out.println(maxProfitAssignment(diff, p, w));
    }
}
