package array;

// import java.util.ArrayList;
// import java.util.List;
// public class Arrayleaders {
import java.util.Stack;

public class LeadersNumber {
    public static void main(String[] args) {
        int[] arr= {10,22,12,3,0,6};
        leaderNumbers(arr);
        
    } 
    //using stack
    public static void leaderNumbers(int[]arr){
        Stack<Integer> st = new Stack<>();
        // int i=0;
        for(int i=0;i<arr.length;i++){
            if (!st.isEmpty() && (st.peek() > arr[i])) {
                st.push(arr[i]);
                
            }
            else{
                while(!st.isEmpty() && st.peek()<arr[i]){
                    st.pop();
                }
                st.push(arr[i]);
            }
        }
        System.out.println(st);
    }
    //
    public static void leaderNumbers2(int[]arr){
        

        
    }
}
// }
