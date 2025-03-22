package training;

public class Pyramid {
  public static void main(String[] args) {
    printPyramid(5);
  }

  public static void printPyramid(int n){
    for(int i = 1;i<=n;i++){
      for(int j = 1;j<=(n-i);j++){
        System.out.print("  ");
      }
      int out = i;
      for(int k = 1;k<=i;k++){
        System.out.print(out+" ");
        if(k == i){
          out--;
          continue;
        }
        out++;       
      }    
      for(int k =1;k<i;k++){
        System.out.print(out+" ");
        out--;
      }
      System.out.println();
    }
  }
}
