//tried to do the frequency of the nodes, and summing the child’s frequency to get the frequency of its root *\
import java.util.PriorityQueue;

public class Huff {
   private static final int max_Asci= 256;


   private static int[] freqtable(String data){
       int[] freq=new int[max_Asci];
       for (char c:data.toCharArray()){
           freq[c]++;
       }
       return freq;
   }


   public static class BinaryNode {
       private char datachar;
       private BinaryNode left;
       private BinaryNode right;
       private int freq;



       // constructor
       public BinaryNode(final char d, BinaryNode lChild, BinaryNode rChild, final int fre){
           datachar = d;
           left = lChild;
           right = rChild;
           freq= fre;
       }

   private static BinaryNode hufftree(int[] freq){
       PriorityQueue<BinaryNode> priorityQueue= new PriorityQueue<>();
       for(char i=0; i<max_Asci;i++) {
           if (freq[i] > 0) {
               priorityQueue.add(new BinaryNode(i, null, null, freq[i]));
           }
       }

       while (priorityQueue.size()>1){
           BinaryNode left=priorityQueue.poll();
           BinaryNode right=priorityQueue.poll();
           BinaryNode root= new BinaryNode('\0' , left, right, left.freq + right.freq);
           priorityQueue.add(root);
       }
       return priorityQueue.poll();
   }
 }
}
