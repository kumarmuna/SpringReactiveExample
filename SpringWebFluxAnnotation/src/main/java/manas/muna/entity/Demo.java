package manas.muna.entity;
class Node  
{ 
    int key; 
    Node left, right, midle; 
   
    public Node(int key)  
    { 
        this.key = key; 
        left = right = midle = null; 
    } 
} 
   
public class Demo  
{ 
    static Node root; 
   
    // Creates a node with key as 'i'.  If i is root, then it changes 
    // root.  If parent of i is not created, then it creates parent first 
    void createNode(int parent[], int i, Node created[])  
    { 
        // If this node is already created 
        if (created[i] != null) 
            return; 
   
        // Create a new node and set created[i] 
        created[i] = new Node(i); 
   
        // If 'i' is root, change root pointer and return 
        if (parent[i] == 0)  
        { 
            root = created[i]; 
            return; 
        } 
   
        // If parent is not created, then create parent first 
        if (created[parent[i]] == null) 
            createNode(parent, parent[i], created); 
   
        // Find parent pointer 
        Node p = created[parent[i]]; 
   
        // If this is first child of parent 
        if (p.left == null) 
            p.left = created[i]; 
        else if(p.midle == null)
        	p.midle = created[i];
        else // If second child
            p.right = created[i]; 
    } 
   
    /* Creates tree from parent[0..n-1] and returns root of  
       the created tree */
    Node createTree(int parent[], int n)  
    {     
        // Create an array created[] to keep track 
        // of created nodes, initialize all entries 
        // as NULL 
        Node[] created = new Node[n]; 
        for (int i = 0; i < n; i++)  
            created[i] = null; 
   
        for (int i = 0; i < n; i++) 
            createNode(parent, i, created); 
   
        return root; 
    } 
   
    //For adding new line in a program 
    void newLine()  
    { 
        System.out.println(""); 
    } 
   
    // Utility function to do inorder traversal 
    void inorder(Node node)  
    { 
        if (node != null)  
        { 
            inorder(node.left); 
            System.out.print(node.key + " "); 
            inorder(node.right); 
        } 
    } 
    static int getLeafCount()  
    { 
        return getLeafCount(root); 
    } 
   
    static int getLeafCount(Node node)  
    { 
        if (node == null) 
            return 0; 
        if (node.left == null && node.right == null && node.midle == null) 
            return 1; 
        else
            return getLeafCount(node.left) + getLeafCount(node.midle) + getLeafCount(node.right); 
    } 
    // Driver method 
    public static void main(String[] args)  
    { 
   
        Demo tree = new Demo(); 
        int parent[] = new int[]{0,1,2,3,4,5}; 
        int n = parent.length; 
        Node node = tree.createTree(parent, n); 
        System.out.println("Inorder traversal of constructed tree "); 
        System.out.println(getLeafCount(node));
        tree.inorder(node); 
        tree.newLine(); 
    } 
} 
   