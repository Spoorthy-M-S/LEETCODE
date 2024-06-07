package LEETCODE;
import java.util.*;
class replaceWord{
    public static String replaceWords(List<String> dictionary, String sentence) {
       String ans="";
         Set<String>set=new HashSet<>(dictionary);
         String arr[]=sentence.split(" ");
  
         for(String s:arr){
            if(ans.length()>0){
              ans+=" ";
            }
            ans+=res(s,set);
         }
         return ans;
      }
      public static String res(String s,Set<String>st){
  
          for(int i=1;i<s.length();i++){
              String r=s.substring(0,i);
              if(st.contains(r)){
                  return r;
              }
          }
          return s;
      }
  }