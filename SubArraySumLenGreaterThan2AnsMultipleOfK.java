package LEETCODE;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumLenGreaterThan2AnsMultipleOfK {

        public static boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        Map<Integer, Integer> remainderIndexMap = new HashMap<>();
        remainderIndexMap.put(0, -1); // To handle the case where the subarray starts from index 0
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;

            if (remainderIndexMap.containsKey(remainder)) {
                if (i - remainderIndexMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                remainderIndexMap.put(remainder, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[]={23,2,4,6,7};
        int k=6;
        //5,0,0,0,0,k=6
        System.out.println(checkSubarraySum(arr,k));
    }
    
}
