package array;
import java.util.Arrays;
public class Permutation {
  // we have to find the next pemutaion 




    public static void main(String[] args) {
        int []arr = {5,2,5,3,8,1};
        nextPermutaion(arr);
        System.out.println(Arrays.toString(arr));
        
    }
    public static void nextPermutaion(int[]arr){
        int breakpoint =0;
        for(int i=arr.length-1;i>0;i--){
            if(arr[i-1]<arr[i]){
                breakpoint = i-1;
                break;
            }
        }
        // System.out.println();
        // System.out.println(breakpoint);
        int breakNumber = arr[breakpoint];
        // System.out.println();
        // System.out.println(breakNumber);
        for(int j=arr.length-1;j>breakpoint;j--){
            if(breakNumber<arr[j]){
                // System.out.println(Arrays.toString(arr));
                int temp = arr[j];
                arr[j]=breakNumber;
                arr[breakpoint]= temp;
                // System.out.println(Arrays.toString(arr));
                break;
            }
        }
        int first = breakpoint+1;
        int last = arr.length-1;
        while(first<=last){
            int temp = arr[first];
            arr[first]= arr[last];
            arr[last] = temp;
            first++;
            last--;
        }
        // return arr;

    }
    
}
// }
// }
