package LEETCODE;

import java.util.Stack;

public class LVP{
        public int longestValidParentheses(String s) {
    int maxi=0;
    Stack<Integer>st=new Stack<>();
    st.push(-1);
    for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        if(c=='('){
            st.push(i);
        }
        else{
            st.pop();
            if(st.isEmpty()){
                st.push(i);
            }
            else{
                maxi=Math.max(maxi,i-st.peek());
            }
        }
    }
    return maxi;
        
    }

}