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
