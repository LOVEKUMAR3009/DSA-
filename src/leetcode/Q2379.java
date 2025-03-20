package leetcode;

public class Q2379 {
  public static void main(String[] args) {
    String str = "WBWBBBW";
    int result = minoperation2(str,2);
    System.out.println(result);

  }

  // n = 5 "wbbwb" k = 3; n-k
  public static int minoperation(String input,int k){
    int ans = k;
    int i =0;
    int n = input.length();
    // last point of i form where the k length string is possible 
    while(i<=n-k){
      int countofwhite = 0;
      //checking how many white blocks are there so that we can compare that how many block should be replaced 
      // from i to i+k 
      for(int j = i;j<k+i;j++){
        char a = input.charAt(j);
        if(a=='W'){
          countofwhite++;
        }
      }
      if(countofwhite<ans){
        ans = countofwhite;
        // System.out.println(ans);
      }
      i++;
    }
    return ans;
  }

  //lets think of an optimal solution 
  public static int minoperation2(String input,int k){
    int n = input.length();
    int ans =k;
    int countofwhite = 0;
    for(int i =0;i<k;i++){
      char a = input.charAt(i);
      if(a=='W'){
        countofwhite++;
      }
    }
   int i =0;
    int tempcount = countofwhite;
   while(i<n-k){
    char left = input.charAt(i);
    char right = input.charAt(i+k);
    if(left=='B' && right=='B'){
      i++;
      continue;
    }
    else if(left=='W' && right=='W'){
      i++;
      continue;
    }
    else if(left == 'W' && right=='B'){
      i++;
      countofwhite--;
      if(tempcount> countofwhite){
        tempcount = countofwhite;
      }
    }
    else{
      i++;
      countofwhite++;
    }

  }
  if(tempcount>countofwhite){

    ans = countofwhite;
  }else{
    ans = tempcount;
  }
  return ans;
}
}
