package LEETCODE;
public class ball {
    //array index after n seconds if reached n then direction changes
    public static int b(int n,int k){
        int t=(2*(n-1));
        int p=k%t;
        if(p<n){
            return p;
        }
        return n-p;
    }
    public static void main(String[] args) {
        int n=3;
        int k=5;
        System.out.println(b(n,k));

    }
    
}
