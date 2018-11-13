
public class Validate_BST {
	
	public Boolean isBst(TreeNode node) {
		int min=Integer.MIN_VALUE;
		int max=Integer.MAX_VALUE;
		return bstUtil(node,min,max);
		
	}

	private Boolean bstUtil(TreeNode node, int min, int max) {
		if(node==null) {
			return true;
		}
		if(min>=node.data || max<node.data ) {
			return false;
		}
		return bstUtil(node.left,min,node.data) && bstUtil(node.right,node.data,max) ;
	}

	public static void main(String[] args) {
		//Negative test case
		TreeNode node=new TreeNode(10);
		node.addLeftNode(0);
		node.addRightNode(25);
		node.left.addLeftNode(-1);
		node.left.addRightNode(21);
		node.right.addLeftNode(16);
		node.right.addRightNode(32);
		Validate_BST obj=new Validate_BST();
		System.out.println(obj.isBst(node));
		//Postive test case
		TreeNode node1=new TreeNode(10);
		node1.addLeftNode(-10);
		node1.addRightNode(19);
		node1.left.addLeftNode(-20);
		node1.left.addRightNode(0);
		node1.right.addLeftNode(17);
		Validate_BST obj1=new Validate_BST();
		System.out.println(obj1.isBst(node1));

	}

}
