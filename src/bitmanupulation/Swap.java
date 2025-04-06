package bitmanupulation;

public class Swap {
  public static void main(String[] args) {
    int a = 5;
    int b = 6;
    a = a^b; // 5^6;
    b = a^b;// 5^6^6; b = 5;
    a = a^b;  // 5^6^5 a =6;
    System.out.println(isSetOptimal(13, 2));
  }

  // brute force solution
  public static boolean isSet(int n, int i) {
    String s = Integer.toString(n); 
    String binary = Convert.convertfromDecimal(s, i);
    int m  = binary.length();

    int ans = Character.getNumericValue(binary.charAt(m-1-i)) & 1;
    System.out.println(ans);
    return ans == 1;
  }

  // optimal solution
  public static boolean isSetOptimal(int n ,int i){
    return ((n >> i) & 1) == 1;
  }
}
