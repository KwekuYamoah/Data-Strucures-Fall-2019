
public class StringArraySearch {
  
  // A method that implements Sequential Search to search for a
  // value in any array (sorted or unsorted)
  public static int sequentialSearch(String value, String[] array, int numItems) {
    int index = -1;
    boolean found = false;
    if (numItems > array.length)
      numItems = array.length;
    
    for (int i=0; i<numItems && !found; i++){
      if (array[i] != null && array[i].equals(value)){
        found = true;
        index = i;
      }
    }
        
    return index;
  }
  
  // A method to implement the Binary Search algorithm to search 
  // for a value in the sorted array.
  // Returns the index of value, if found, and -1 otherwise
  public static int binarySearch( String value, String[] array,int numItems) {
    if (numItems > array.length)
      numItems = array.length;
    
    int minIndex = 0;
    int maxIndex = numItems-1;
    int midIndex = (minIndex + maxIndex)/2;
    boolean found = false;
    
    do {      
      if (array[midIndex] != null) {
        
        if (array[midIndex].equals(value)){
          found = true;
        }
        
        else {
          if (array[midIndex].compareTo(value) < 0) {
            // modify minIndex to search upper half of array
            // maxIndex remains unchanged.
            minIndex = midIndex+1; 
          }
          else { // array[midIndex] > value
            // modify maxIndex to search lower half of array
            // minIndex remains unchanged.
            maxIndex = midIndex-1;
          }
        
          midIndex = (minIndex + maxIndex)/2;
        }
      }
    } while (!found && minIndex <= maxIndex);
      
    if (found)
      return midIndex;
    else
      return -1;
  }
  
  // A method to implement the Binary Search algorithm (recursively) to search 
  // for a value in the sorted array.
  // Returns the index of value, if found, and -1 otherwise
  public static int recursiveBinarySearch(String value, String[] array,
                                          int startInd, int endInd) {
    // base case -- only one item in the array
    if (startInd == endInd) {
      if (array[startInd] != null && array[startInd].equals(value))
        return startInd;
      else
        return -1;
    }
    
    int midInd = (startInd + endInd)/2;
    
    // another base case.  The item is in the middle.
    if (array[midInd] != null & array[midInd].equals(value))
      return midInd;
    
    // recursive case -- check the first half of the array
    else if (array[midInd].compareTo(value) > 0)
      return recursiveBinarySearch(value, array, startInd, midInd);

    // recursive case -- check the second half of the array
    else
      return recursiveBinarySearch(value, array, midInd+1, endInd);

  }

}