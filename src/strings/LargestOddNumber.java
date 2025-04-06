package strings;

public class LargestOddNumber {
  public static void main(String[] args) {
    
  }

  public String largestOddNumber(String num) {
    int n = num.length();
    for(int i = n-1;i>=0;i--){
        if(Character.getNumericValue(num.charAt(i)) % 2 == 1){
          return num.substring(0,i+1);
        }
    }
    return "";
}

}
