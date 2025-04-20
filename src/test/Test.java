package test;

public class Test {
  public static void main(String[] args) {
    String [] instructions = {"jump","add","add","jump","add","jump"};
    int [] values = {2,1,3,1,-2,-3};
    System.out.println(calculateScore(instructions, values));
  }
  public static long calculateScore(String[] instructions, int[] values) {
        int n = values.length;
        long score = 0;
        int i = 0;
        while(i>=0 && i<n){
            String chr = instructions[i];
            instructions[i] = "visited";
            if(chr=="add"){
              score +=values[i];
                i = i+1;
            }
            else if(chr=="jump"){
                i = i+values[i];
            }else{
                break;
            }
        }
        return score;
    }
}
