 public class SimpleArrayList<T>{
  private int numItems;
  private T[] items;
  private static final int DEFAULT_SIZE = 20;
  
  
  // Casting Object[] to T[] gives a warning, which we are
  // suppressing with @SuppressWarnings("unchecked")
   @SuppressWarnings("unchecked")
   public SimpleArrayList(){
        numItems = 0;
        items = (T[]) new Object[DEFAULT_SIZE];
    }
   
   public void add(T newItem) {
     if (numItems >= items.length){
            expandArray();
     }
     items[numItems] = newItem;
            numItems++;
    }
   
   public void remove(T item){
     int index = find(item);
     for(int i = index; i<numItems-1; i++){
     items[i]=items[i+1];}
     numItems--;
   }
   
   //Find method
    public int find (T num) {

        for (int i=0; i<numItems; i++) {
          if (items[i]==num) {
            return i;
          }
        }
        return -1;
    }
    
    public void Insert(int ith_position,T newitem){
      if (numItems >= items.length){
            expandArray();
      }
      if(ith_position >= 0 && ith_position <= numItems){                              //Checking to see if my numItems is less than the length of  my array
        for(int i = numItems; i >= ith_position; i--){            //Looping through the array starting from the back and stoping at the ith_position
          //T store = items[i];                                   // Keeping the value of the ith item in a temporary variable
          items[i+1]= items[i];                                       // Updating the value to the position i+1
        }
        items[ith_position] = newitem;                                   //Placing the newvalue at the specified index
        numItems++;                                                 //Updating numItems
      }
  
  }
    
 
   
   //Defining the size method that returns the number of items currently in the list
   public int size(){ return numItems;};
   
   //Defining the get that returns an item at a specific index
   public T get(int index) {
     if(index < numItems){
            return items[index];
     }
     return null;
    }
   
   //Defining the set method that places an item at a specified index
   public void set(int index,T newItem){
     if (numItems >= items.length){
            expandArray();
      }
     
     if(index >= 0 && index <= numItems){   
      for(int i = numItems; i >= index; i--){  
        T store = items[i];
        items[i+1]= store;  
      }
      items[index] = newItem; 
      numItems++;  
    }
  
  }
   
  //Defining the countOccurences method to return the occurences of an item in the list
   int count;
   public int countOccurences(T item){
     for(int i= 0; i < numItems; i ++){
       if( items[i] == item){
         count ++;
      
       }
     }
     return count;
   }
   
   //A print method to print out the items in my array
   public void print() {
        for (int i=0; i<numItems; i++) {
            System.out.print(items[i]);
            if (i < numItems-1)
                System.out.print(", ");
        }
        System.out.println();
    }
   
   //Defining the addAll method to add an array of strings to my array
   public void addAll(T[] newItems){
     if (numItems >= items.length){
            expandArray();
      }
     if(numItems < items.length && newItems.length <= items.length){
       for(int i =0; i< newItems.length; i++){
         items[numItems] = newItems[i];
            numItems++;
       }
     }
   }
   
   /*Defining the insertAll method, this method takes in an 
   index and an array of items and inserts all the items in 
   the given array into the list, starting at the given index.
   */
   
   public void insertAll(int index, T[] newItems){
     if (numItems >= items.length){
            expandArray();
      }
     
     if(numItems < items.length && index <= numItems){
       for(int i = 0;i<newItems.length;i ++){
         for(int j = index; j < numItems-1; j++){  
           T store = items[j+1];
           items[j]= store;  
      }
      items[index] = newItems[i]; 
      numItems++;  
    }
   }
   
  }
   
   
  
   //Defining the removeAll method to removes all occurrences of a given item in the list
    public void removeAll(T item){
      for(int i=0; i<numItems;i++){
        if(items[i]==item){
          items[i]= null;
          int t = i;
          while(t <numItems){
            items[t]=items[t+1];
            t++;   
        }
        numItems--;
      }
    }
  }
    
  //Defining the findLast method that returns the index of the last occurrence of a given item in the list
    public int findLast(T item){
      for(int i = numItems; i < items.length; i --){
        if(items[i] == item){
          return i;
        }
      }
      return -1;
      
    }
    
    
  /*The findAll method searches for all occurrences of a given item in the list, 
    returning an array of the indices where the item is located
  */
    
    
  

   public int[] findAll(T item){
     int count = 0;
     int contain = this.countOccurences(item);
     int[] location = new int[contain];
     for(int i= 0; i < numItems; i ++){
       if( items[i] == item){
         location[count] = i;
         count ++;
       }
     }
     return location;
   }
   
   
   // A private method to double the size of the array.   
    private void expandArray() {
      // Casting Object[] to T[] gives a warning, which we are
      // suppressing with @SuppressWarnings("unchecked")
      @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[items.length*2];
        
        // copy items from the old to the new array
        for (int i=0; i<numItems; i++) {
            temp[i] = items[i];
        }
                
        // redirect the items instance variable to refer to the new array
        items = temp;
    }
     
   
     
   
  

}





























 