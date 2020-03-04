// A generic array list
public class GenericArrayList<T> {
    private int numItems;
    private T[] items;
    private static final int DEFAULT_SIZE = 5;
    
    // The constructor creates the underlying array.
    // Casting Object[] to T[] gives a warning, which we are
    // suppressing with @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
    public GenericArrayList(){
        numItems = 0;
        items = (T[]) new Object[DEFAULT_SIZE];
    }
    
    // Add a new item to the list
    public void add(T newItem) {
        // double the size of the array if it's full.
        if (numItems >= items.length)
            expandArray();
            
        items[numItems] = newItem;
        numItems++;
    }
    
    // Insert a new item in the list at the given index
    public void insert(int index, T newItem) {
        // double the size of the array if it's full.
        if (numItems >= items.length)
            expandArray();

        // only do the insert if the insertion index given is valid
        if (index >= 0 && index <= numItems) {
            // shift subsequent items to make space
            for (int i=numItems; i>index; i--) {
                items[i] = items[i-1];
            }
            items[index] = newItem;
            numItems++;
        }
    }
    
    // Search for a given item and return its index if found, or -1 if not
    public int find(T itemToFind){
        for (int i=0; i<numItems; i++){
            if (items[i].equals(itemToFind))
                return i; // found it!
        }
        return -1; // item wasn't in the array
    }
    
    // Remove a given item if its in the list
    public void remove(T item) {
        int index = find(item);
        
        if (index >= 0) {
            removeItemAtIndex(index);
        }
    }
    
    // Print the items in the list
    public void print() {
        for (int i=0; i<numItems; i++) {
            System.out.print(items[i]);
            if (i < numItems-1)
                System.out.print(", ");
        }
        System.out.println();
    }
    
    // Return the first item in the list
    public T first() {
        if (items.length >= 1)
            return items[0];
        else
            return null;
    }    
    
    // A private method to remove an item at a given index
    private void removeItemAtIndex(int index) {
        // only do the remove if the removal index given is valid
        if (index >= 0 && index < numItems) {
            // "remove" the item by shifting all items over
            for (int i=index; i<numItems-1; i++) {
                items[i] = items[i+1];
            }
            numItems--;
        }
    }
    
    // A private method to double the size of the array.   
    private void expandArray() {
        // Uncomment this printout if you want to see when expand array 
        // is called.
        //System.out.println("Expanding array from size " + items.length + 
        //                    " to size " + (items.length*2));
        
        // Create a new array, twice the size
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