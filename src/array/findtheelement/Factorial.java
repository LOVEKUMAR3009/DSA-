package array.findtheelement;

import java.math.BigInteger;

public class Factorial {
  public static void main(String[] args) {
    System.out.println(factorial(15));
  }

  public static BigInteger factorial(int n){
  BigInteger result = BigInteger.ONE;
    for(int i = 1;i<=n;i++){
      result = result.multiply(BigInteger.valueOf(i));
    }
  }
  return result;
}
