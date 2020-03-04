
/**
 * A method to test the Tree class
 **/
public class TestBinaryTree {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        BinaryTree<String> oprd1 = new BinaryTree<String>("5");
        BinaryTree<String> oprd2 = new BinaryTree<String>("6");
        BinaryTree<String> optr1 = new BinaryTree<String>("+", oprd1, oprd2);
        BinaryTree<String> oprd3 = new BinaryTree<String>("8");
        BinaryTree<String> optr2 = new BinaryTree<String>("*", oprd3, optr1);
        BinaryTree<String> expressionTree = optr2;
        
        System.out.println("Here's an expressionTree:");
        expressionTree.drawTree();
        System.out.println();
        int numNodes = expressionTree.countNodes();
        int numLeaves = expressionTree.countLeaves();
        System.out.print("It has " + numNodes + " nodes: ");
        System.out.println(numLeaves + " operands and " + (numNodes-numLeaves) 
                               + " operators.");

        System.out.println("Here is the order of nodes visited in a pre-order traversal:");
        expressionTree.printPreOrderTraversal();
        System.out.println("The height of the tree is " + expressionTree.height());
        System.out.println("The internal nodes are: ");
        expressionTree.internalNodes();
        
        System.out.println();
        System.out.println("Here is the order of nodes visited in a post-order traversal:");
        expressionTree.PostOrderTraversal();
        
        System.out.println("Here is the order of nodes visited in a in-order traversal:");
        expressionTree.InOrderTraversal();
        
        
    }
}