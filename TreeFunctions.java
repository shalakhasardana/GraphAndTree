
public class TreeFunctions {
	/* Creates and returns this Tree:
	 *          5
	 *        /   \
	 *       1    -3
	 *      /     / \
	 *     0     2   4
	 */
	public static TreeNode createTree() {
		TreeNode root=new TreeNode(5);
		root.addLeftNode(1);
		root.addRightNode(-3);
		root.left.addLeftNode(0);
		root.right.addLeftNode(2);
		root.right.addRightNode(4);
		return root;
	}
	
	
	
	/* Creates and returns this binary search tree:
	 *          5
	 *        /   \
	 *       1     8
	 *      /     / \
	 *     0     6   9
	 */
	public static TreeNode createBST() {
		TreeNode root=new TreeNode(5);
		root.addLeftNode(1);
		root.addRightNode(8);
		root.left.addLeftNode(0);
		root.right.addLeftNode(6);
		root.right.addRightNode(9);
		return root;
	}
	
	
	//Print Inorder Travesal
	
	public void printInOrderTraversal(TreeNode node) {
		if(node==null) {
			return;
		}
		printInOrderTraversal(node.left);
		System.out.println(node.data);
		printInOrderTraversal(node.right);
		
	}
	//Print post order Traversal
	public void printPostOrderTraversal(TreeNode node) {
		if(node==null) {
			return;
		}
		printPostOrderTraversal(node.left);
		printPostOrderTraversal(node.right);
		System.out.println(node.data);
		
	}
	//Print pre order travesral
	public void printPreOrderTraversal(TreeNode node) {
		if(node==null) {
			return;
		}
		System.out.println(node.data);
		printPreOrderTraversal(node.left);
		printPreOrderTraversal(node.right);
		
	}
	//print level order Traversal
	public int getHeight(TreeNode node) {
		if(node==null) {
			return 0;
		}
		return Math.max(getHeight(node.left), getHeight(node.right))+1;
		
	}

}
