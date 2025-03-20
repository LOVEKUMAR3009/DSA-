
package leetcode;
public class Q3208 {

  public static void main(String[] args) {
    int[] arr = {1,0,1,0,0,1,0,1};
    int result = numberOfAlternatingGroups(arr,4);
    // boolean ans  = isfirst(arr, 4, 6);
    // System.out.println(ans);
    System.out.println(result);

  }

  public static int numberOfAlternatingGroups(int[] colors, int k) {
    int n= colors.length;
    int ans = 0;
    int count = 0;
    int start = -1;int end = -1;
    for(int i =0;i<colors.length;i++){
      if(count == 0){

        boolean isFirst = isfirst(colors,i,k);
        if(isFirst){
          count++;
          start = i;
          end = (start+k-1)%n;
        }
        if(i == n-1){
          ans+= count;
        }
      }
      else{
        if(k%2 ==0){
            if(colors[start] == colors[(end+1)%n]){
          count++;
          start = (start+1);
          end = (end+1)%n;
        }
        else{
          ans += count ;
          count = 0;
        }
        if(i == n-1){
          ans+= count;
        }
        }
        else{
             if(colors[start] != colors[(end+1)%n]){
                count++;
                start = (start+1);
                end = (end+1)%n;
            }
            else{
            ans += count ;
            count = 0;
            }
            if(i == n-1){
              ans+= count;
            }
        }
        
      }
       
    }
    return ans;
}
  public static boolean isfirst(int [] arr,int start,int k){
    int n = arr.length;
    int end = (start+k-1)%n;
    if(k%2 ==0 && arr[start] == arr[end] ){
        return false;
    }
    else if(k%2 !=0 && arr[start] != arr[end]){
        return false;
    }
    else{
        int previous = arr[start];
        
        for(int i =start+1;i<start+k;i++){
            int next = (i%n);
           if(previous != arr[(next)]){
            previous = arr[next];
            continue;
           }
           else{
            return false;
           }
        }
    }
    return true;
    
}
}
