package strings;

public class RemoveOutermost {
  public static void main(String[] args) {
    String s = "(()(()))"; //"()(())"
    System.out.println(removeOuterParanthesis(s));
  }


  public static String removeOuterParanthesis(String s){
    // System.out.println("helo");
    int n =s.length();
    int i = 0;
    int count = 0;
    String ans = "";
    String temp = "";
    while(i<n){
      char ch = s.charAt(i);
      if(ch=='(' && count == 0){
        count++;
      }
      else if(ch == ')' && count == 1){
        count--;
      }
      else if(ch=='('){
        temp = temp + ch;
        count++;
      }
      else{
        temp = temp + ch;
        count--;
      }
      if(count==0){
        ans+=temp;
        temp = "";
      }
      i++;
    }
    return ans;
  }

}
