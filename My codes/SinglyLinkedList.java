
// A linked list class with a reference to the head node
public class SinglyLinkedList<T> {
    private Node<T> head;
    private int numItems;
    
    // a private nested node class
    private static class Node<T> {
        private T data;
        private Node<T> next;
    
        Node() {
            data = null;
            next = null;
        }
    
        Node(T data) {
            this.data = data;
            next = null;
        }
    }
    
    // Linked list construtor
    public SinglyLinkedList() {
        head = null;
        numItems = 0;
    }
    
    // add at the beginning of the list
    public void add(T newData) {
        Node<T> newNode = new Node<>(newData);
        newNode.next = head;
        numItems++;
        head = newNode;
    }
    
    // append to the end of the list
    public void append(T newData) {
        Node<T> newNode = new Node<>(newData);
        
        Node<T> current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
        numItems++;
    }
    
    // find a particular item in the list
    public boolean find(T dataToFind) {  
        Node<T> current = head;
        while (current != null){
            if (current.data.equals(dataToFind))
                return true;
            current = current.next;
        }
        return false;
    }
    
    // remove a particular item from the list
    public boolean remove(T dataToRemove) {
        if (head == null)
            return false;
            
        if (head.data.equals(dataToRemove)) {
            head = head.next;
            numItems--;
            return true;
        }
        
        Node<T> current = head;
        while (current.next != null){
            if (current.next.data.equals(dataToRemove)){
                current.next = current.next.next;
                numItems--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // returns whether or not the list is empty
    public boolean isEmpty() {
        return (head == null);
    }
    
    // get the size of the list
    public int size() {
      /*
        Node<T> current = head;
        int numItems = 0;
        while (current != null){
            numItems++;
            current = current.next;
        }
        return numItems;
        */
      return numItems;
    }
    
    // return the item at a particular index of the list
    public T get(int k) {
        T item = null;
        Node<T> current = head;
        int i = 0;
        while (i < k && current != null) {
            current = current.next;
            i++;
        }
        if (i == k && current != null)
            item = current.data;
        
        return item;
    }
    
    public int countOccurences(T item){
      Node<T> current = head;
      int count = 0;
      while(current != null){
        if(current.data.equals(item)){
          count++;
        }
      }
      return count;
      
    }
    // print the list
    public void print() {
        System.out.print("The list: ");
        Node<T> current = head;
        while (current != null){
            System.out.print(current.data);
            if (current.next == null)
                System.out.print(".");
            else
                System.out.print(", ");
            current = current.next;
        }
        System.out.println();
    }
    
    // A test method
    public static void main(String[] args) {
        // Create an empty list
        SinglyLinkedList<String> testList = new SinglyLinkedList<>();
        
        // Test print(), size() and isEmpty()
        testList.print();
        System.out.println("There are " + testList.size() + "or " + 
                           testList.numItems + " items in the list.");
        System.out.println("The list is empty: " + testList.isEmpty());
        
        // Test removing an item from an empty list
        System.out.println();
        System.out.println("Removing dog");
        System.out.println("Return value: " + testList.remove("dog"));
        testList.print();
        System.out.println("There are " + testList.size() + " items in the list.");
        System.out.println();
        
        // test add(), size() and isEmpty()
        testList.add("mouse");
        testList.add("cat");
        testList.add("dog");
        testList.add("dog");
        testList.print();
        System.out.println("There are " + testList.size() + " items in the list.");
        System.out.println("The list is empty: " + testList.isEmpty());
        System.out.println();
        
        //test currentOccurences
        //System.out.println(testList.countOccurences("dog"));
                
        // test append() and size()
        testList.append("horse");
        testList.append("bird");
        testList.print();
        int size = testList.size();
        System.out.println("There are " + size + " items in the list.\n");
                            
        // test get(), including the use of invalid indices
        String item;
        for (int i=-1; i<=size; i++) {
            item = testList.get(i);
            if (item != null)
                System.out.println("The item at index " + i +
                                     " is: " + item);
            else
                System.out.println("Index " + i + " is not valid.");
        }
        
        // test find()
        System.out.println("\nLooking for cat: " + 
                            testList.find("cat"));
        System.out.println("Looking for car: " +
                            testList.find("car"));
                           
        // test removing from the front of the list 
        System.out.println();
        System.out.println("Removing dog");
        System.out.println("Return value: " + testList.remove("dog"));
        testList.print();
        System.out.println("There are " + testList.size() + " items in the list.");

        // test removing an item not in the list
        System.out.println();
        System.out.println("Removing penguin");
        System.out.println("Return value: " + testList.remove("penguin"));
        testList.print();
        System.out.println("There are " + testList.size() + " items in the list.");
    
        // test removing an item in the middle of the list
        System.out.println();
        System.out.println("Removing horse");
        System.out.println("Return value: " + testList.remove("horse"));
        testList.print();
        System.out.println("There are " + testList.size() + " items in the list.");

        // test removing an item from the end of the list
        System.out.println();
        System.out.println("Removing bird");
        System.out.println("Return value: " + testList.remove("bird"));
        testList.print();
        System.out.println("There are " + testList.size() + " items in the list.");
    }
}