package leetcode;

public class Q125 {

    public static boolean ispalindrome(String s){
        String lowerS = s.toLowerCase();
        System.out.println(lowerS);
        int i = 0;
        int j = s.length()-1;
        while(i<=j){
            int first = (int)lowerS.charAt(i);
            int second  = (int)lowerS.charAt(j);
            if(( first< 48 || first > 57) && first < 97 || first > 122){
                i++;
                continue;
            }
            if((second < 48 || second > 57) && second < 97 || second> 122){
                j--;
                continue;
            }
           if(lowerS.charAt(i) != lowerS.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

   

    



    public static void main(String args[]){

        String str ="ab2a";
        System.out.println(ispalindrome(str));
        // System.out.println();
    }
    

}
