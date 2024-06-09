package LEETCODE;
import java.util.Arrays;

public class arr {
    public static long computeFinalValue(int n, int k) {
    
        long[] A = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = 1;
        }

        for (int seconds = 0; seconds < k; seconds++) {
            long[] newA = new long[n];
            newA[0] = A[0]; // First element remains the same
            for (int i = 1; i < n; i++) {
                newA[i] = newA[i - 1] + A[i];
            }
            A = newA;
        }

      
        return A[n - 1];
    }
    public static int valueAfterKSeconds(int n, int k) {
        int mod=(int)Math.pow(10,9)+7;
        int a=(int)computeFinalValue(n,k);
        return a%mod;
        
    }
        
    public static void main(String[] args) {
        int n=4;
        int k=5;
        System.out.println(valueAfterKSeconds(n, k));
    }
    
}
