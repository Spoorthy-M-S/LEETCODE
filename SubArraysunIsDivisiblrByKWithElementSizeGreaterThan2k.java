package LEETCODE;

import java.util.*;

public class SubArraysunIsDivisiblrByKWithElementSizeGreaterThan2k {
    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
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

    public static boolean brute(int nums[], int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum = sum + nums[j];
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 23, 2, 4, 6, 7 };
        int k = 6;
        System.out.println(checkSubarraySum(arr, k));

    }
}
/*
 * 
 * Given an integer array nums and an integer k, return true if nums has a good
 * subarray or false otherwise.
 * 
 * A good subarray is a subarray where:
 * 
 * its length is at least two, and
 * the sum of the elements of the subarray is a multiple of k.
 * Note that:
 * 
 * A subarray is a contiguous part of the array.
 * An integer x is a multiple of k if there exists an integer n such that x = n
 * * k. 0 is always a multiple of k.
 */