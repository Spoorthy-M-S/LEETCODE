package LEETCODE;
class NiceSubarray{
    public static int numberOfSubarrays(int[] nums, int k) {
        int cnt=0;
        int n=nums.length;
        int ans=0;
        int count[]=new int[n+1];
        count[0]=1;
        for(int i=0;i<n;i++){
            cnt+=nums[i]&1;
            if(cnt-k>=0){
                ans+=count[cnt-k];
            }
            count[cnt]++;
        }
        return ans;
        }

    public static void main(String[] args) {
        int arr[]={1,0,0,0,0,1,0,0};
        System.out.println(numberOfSubarrays(arr, 2));
    }

}