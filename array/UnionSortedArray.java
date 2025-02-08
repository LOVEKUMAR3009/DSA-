package array;
import java.util.*;
public class UnionSortedArray {
  //bruteforce
  public static Set<Integer> unionSortedArray(int[]arr,int[]num){
    Set <Integer> temp = new LinkedHashSet<Integer>();
    for(int a : arr){
      temp.add(a);
    }
    for(int a : num){
      temp.add(a);
    }
    return temp;
  }

  //better approch
  public static List<Integer> unionSortedArray2(int[]arr,int[]num){
   
  
  List<Integer> temp = new ArrayList<Integer>();
  int i=0;
  int j=0;
  while(i<arr.length-1 && j<num.length-1){
    if(arr[i]== arr[i+1]){
      i++;
      continue;
    }
    if(num[j]== num[j+1]){
      j++;
      continue;
    }
    if(arr[i]<num[j]){
      temp.add(arr[i]);
    }
    else if(arr[i]>num[j]){
      temp.add(num[j]);
    }
    else{
      temp.add(arr[i]);
      i++;
      j++;
    }

  }
  while (i<arr.length) {
    if(arr[i]== arr[i+1]){
      i++;
      continue;
    }
    else{
      temp.add(arr[i]);
    }
  }
  while (j<num.length) {
    if(num[j]== num[j+1]){
      j++;
      continue;
    }
    else{
      temp.add(num[j]);
    }

  }
  return temp;
  }
  //optimal approch
  public static List<Integer> unionSortedArray3(int[]arr,int[]num){
    List<Integer> union = new ArrayList<Integer>();
    int i=0;
    int j=0;
    int k=-1;
    while(i<arr.length && j<num.length){
      if(k==-1){
        k++;
        if(arr[i]<num[j]){
          union.add(arr[i]); 
          i++;
        }
        else if(arr[i]>num[j]){
          union.add(num[j]);
          j++;
        }
        else{
          union.add(arr[i]);       
          i++;
          j++;
        }
      }
      else{
        if(arr[i]<num[j]){
          if(union.get(k)!=arr[i]){
            k++;
            union.add(arr[i]);           
            i++;
          }
          else{
            i++;
          }
        }
        else if(arr[i]>num[j]){
          if(union.get(k)!=num[j]){
            k++;
            union.add(num[j]);
            
            j++;
          }
          else{
            j++;
          }
        }
          
          
        else{
          if(union.get(k)!=num[j]){
            k++;
            union.add(num[j]);
            
            j++;
          }
          else{
            i++;
            j++;
          }
        }
      }
    }
    while(i<arr.length){
      if(union.get(k)!=arr[i]){
        k++;
        union.add(arr[i]);           
        i++;
      }
      else{
        i++;
      }
    }
    while(j<num.length){
      if(union.get(k)!=num[j]){
        k++;
        union.add(num[j]);
        
        j++;
      }
      else{
        j++;
      }
    }
    return union;
  }

  }
