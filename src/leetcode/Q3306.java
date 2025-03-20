package leetcode;

public class Q3306 {
  public static void main(String[] args) {
    int k = 2;
    String str = "iqeaouqi";
    chunks(str, k); 
    // System.out.println(chunks(str, k));
    // int result = countOfSubstrings1(str,k);
    // int result1 = countOfSubstrings2(str, k);
    // System.out.println(result);
  }
    
  public static  int subStringstart = 0;
  public static int substringend=0;
  public static int subStringconsStart = -1;
  public static int subStringconsEnd = 0;

  public static int chunks(String str , int k) {
    int ans = countOfSubstrings(str,k,0);
    System.out.println(ans);
    System.out.println(subStringstart);
    System.out.println(substringend);
    System.out.println(subStringconsStart);
    System.out.println(subStringconsEnd);

    int n = str.length();
    int count = 0;
    int i = 0;

    // while(subStringstart<=n-(5+k)){
    //   String tempStr = str.substring(subStringstart, substringend+1);
    //   int ans = countOfSubstrings1(tempStr, k);
    //   count = count + ans;
    //   subStringstart = subStringconsStart+1;
      
    // }
    return count;

  }
  public static int countOfSubstrings1(String str, int k) {
    int n = str.length();
    int count = 0;
    for(int i = 0;i<=n-(5+k);i++){
      int ans = countOfSubstrings(str,k,i);
      count +=ans;
    }
    return count;
  }

  
    public static int countOfSubstrings(String str,int k,int start){    
      int n = str.length();
      int countofconsonent = 0;
      int ans = 0;
      int i = start;
      int [] countvowel = new int[5];
      while(countofconsonent<=k && i<str.length()){
        char x = str.charAt(i);
        if(ans==0){
          switch (x) {
            case 'a':
              countvowel[0]++;
              break;
            case 'e':
            countvowel[1]++;
    
              break;
            case 'i':
            countvowel[2]++;
              break;
            case 'o':
            countvowel[3]++;
              break;
            case 'u':
            countvowel[4]++;
              break;
          
            default:
            countofconsonent++;
              break;
          }
          if(subStringconsStart==-1 && countofconsonent == 1){
            subStringconsStart = i;
          }
          // System.out.println(subStringconsStart);
          if(countofconsonent>k ){
            substringend = i-1;
            return 0;
          }
          if(i==n-1){
            substringend= i;
          }
          boolean isallvowelavail = checkvowel(countvowel);
          if(isallvowelavail){
            if(countofconsonent ==k){
              ans++;
            }
          }
          i++;
        }
        else{
          switch (x) {
            case 'a':
              ans++;
              break;
            case 'e':
            ans++;
              break;
            case 'i':
            ans++;
              break;
            case 'o':
            ans++;
              break;
            case 'u':
            ans++;
              break;
          
            default:
            subStringconsEnd = i;
            countofconsonent++;
              break;
          }
          if(countofconsonent>k){
            substringend = i-1;
          }
          i++;
        }
    }
    return ans;
    
  }


public static boolean checkvowel(int [] countvowel){
  for(int i :countvowel){
    if(i<1){
      return false;
    }
  }
  return true;
}




}
