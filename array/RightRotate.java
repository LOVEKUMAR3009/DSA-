package array;

// import java.util.Arrays;

public class RightRotate {
  //brute force 
  public static int[] rightRotateDplace(int[]arr,int d){
    d=d%(arr.length);
    int []temp = new int[d];
    for(int j=d;j<arr.length;j++){
      temp[j-d]=arr[j];
    }
    
    for(int i=0;i<d;i++){
      temp[i+d] = arr[i];
    }
    
    // System.out.println(Arrays.toString(temp));
    return temp;
  }
}
