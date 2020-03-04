import java.lang.Math.*;
import java.lang.*;
import java.util.*;
import java.io.Reader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.*;
public class Lab{
  
  
  public static int findMax(int [] a, int n){
    if(n == 1){
      return a[n];
    }
    
    if(n >0){
     return Math.max(a[n-1],findMax(a,n-1));
    }
    return -1;
  }
  
  public static int maxArray(int[] array, int low, int high){
    if(low == high){
      return array[low];
    }
    else{
      if( array[low] > array[high]){
        return maxArray(array,low, high-1);
      }
      else{
        return maxArray(array,low +1, high);
      }
    }
  }
  
  public static void main(String args[]) throws IOException{
    int a[] = {5,6,9,-8,78,-4,10,20};
    int n = a.length;
    System.out.println(findMax(a,n));
    System.out.println(maxArray(a,0,n-1));
    //String h = "kweku";
    //String[] new_h =h.split("");
    //String l = h.substring(1);
    //System.out.println(l.concat(new_h[0]));
    //System.out.println(Arrays.toString(new_h));
    /*String filename = "austen-emma.txt";
    File file = new File(filename);
    Readfile test = new Readfile();
    int c = -1;
    while ((c = test.readfile(filename))> -1) {
      System.out.println((char)c);
    }
    */
    
  }
}