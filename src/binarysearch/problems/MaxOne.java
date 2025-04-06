package binarysearch.problems;

public class MaxOne {

  public static void main(String[] args) {
    int[][] arr ={{0,0,0},{0,1,1},{1,1,1},{0,0,1},{1,1,1},{0,0,1},{1,1,1},{0,0,0},{0,1,1}};
    System.out.println(rowWithMax1s(arr));
  }
  public static int rowWithMax1s(int arr[][]) {
    // code here
    int row = -1;
    int ans = arr[0].length;
    int i = 0;
    while(i<arr.length){
        int temp = lowerBound(arr[i],ans-1);
        if(temp==ans){
          i++;
          continue;
        }
        else if(temp == 0){
            return i;
        }
        else if(temp<ans){
          ans = temp;
          row = i;
        }
        i++;           
    }
    return row;
}

public static int lowerBound(int[] array,int right){
// int result = right;
int left = 0;
// right = array.length ;
while (left <= right) {
  int mid = left+(right-left)/2;
  if(array[mid]==1){
    right = mid-1;
  }else{
    left = mid+1;
  }
}
return left;
}
}
