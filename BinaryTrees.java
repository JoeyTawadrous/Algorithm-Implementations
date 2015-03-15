package algorithms;

import java.util.Iterator;
import java.util.LinkedList;


/**
 * Binary Tree manipulations. Adapted from http://cslibrary.stanford.edu/110/BinaryTrees.html#java
 * 
 * @author joeytawadrous
 */
public class BinaryTrees
{
	private static Node root;

	public static void main(String[] args) 
	{
		Tree(2);
		printTree(root);
	    System.out.println(isBST(root, 0, 9));
	}
	
	/**
	 * Creates a tree data structure.
	 * @param data
	 */
	public static void Tree(int data)
	{
	    root = newNode(data);
	    root.leftChild = newNode(4);
	    root.rightChild = newNode(5);

	    insertNode(root.rightChild, 7);
	    
	    System.out.println("Size: " + size(root, 0));
	}
	
	/**
	 * Inserts a new node into the tree.
	 * @param parent
	 * @param data
	 * @return node
	 */
	public static void insertNode(Node parent, int data)
	{
		// TODO: Improve insertion, i.e. check if entering node causes to break bst tree (entering node in wrong place).
		Node node = newNode(data);
		
		if(data <= parent.data)
		{
			parent.leftChild = node;
		}
		else 
		{
			parent.rightChild = node;
		}
	}
	
	/**
	 * Creates a new node.
	 * @return node
	 */
	public static Node newNode(int data)
	{
		Node node = new Node();
		node.data = data;
		node.leftChild = null;
		node.rightChild = null;
		
		return node;
	}
	
	/**
	 * Returns the size of a tree.
	 * @param node
	 * @param size
	 * @return size
	 */
	public static int size(Node node, int size)
	{	
		if (node == null) { return(0); } 
		else 
		{ 
			return(1 + size(node.leftChild, size) + size(node.rightChild, size)); 
		} 
	}
	
	/**
	 * Returns true if tree is binary search tree.
	 * @param node
	 * @param min
	 * @param max
	 * @return boolean
	 */
	public static boolean isBST(Node node, int min, int max)
	{
		if(node == null)
			return true;
		
		if(node.leftChild == null && node.rightChild == null)
			return true;
		
		else if(node.data > min && node.data < max)
			return(isBST(node.leftChild, min, node.data) && isBST(node.rightChild,node.data,max));
		
		else 
			return false;
	}
	
	/**
	 * Prints the tree.
	 * @param node
	 */
	public static void printTree(Node node)
	{
		LinkedList<Node> currentLevel = new LinkedList<Node>();
		LinkedList<Node> nextLevel = new LinkedList<Node>();
        currentLevel.add(node);

        while (!currentLevel.isEmpty())
        {
            Iterator<Node> iter = currentLevel.iterator();
            while (iter.hasNext()) 
            {
            	Node currentNode = iter.next();
                System.out.print(currentNode.data + " ");
                if (currentNode.leftChild != null) 
                {
                    nextLevel.add(currentNode.leftChild);
                }
                if (currentNode.rightChild != null) 
                {
                    nextLevel.add(currentNode.rightChild);
                }
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node>();
        }
    }
	
	/**
	 * Inner node class.
	 */
	private static class Node 
	{
	    private int data;
	    private Node leftChild;
	    private Node rightChild;
	}
}
