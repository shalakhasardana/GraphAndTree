
public class InorderSuccessor {
	public static TreeNode calInorder(TreeNode node) {
		if(node==null) {
			return null;
		}
		if(node.right!=null) {
			TreeNode temp=node.right;
			while(temp.left!=null) {
				temp=temp.left;
			}
			return temp;
		}else {
		
		TreeNode parent=node.parent;
		if(parent.left==node) {
			return parent;
		}else {
			while(parent!=null && parent.right==node) {
				node=parent;
				parent=node.parent;
			}
			return parent;
		}	
		}
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(20);
		root.addLeftNode(8);
		root.addRightNode(22);
		root.left.addLeftNode(4);
		root.left.addRightNode(12);
		root.left.right.addLeftNode(10);
		root.left.right.addRightNode(14);
		root.right.addLeftNode(22);
		System.out.println(calInorder(root.right));
     
	}

}
