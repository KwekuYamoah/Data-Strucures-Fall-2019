import java.util.List;
import java.util.LinkedList;

/**
 * A class to represent a generic tree in which each node
 * can have any number of children.
 * Because the number of children per node is not fixed, 
 * each node has list of children.
 **/
public class BinaryTree<T> {
    private BinaryNode<T> root;
    
    // ---------- Beginning of TreeNode class ------------------
    // A class to represent a node of the tree
    public static class BinaryNode<T> {
        private T data;
        private BinaryNode<T> left;
        private BinaryNode<T> right;
        
        // constructor
        public BinaryNode(T d){
            data = d;
            left = null;
            right = null;
        }
        
        // constructor
        public BinaryNode(T d, BinaryNode<T> lChild, BinaryNode<T> rChild){
            data = d;
            left = lChild;
            right = rChild;
        }
    }
    // ---------- End of TreeNode class ------------------
    
    // constructor to create an empty tree
    public BinaryTree() {
        root = null;
    }
    
    // constructor to create a tree with only a root node
    public BinaryTree(T rootData) {
        root = new BinaryNode<T>(rootData);
    }
    
    /**
     * Constructor to create a tree with a root and left & right subtrees
     **/
    public BinaryTree(T rootData, BinaryTree<T> lSubTree, BinaryTree<T> rSubTree) {
        root = new BinaryNode<T>(rootData, lSubTree.root, rSubTree.root);
    }
        
    // A method to draw a tree with appropriate indentation
    public void drawTree() {
        if (root != null)
            drawSubTree(root, 0); // call the recursive helper method
        else
            System.out.println("The tree is empty");
    }
    
    // A private recursive helper method to draw a subtree as an 
    // indented list of the descendants of this node (including itself)
    // The indentLevel parameter just tells us how much to indent when printing
    private void drawSubTree(BinaryNode<T> curNode, int indentLevel){
        // The base case is that curNode is null, in which case we
        // don't want to do anything.  We only do something if curNode is
        // not null;
        if (curNode != null) {
            for (int i=0; i<indentLevel; i++)
                System.out.print("\t");
            System.out.println(curNode.data + " ");
            
            drawSubTree(curNode.left, indentLevel+1);
            drawSubTree(curNode.right, indentLevel+1);
        }
    }
    
    // A method to count the nodes in a tree
    public int countNodes() {
        return countNodes(root);
    }
    
    // A private recursive method to count the nodes in a subtree
    // rooted at a given node
    public int countNodes(BinaryNode<T> stRoot) {
        
        if (stRoot == null)
            return 0;
            
        else {
            return 1 + countNodes(stRoot.left) + countNodes(stRoot.right);
        }
    }

    // A method to count the nodes in a tree
    public int countLeaves() {
        return countLeaves(root);
    }
    
    // A private recursive method to count the leaves in a subtree
    // rooted at a given node
    public int countLeaves(BinaryNode<T> stRoot) {
        if (stRoot == null)
            return 0;
        
        else if (stRoot.left == null && stRoot.right == null)
            return 1;
        
        else {
            return countLeaves(stRoot.left) + countLeaves(stRoot.right);
        }
    }
    
    public void printPreOrderTraversal() {
        printPreOrderTraversal(root);
        System.out.println();
    }
    
    public void printPreOrderTraversal(BinaryNode<T> stRoot) {
        if (stRoot != null) {
            System.out.print(stRoot.data + " ");
            printPreOrderTraversal(stRoot.left);
            printPreOrderTraversal(stRoot.right);
        }
    }
    
    public int height(){
      return height(root);
    }
    public int height(BinaryNode<T> sroot){
      int h = 0;
      if(sroot.right == null && sroot.left == null){
        return h;
      }
      else{
        return Math.max(height(sroot.right) + 1, height(sroot.left) + 1);
      }
      
    }
    
    public void internalNodes(){
      internalNodes(root);
    }
    public void internalNodes(BinaryNode<T> sroot){
      if(sroot.right != null || sroot.left != null){
        System.out.print(sroot.data + ", ");
        if(sroot.right != null){
          internalNodes(sroot.right);
        }
        if(sroot.left != null){
          internalNodes(sroot.left);
        }
      }
      
    }
    
    public void PostOrderTraversal(){
      PostOrderTraversal(root);
    }
    
    public void PostOrderTraversal(BinaryNode<T> sroot){
      if(sroot.left == null && sroot.right == null){
        System.out.print(sroot.data + " ,");
      }
      else{
       PostOrderTraversal(sroot.left);
       PostOrderTraversal(sroot.right);
       System.out.print(sroot.data + " ,");
      }
    }
    
    public void InOrderTraversal(){
      InOrderTraversal(root);
    }
    
    public void InOrderTraversal(BinaryNode<T> sroot){
      if(sroot.left == null && sroot.right == null){
        System.out.print(sroot.data + " ,");
      }
      
      else{
        InOrderTraversal(sroot.left);
        System.out.print(sroot.data + " ,");
        InOrderTraversal(sroot.right); 
      }
    }
}

