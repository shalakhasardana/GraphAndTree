
public class CommonAncestors {
	public Integer getAncestors(TreeNode root,TreeNode node1,TreeNode node2) {
		if(!check(root,node1)){
			System.out.println( node1.data+" not found");
			return -1;
		}
		if(!check(root,node2)){
			System.out.println( node1.data+" not found");
			return -1;
		}
		
		return findAnscetors(root,node1,node2);
	}

	private Integer findAnscetors(TreeNode root, TreeNode node1, TreeNode node2) {
		if(root==null) {
			return null;
		}
		if(root.data==node1.data || root.data==node2.data) {
			return root.data;
		}
		Integer left=findAnscetors(root.left,node1,node2);
		Integer right=findAnscetors(root.right,node1,node2);
		if(left!=null && right!=null) {
			return root.data;
		}
		return left!=null?left:right;
		
		
	}

	private Boolean check(TreeNode root, TreeNode node) {
		if(root==null) {
			return false;
		}
		if(root.data==node.data) {
			return true;
		}
		return check(root.left,node) || check(root.right,node);
	}
    public static void main(String[] args) {
    	TreeNode root=new TreeNode(1);
    	root.addLeftNode(2);
    	root.addRightNode(3);
    	root.left.addLeftNode(4);
    	root.left.addRightNode(5);
    	root.right.addLeftNode(6);
    	root.right.addRightNode(7);
    	CommonAncestors obj=new CommonAncestors();
    	System.out.println(obj.getAncestors(root, root.left.left, root.left.right));
    	System.out.println(obj.getAncestors(root, root.left.left, root.right.left));
    	System.out.println(obj.getAncestors(root, root.right, root.left.left ));
    	System.out.println(obj.getAncestors(root, root.left, root.left.left ));
    	
	}

}
