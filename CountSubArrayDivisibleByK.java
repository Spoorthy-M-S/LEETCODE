package LEETCODE;
import java.util.*;
public class CountSubArrayDivisibleByK {
     //TLE
     public static int brute(int arr[],int k){
        int n=arr.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum%k==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static int bett(int arr[],int k,int n){
      HashMap<Integer,Integer>map=new HashMap<>();
      map.put(0,1);
      int sum=0;
      int cnt=0;
      for(int i=0;i<n;i++){
        sum=sum+arr[i];
        int req=sum%k;
       if(req<0){
        req+=k;
       }
        if(map.containsKey(req)){
            cnt+=map.get(req);
            map.put(req,map.get(req)+1);
         }
        else if(!map.containsKey(req)){
            map.put(req,1);
        }
        }
        return cnt;
      }
   
    
    public static int subarraysDivByK(int[] nums, int k) {
        return bett(nums,k,nums.length);
    }

    public static void main(String[] args) {
        int arr[]={-1,2,9};
        int k=2;
        System.out.println(subarraysDivByK(arr, k));
    }
    
}
