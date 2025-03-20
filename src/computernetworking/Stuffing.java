package computernetworking;

import java.util.Scanner;

public class Stuffing {
  public static void main(String[] args){
    // String str = "10111111111100";
    // String ans = stuffing(str);
    // String ans1 = unstuffing(ans);

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your name:  ");
    String name = sc.nextLine();
    System.out.print("Enter your Roll Number:  ");
    String rollNO = sc.nextLine();
    System.out.print("Enter your your section:  ");
    String section = sc.nextLine();
    
    System.out.print("Enter the Binary input String:  ");
    String input = sc.nextLine();
    String ans = stuffing(input);
    String ans1 = Destuffing(ans);
    System.out.print("Bit Stuffed String:             ");
    System.out.println(ans);
    System.out.print("Bit Unstuffed String:           ");
    System.out.println(ans1);
    
  }

  public static String stuffing(String input){
    String ans ="";
    int count= 0;
    for(int i= 0;i<input.length();i++){
      char a = input.charAt(i);

      if(count == 5){
        String ch = Character.toString('0');
        ans = ans+ch;
        count =0;
      }
      if(a == '1'){
        
        count++;
        String ch = Character.toString(a);
        ans = ans+ch;
      }
     
      if(input.charAt(i)=='0'){
        count = 0;
        String ch = Character.toString('0');
        ans = ans+ch;
      }
    }
    return ans;
  }

  public static String Destuffing(String input){
    String ans ="";
    int count = 0;
    for(int i= 0;i<input.length();i++){
      char a = input.charAt(i);
      if( a == '0' && count==5){
        count=0;
        continue;
      }
      else if(a=='1'){
        String ch = Character.toString(a);
        ans = ans+ch;
        count++;
      }
      else{
        String ch = Character.toString(a);
        ans = ans+ch;
        count=0;
      }
      

    }
    return ans;
}
}
