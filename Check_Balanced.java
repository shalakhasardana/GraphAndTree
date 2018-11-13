
public class Check_Balanced {

	public int isBalanced(TreeNode node) {
		if(node==null) {
			return 0;
		}
		int leftHeight=isBalanced(node.left);
		if(leftHeight==-1) {
			return -1;
		}
		int rightHeight=isBalanced(node.right);
		if(rightHeight==-1) {
			return -1;
		}
		int difference=Math.abs(leftHeight)-Math.abs(rightHeight);
		if(difference>=2) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight)+1;
	
	}
	

	private int calHeight(TreeNode node) {
		if(node==null) {
			return 0;
		}
		return Math.max(calHeight(node.left), calHeight(node.right))+1;
	}


	public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		node.addLeftNode(3);
		node.addRightNode(-1);
		node.left.addLeftNode(2);
		node.left.addRightNode(1);
		node.left.right.addLeftNode(1);
		//node.left.right.left.addRightNode(8);
		node.right.addRightNode(5);
		Check_Balanced obj=new Check_Balanced();
		if(obj.isBalanced(node)==-1) {
			System.out.println("false");
		}else {
			System.out.println("true");
		}

	}
/*public static void main(String[] args) {
		

	}*/

}
