package strings;

public class Atoi {
  public static void main(String[] args) {
    // System.out.println(Integer.MAX_VALUE);
    System.out.println(myAtoi("-2147483648"));
  }
  public static int myAtoi(String str) {
      String s = str.trim(); 
      
      int n = s.length();
      // System.out.println(n);
      if(n==0) return 0;
      String ans = "";
      int i = 0;
      int sign = 1;
      if(s.charAt(0)=='-'){
        sign = -1;
        i++;
      }
      else if(s.charAt(i)=='+'){
        sign = 1;
        i++;
      }
      while(i<n){
        // System.out.println(i);
          char chr = s.charAt(i);
          if(chr =='0' && ans==""){
            i++;
            continue;
          }else if(chr >='0' && chr <='9'){
            ans += chr;
          }else{
            break;
          }
          i++;   
      }
      // System.out.println(ans);
      if(ans=="") return 0;
      if(sign==1 ){
        if(ans.length()>10){
          return Integer.MAX_VALUE;
        }
        else if(ans.length()==10){
          long l = Long.parseLong(ans);
          System.out.println(l);
          if(l>Integer.MAX_VALUE) return Integer.MAX_VALUE;
          else{
            System.out.println(l);
            return Integer.parseInt(ans);
          }
        }
        else{
          return Integer.parseInt(ans);
        }
      }
      
      
      else{
        if(ans.length()>10){
          return Integer.MIN_VALUE;
        }
        else if(ans.length()==10){
        
          long l = (-1)*Long.parseLong(ans);

          if(l>Integer.MIN_VALUE){

            return -Integer.parseInt(ans);
          }
          else{
            return Integer.MIN_VALUE;
          }
        }
        else{
          return -Integer.parseInt(ans);
        }
      }
    
    
}
}

