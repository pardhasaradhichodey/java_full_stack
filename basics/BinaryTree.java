class Node {
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class BinaryTree {
    Node root;
    
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.right = new Node(9);
        tree.root.right.left= new Node(6);
        tree.root.right.right=new Node(8);
        tree.root.right.left.right = new Node(7);
        System.out.println("Height of tree is " + tree.maximumDepth(tree.root));
    }
    int maximumDepth(Node node)
    {
        if (node == null)
            return 0;
        else {
            int depthOnRight = maximumDepth(node.right); 
            int depthOnLeft = maximumDepth(node.left);
            
            if (depthOnLeft > depthOnRight)
                return (depthOnLeft + 1);
            else
                return (depthOnRight + 1);
        }
    }
}