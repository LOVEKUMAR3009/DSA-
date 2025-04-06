package bitmanupulation;

public class Convert {
  public static void main(String[] args) {
    System.out.println(convert(7,8,2));
  }

  public static String convert( int number ,int currnetbase,int targetbase){
    String s = Integer.toString(number);
    String intemidiate = convertToDecimal(s, currnetbase);
    return convertfromDecimal(intemidiate, targetbase);
  }

  public static String convertToDecimal(String s,int base){
    int decimal = 0;
    int n = s.length();
    if(n==0){
      return "";
    }
    for(int i = n-1;i>=0;i--){
      int digit = Character.getNumericValue(s.charAt(i));
      if(digit>=base) return "invalid";
      decimal += digit * Math.pow(base,n-i-1);
    }
    return Integer.toString(decimal);
  }
  public static String convertfromDecimal(String s,int base){
    String decimal = "";
    int num = Integer.parseInt(s);
    while(num!=0){
      decimal = Integer.toString(num%base)+decimal;
      num = num/base;
    }
    return decimal;
  
    
  }
}
