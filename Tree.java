import java.util.Scanner;
  
class treeTree {  
    public static void main(String[] args) {     
        Scanner scan = new Scanner(System.in);  
        Tree obj = new Tree(Integer.MIN_VALUE);   
        char choice;  
    }
}

class Node {      
    Node leftChild, rightChild;
    int elem;
    int color;
   
    public Node(int elem) {  
        this( elem, null, null );
    }   
  
    public Node(int element, Node leftChild, Node rightChild) {  
        this.elem = elem;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        color = 1;
    }      
}  
  
class Tree {  
      public Tree(int header)  {  
        this.header = new Node(header);  
        this.header.leftChild = nullNode;  
        this.header.rightChild = nullNode;  
    }  

    private static Node nullNode; 
    private Node current;   
    private Node parent;  
    private Node header;  
    private Node grand;  
    private Node great; 
  
    static final int RED = 0;
    static final int BLACK = 1;      
  
    static {  
        nullNode = new Node(0);  
        nullNode.leftChild = nullNode;  
        nullNode.rightChild = nullNode;  
    }  
  
    public void removeAll() {  
        header.rightChild = nullNode;  
    }  
  
    public boolean checkEmpty() {  
        return header.rightChild == nullNode;  
    }  
  
    public void newNode(int newElement ) {  
        current = parent = grand = header;        
        nullNode.elem = newElement;          

        while (current.elem != newElement) {              
            great = grand;   
            grand = parent;   
            parent = current;  
            current = newElement < current.elem ? current.leftChild : current.rightChild;
            if (current.leftChild.color == RED && current.rightChild.color == RED)  
                colors( newElement );  
        }  

        if (current != nullNode) {
            return;  
        }
        current = new Node(newElement, nullNode, nullNode);  
             
        if (newElement < parent.elem) {
            parent.leftChild = current;
        }  else  {
            parent.rightChild = current;   
        }       
        colors( newElement );  
    }  

    private void colors(int newElement) {  
        current.color = RED;    
        current.leftChild.color = BLACK;     
        current.rightChild.color = BLACK;   
  
        if (parent.color == RED) {   
            grand.color = RED;  
              
            if (newElement < grand.elem && grand.elem != newElement && newElement < parent.elem) {
                parent = rotation( newElement, grand );  
            current = rotation(newElement, great );  
            }
            current.color = BLACK;  
        }  
        header.rightChild.color = BLACK;   
    }  
  
    private Node rotation(int newElement, Node parent) {  
        if(newElement < parent.elem) {
            return parent.leftChild = newElement < parent.leftChild.elem ? rotationWithLeftChild(parent.leftChild) : rotationWithRightChild(parent.leftChild) ;    
        } else  {
            return parent.rightChild = newElement < parent.rightChild.elem? rotationWithLeftChild(parent.rightChild) : rotationWithRightChild(parent.rightChild);    
        }
    }
  
    private Node rotationWithLeftChild(Node node2) {  
        Node node1 = node2.leftChild;  
        node2.leftChild = node1.rightChild;  
        node1.rightChild = node2;  
        return node1;  
    }  
  
    private Node rotationWithRightChild(Node node1) {  
        Node node2 = node1.rightChild;  
        node1.rightChild = node2.leftChild;  
        node2.leftChild = node1.leftChild;  
        return node2;  
    }  
  
    public int quantityTree() {  
        return quantityTree(header.rightChild);  
    }  

    private int quantityTree(Node node) {  
        if (node == nullNode)  
            return 0;  
        else  
        {  
            int size = 1;  
            size = size + quantityTree(node.leftChild);  
            size = size + quantityTree(node.rightChild);  
            return size;  
        }  
    }  
    
    public boolean searchNode(int value) {  
        return searchNode(header.rightChild, value);  
    }  

    private boolean searchNode(Node node, int value) {  
        boolean check = false;  
        while ((node != nullNode) && check != true)  
        {  
            int nodeValue = node.elem;  
            if (value < nodeValue)  
                node = node.leftChild;  
            else if (value > nodeValue)  
                node = node.rightChild;  
            else  
            {  
                check = true;  
                break;  
            }  
            check = searchNode(node, value);  
        }  
        return check;  
    }  
}

            