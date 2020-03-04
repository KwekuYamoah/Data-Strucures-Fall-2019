public class personalGeneric<T> {
    /**
     * A personal implementation of an array-based list
     * exam preparations
     */
    private int numItems;
    private T[] items;
    private static final int DEFAULT_SIZE = 10;

    public personalGeneric(){
        numItems = 0;
        items = (T[]) new Object[DEFAULT_SIZE];
    }

    /**
     * Expand Array method
     */

    private void expandArray(){
        int size = items.length * 2;
        T[] temp = (T[]) new Object [size]; //performing a narrowing cast
        for(int i = 0; i < items.length; i ++ ){
            temp[i] = items[i];
        }
        items = temp;
    }

    public void add(T newItem){
        if( numItems > items.length ){
            this.expandArray ();
        }
        items[numItems] = newItem;
        numItems++;
    }

    /**
     * Find version one returns item at a given index
     * @param index
     * @return
     */
    public T findV1(int index){
        for(int i = 0; i< items.length;i++){
            if( i == index ){ return items[i];}
        }
        return null; // means item was not found
    }

    /**
     * Returns item a given index
     * @param itemFind
     * @return
     */
    public int findV2(T itemFind){
        for(int i = 0; i< items.length;i++){
            if(items[i].equals (itemFind)){
                return i;
            }
        }

        return -1;
    }

    /**
     * Insert adds an item at a specific index
     */

    public boolean insert(T itemInsert, int index){
        if( numItems > items.length ){
            this.expandArray ();
        }
        for(int i = numItems; i >= index; i--){
            T store = items[i];
            items[i +1] = items[i];
        }
        items[index]= itemInsert;
        numItems++;
        return true;
    }

    /**
     * Remove V1 removes item at specific index and returns it
     */

    public T removeIndex(int index){
        T store;
        for(int i = index; i < numItems ; i++){
             //store = items[i + 1];
             items[i] =  items[i+1];
        }
        return null;
    }

    public void print() {
        for (int i=0; i<numItems; i++) {
            System.out.print(items[i]);
            if (i < numItems-1)
                System.out.print(", ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        personalGeneric<Integer> ages = new personalGeneric<> ();
        ages.add(20);
        ages.add(17);
        ages.add(48);
        ages.add(15);
        ages.add(16);
        ages.add(49);
        ages.print();

        ages.removeIndex (3);
        ages.print ();
    }
}
