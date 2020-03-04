/*
 * Names of Group Members;
 * Kweku Andoh Yamoah
 * Hussein Fuseini
 * Abraham Abbey
*/


public class KwekuAndohYamoah_HusseinFuseini_AbrahamAbbey  {
    private int numItems;
    private int[] items;
    private static final int DEFAULT_SIZE = 20;
    
    public KwekuAndohYamoah_HusseinFuseini_AbrahamAbbey(){
        numItems = 0;
        items = new int[DEFAULT_SIZE];
    }
    
    public void add(int newItem) {
        if (numItems < items.length) {
            items[numItems] = newItem;
            numItems++;
        }
    }
    
    public void print() {
        for (int i=0; i<numItems; i++) {
            System.out.print(items[i]);
            if (i < numItems-1)
                System.out.print(", ");
        }
        System.out.println();
    }
    
   //Find method
    public int find (int num) {

        for (int i=0; i<numItems; i++) {
          if (items[i]==num) {
            return i;
          }
        }
        return -1;
    }
    
    
   //Insert method using the index 
  public void Insert(int ith_position,int newitem){
    if(numItems < items.length){                              //Checking to see if my numItems is less than the length of  my array
      for(int i = numItems; i >= ith_position; i--){            //Looping through the array starting from the back and stoping at the ith_position
        int store = items[i];                                   // Keeping the value of the ith item in a temporary variable
        items[i+1]= store;                                       // Updating the value to the position i+1
      }
      items[ith_position] = newitem;                                   //Placing the newvalue at the specified index
      numItems++;                                                 //Updating numItems
    }
  
  }
    
  //Removing an item in the list without using the index
  public void remove(int rItem){
    for(int i=0; i<numItems;i++){
      if(items[i]==rItem){
        items[i]=0;
        int t = i;
        while(t <numItems){
          items[t]=items[t+1];
          t++;   
        }
        numItems--;
      }
    }
  }
  
   public static void main(String[] args) {
        KwekuAndohYamoah_HusseinFuseini_AbrahamAbbey myList = new KwekuAndohYamoah_HusseinFuseini_AbrahamAbbey();
        System.out.print("List contains:");
        myList.print();
        
        myList.add(2);
        myList.add(4);
        myList.add(9);
        myList.add(25);
        myList.add(99);
        myList.add(-419);
        myList.add(62);
        
        System.out.println("The index of 25 is ");
        System.out.println(myList.find(25));
        
        System.out.println("The index of 100 is ");
        System.out.println(myList.find(100));
        
        System.out.print("List contains:");
        myList.print();
        
        myList.Insert(7,5);
        myList.Insert(0,14);
        myList.print();
        
        myList.remove(5);
        
        System.out.print("List contains:");
        
        myList.print();
        
    }
    
    
    
    
    
}