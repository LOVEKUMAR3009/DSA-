package strings;

public class Decode {
  public static void main(String[] args) {
    
  }

  public  static int numDecodings(String s) {
        int n = s.length();
        int score = 1;
        int i = 0;
        int j = 1;
        while(j<n){
            char chr1 = s.charAt(i);
            char chr2 = s.charAt(j);
            if(chr1=='0'){
              score = score*1;
            }
            else if(chr2=='0'){
              score = score*1;
            }
            else if(chr1>'2' && chr2>'6'){
              score = score*1;
            }
            else if(chr1>'2'&& chr2<='6'){
              score = score*2;
            }
            
          
        }
}
}
