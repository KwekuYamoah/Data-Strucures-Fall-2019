public class binarySearch{
  public static boolean binarySearch(int[] data,int itemtoFind,int low, int high){
    if(low > high){return false;}
    
    else{
      int middle = (low + high)/2;
      if(data[middle] == itemtoFind){
        return true;
      }
      else if (data[middle] > itemtoFind){
        return binarySearch(data, itemtoFind, low, middle-1);
      }
      else{
        return binarySearch(data,itemtoFind,middle+1,high);
      }
    }
  }
  public static void main(String args[]){
    int a[] = {5,6,9,-8,78,-4,10,20};
    int n = a.length;
    System.out.println( binarySearch(a,2,0, n-1));
  }
}