package LEETCODE;
import java.util.Arrays;

public class MaxiSum {
        public static int maxTotalReward(int[] rewardValues) {
       Arrays.sort(rewardValues);
        int x=0;
        for(int i: rewardValues){
            if(i>x){
                x+=i;
            }
        }
        return x;
    }
    public static int pic(int arr[],int i,int sum){
        if(i==arr.length-1){
            if(sum<arr[arr.length-1]){
                return arr[arr.length-1];
            }
            return 0;
        }
        int ntpic=pic(arr,i+1,sum);
        int pic=Integer.MIN_VALUE;
        if(arr[i]>sum){
            pic=arr[i]+pic(arr,i+1,sum+arr[i]);
        }
        return Math.max(pic,ntpic);
    }
    public static void main(String[] args) {
        int arr[]={1,6,4,3,2};  //1,2,3,4,6 ans=11==1+4+6
        //System.out.println(maxTotalReward(arr));
        Arrays.sort(arr);
        int n=arr.length;
        int dp[][]=new int[n][4001];
        System.out.println(pic(arr,0,0));
    }
}
