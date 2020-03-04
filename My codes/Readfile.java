
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Readfile {
    private String file;
    public String[] words;
    private int freq = 0;
    private int total_freq = 0;
    private String encoded = "";
    private String decoded = "";
    private String inputFile;

    //-----Begining of Node Class---//
    // A class to represent the node of a Huffman Tree
    public class huffmanNode<T> {
        private T data;
        private T freq;
        private huffmanNode<T> left;
        private huffmanNode<T> right;


        //default constructor
        public huffmanNode(){
            data = null;
            left = null;
            right = null;
            freq = null;
        }

        // constructor
        public huffmanNode(T d,T fre){
            data = d;
            left = null;
            right = null;
            freq = fre;
        }



        // constructor
        public huffmanNode(T d, huffmanNode<T> lChild, huffmanNode<T> rChild, T fre){
            data = d;
            left = lChild;
            right = rChild;
            freq = fre;
        }

    }
    // ------End of Node Class-----//


    //Creating a comparator method
    public class MyComparator implements Comparator<huffmanNode> {

        public int compare(huffmanNode left, huffmanNode right) {

            return (Integer)left.freq - (Integer)right.freq;
        }
    }

    public Readfile() {
    }

    public HashMap<String,Integer> readfile(String inputFile) throws IOException {
        HashMap<String,Integer> mapStrings = new HashMap<>();
        /*
         Creating a FileReader is to read streams of characters
         */
        FileReader file;
        file = new FileReader (inputFile);

        /*
        Reads text from a character-input stream,
        buffering characters so as to provide for the
        efficient reading of characters, and lines.
        Because FileReader reads bytes from them file and converts them to characters
        and is returned which is sometimes in efficient
        */

        BufferedReader br = new BufferedReader (file);
        String line = null;
        String data = "";

        /*Reading lines and spliting the data
        into an array of String characters
         */

        while((line = br.readLine()) != null) {
            data = line;

            if(line!=""){
                words = data.split ("");
            }
            /*Loop through the array of characters
            Insert it in a hasMap ith key-value nature
             */
            for(String i: words){
                //Character already belongs to map, increase value by 1
                if(mapStrings.containsKey(i)){
                    mapStrings.replace(i,mapStrings.get(i)+1);
                }
                /*Character is not in map
                insert character as key with value of 1
                 */
                else{
                    mapStrings.put(i,1);
                }
            }



        }
        return mapStrings;
    }

    private  PriorityQueue<huffmanNode> hufQueue() throws IOException {
        PriorityQueue<huffmanNode> priorityQueue = new PriorityQueue<> (new MyComparator ());
        // Getting Items from the hash map
        HashMap<String,Integer> queue = this.readfile("Assignment_r.txt");
        // Iterate through the HashMap
        // and create a single node using values and keys from hashmap
        //Store in a queue
        for (Map.Entry elements : queue.entrySet()){
            priorityQueue.add(new huffmanNode (elements.getKey (), null, null, elements.getValue ()));

        }
        return priorityQueue;
    }

    //Creating a root node and initializing it to null
    huffmanNode root = null;


    private void huffmanTree() throws IOException {
        PriorityQueue<huffmanNode> treeQueue = hufQueue();
        while (treeQueue.size()>1){
            //first highest priority extracted
            huffmanNode left = treeQueue.poll();

            //second highest priority extracted
            huffmanNode right = treeQueue.poll();

            //Creating an internal node
            huffmanNode internalNode = new huffmanNode();

            //Frequency of node is the sum of the frequencies of the left and right nodes
            internalNode.freq = (Integer)left.freq + (Integer)right.freq;
            // Data internal node holds is null from the constructor
            internalNode.data = "node";

            //Left child of internal node is extracted left node
            internalNode.left = left;

            //Right child of internal node is extracted right child
            internalNode.right = right;

            //Setting inter node as root of tree

            root = internalNode;

            //Inserting internal node back into priority queue
            treeQueue.add (internalNode);

        }

    }

    /** Print tree code adopted from class
        Author of Code: Dr Ayorkor Korsah
        Code modified to suit the goal of Huffman Trees
     **/

    // A method to draw a tree with appropriate indentation
    public boolean isEmpty( )
    {
        return root == null;
    }
    public void drawTree() {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else {
            drawTree( root );
            System.out.println();
        }
    }

    // A private recursive helper method to draw a subtree as an
    // indented list of the descendants of this node (including itself)
    // The indentLevel parameter just tells us how much to indent when printing
    private void drawTree(huffmanNode t){
        // The base case is that curNode is null, in which case we
        // don't want to do anything.  We only do something if curNode is
        // not null;
        if( t != null )
        {
            drawTree( t.left );

            System.out.print( t.data + " " );

            drawTree( t.right );
        }
    }

    /**
     *Creating a recursive function to generate the
     * huffman encoding of each character
     */
    HashMap<String,String> youTire = new HashMap<>();

    public void huffmanCode(){
         huffmanCode(root, "");
    }

    private void huffmanCode(huffmanNode sroot, String store){

        if(sroot != null){
            if( sroot.right != null) {
                //Checking left child to see if character is there
                //Doing a left traversal and adding 0 to store
                huffmanCode (sroot.left, store + "0");
            }
            if(sroot.left != null) {
                //Checking right child to see if character is there
                //Doing a right traversal and adding 0 to store
                huffmanCode (sroot.right,  store + "1");
            }
            else{
                youTire.put ((String) sroot.data, store);

            }

        }


    }

    public void printEncoded() throws IOException {
        printEncoded(inputFile);
    }

    private void printEncoded(String inputFile) throws IOException {
        FileReader file;
        file = new FileReader (inputFile);

        BufferedReader br = new BufferedReader (file);
        String line = null;
        String data = "";

        while((line = br.readLine()) != null) {
            data = line;

            if(line!=""){
                words = data.split ("");
            }

            for(int i = 0; i < words.length; i ++) {
                for (Map.Entry items : youTire.entrySet ()) {
                    if (words[i].equals (items.getKey ())) {
                        encoded += items.getValue ();

                    }
                }
                encoded += " ";
            }


        }

        System.out.println (encoded);
    }

    public void printDecoded(){
        String[] encodeArray = encoded.split (" ");
        for(int i = 0; i < encodeArray.length;  i++){
            for(Map.Entry items : youTire.entrySet ()) {
                if (encodeArray[i].equals (items.getValue ())){
                    decoded += items.getKey ();
                }
            }
        }
        System.out.println (decoded);

    }



    public  static void main(String[] args) throws IOException {
        Readfile test = new Readfile();
        System.out.println(test.readfile ("Assignment_r.txt"));
        PriorityQueue<huffmanNode> arr= test.hufQueue();

        System.out.println();
        System.out.println();

        test.huffmanTree ();

        test.drawTree();
        test.huffmanCode ();

        System.out.println ();
        //System.out.println(arr.peek ());
        System.out.println (test.youTire);
        //for(int i  =  0; i < test.words.length; i ++)
           // System.out.print (test.words[i]);
        System.out.println ();
        test.inputFile = "Assignment_r.txt";
        test.printEncoded ();
        test.printDecoded ();

    }
}
