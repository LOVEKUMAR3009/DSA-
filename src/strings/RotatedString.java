package strings;

public class RotatedString {
  public static void main(String[] args) {
    String s = "abcde";
    String s2 = "abced";
    System.out.println(isRotation(s, s2));
  }

  public static boolean isRotation(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    if(n!=m) return false;
    return (s1+s1).contains(s2);
  }
}
