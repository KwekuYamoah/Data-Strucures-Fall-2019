public class Array{
  public static int sumArray(int[] a,int n){
    if(n == 0){return 0;}
    
    else{
      return a[n-1] + sumArray(a,n-1);
    }
  }
  
  public boolean reverse(String [] array, int startIndex, int endIndex){
          if (startIndex > endIndex)
               return false;
          else{
          String temp = array[endIndex];
          array[endIndex] = array[startIndex];
          array[startIndex] = temp;
          return reverse(array, startIndex+1, endIndex-1);
          }
     }  
  public static void main(String args[]){
    Array my_array = new Array();
    int a[] = {5,6,9,-8,78,-4,10,20};
    int n = a.length;
    System.out.println(my_array.sumArray(a,n));
    String b[] = {"book","box","bag","lolo","daddy" ,"linda" ,"mommy"};
    my_array.reverse(b,0,b.length-1);
    for(int i = 0;i<b.length;i++){
      System.out.print(b[i] + " ");
    }
  }
}