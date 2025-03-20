package leetcode;

public class Solution {

  public static void main(String[] args) {
    String st = "iqaeouqi";
    int k = 2;
    int ans = countOfSubstrings(st, k);
    System.out.println(ans);
  }
  public static int countOfSubstrings(String str, int k) {
      int n = str.length();
      int count = 0;
      for(int i = 0;i<=n-(5+k);i++){
      int ans = countOfSubstrings(str,k,i);
      count +=ans;
      }
      return count;
  }

  public static int countOfSubstrings(String str,int k,int start){     
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
        if(countofconsonent>k){
          return 0;
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
          countofconsonent++;
            break;
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