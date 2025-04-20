package array.findtheelement;

import java.util.Arrays;

public class TrappedWater {
  public static void main(String[] args) {
    int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(trap(height));
  }

  public static int trap(int[] height) {
    int watertrapped = 0;
    int n = height.length;
    int[] leftmax = new int[n];
    int[] rightmax = new int[n];
    for(int i = 0;i<n;i++){
         leftmax[i] = maxleft(height,i,leftmax);
         rightmax[n-i-1] = maxright(height,n-i-1,rightmax);
        
    }
    for(int i=0;i<n;i++){
        watertrapped  +=Math.min(leftmax[i],rightmax[i])-height[i];
    }
    System.out.println(Arrays.toString(leftmax));
    System.out.println(Arrays.toString(rightmax));
    return watertrapped;
}

public static int maxleft(int[]height ,int index,int[]leftmax){
    int max = height[index];
    int i = index-1;
    if(index==0) return max;
    if(max<leftmax[i]){
        max = leftmax[i];
    }
    return max;
}
public static int maxright(int[]height,int index,int[]rightmax){
    int max  = height[index];
    int n = height.length;
    if(index ==n-1) return max;
    if(max<rightmax[index+1]){
        max = rightmax[index+1];
    }
    return max;
}
}
