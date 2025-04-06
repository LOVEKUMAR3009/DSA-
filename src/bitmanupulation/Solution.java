package bitmanupulation;

public class Solution {
  public static void main(String[] args) {
    bitManipulation(70, 3);
  }

  static void bitManipulation(int num, int i) {
    // code here
    
    int bit  = num>>(i-1)&1;
    int setbit =  num|(1<<(i-1));
    // int clearbit = num&(!0);
    System.out.println(bit);
    System.out.println(setbit);
}
}
