package strings;

public class Roman {
    public static void main(String[] args) {
      String s = "LVII";
      System.out.println(romanToInt2(s));
    }

    public static int romanToInt2(String s){
      int n = s.length();
      int ans = 0;
      int i = 0;
      while(i<n){
        char ch = s.charAt(i);
        if(ch=='V'){
          ans+=5;
          i++;
        }
        else if(ch=='L'){
          ans+=50;
          i++;
        }
        else if(ch=='D'){
          ans+=500;
          i++;
        }
        else if(ch=='M'){
          ans+=1000;
          i++;
        }

        else if(s.charAt(i) == 'I' && i<n-1){
          if(s.charAt(i+1)=='V'){
              ans+=4;
              i+=2;
          }
          else if(s.charAt(i+1)=='X'){
              ans+=9;
              i+=2;
          }
          else{
              ans+=1;
              i++;
          }
      }
      else if(s.charAt(i) == 'X' && i<n-1){
          if(s.charAt(i+1)=='L'){
              ans+=40;
              i+=2;
          }
          else if(s.charAt(i+1)=='C'){
              ans+=90;
              i+=2;
          }
          else{
              ans+=10;
              i++;
          }
      }
      else if(s.charAt(i) == 'C' && i<n-1){
          if(s.charAt(i+1)=='D'){
              ans+=400;
              i+=2;
          }
          else if(s.charAt(i+1)=='M'){
              ans+=900;
              i+=2;
          }
          else{
              ans+=100;
              i++;
          }
      }
      else{
        if(ch=='I'){
          ans+=1;
        }
        else if(ch=='X'){
          ans+=10;
        }
        else if(ch=='C'){
          ans+=100;
        }
      i++;
      }
        
      }
      return ans;
    }
}

