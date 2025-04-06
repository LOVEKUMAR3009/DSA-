package recursion.pattern;

public class RighAngleTriangle {
  public static void main(String[] args) {
    functionPattern(1,4);
  }

  public static void printStar(int j,int i){
    if(j==i){
      return ;
    }
    System.out.print("* ");
    printStar(j+1,i);

  }

  public static void functionPattern(int i,int n){
    if(i==n+1){
      return;
    }
    int j = 0;
    printStar(j, i);
    System.out.println();
    functionPattern(i+1,n);
  }
}
