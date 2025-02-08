package array;

public class FindMissing {
  //bruteforce
  public static int findMissingNum(int[]arr,int N){
    int missing= Integer.MAX_VALUE;
    for(int i=1;i<=N;i++){
      int index = LinearSearch.linearSearchFirst(arr, i);
      if(index ==-1){
        missing = i;
      }    
    }
    return missing;
    
  }
//better soulution
  public static int findMissingNum2(int[]arr,int N){
    int[]hash = new int[N+1];
    for(int i =1;i<=N;i++){
      hash[i]=1;
    }
    for(int i=1;i<hash.length;i++){
      if(hash[i]==0){
        return i;
      }
    }
    return Integer.MAX_VALUE;
  }

  //optimal soulutin
  public static int findMissingNum3(int[]arr,int N){
    int sumNatural = (N*(N+1))/2;
    int sum =0;
    for(int a: arr){
      sum+=a;
    }
    return sumNatural-sum;
  }
}
