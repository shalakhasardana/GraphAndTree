
public class IsSubTree {
	public Boolean isSubTree(TreeNode t1,TreeNode t2) {
		if(t1==null) {
			return false;
		}
		if(t2==null) {
			return true;
		}
		if(t1.data==t2.data) {
			if(isSubTreeUtil(t1,t2)) {
				return true;
			}
		}
		return isSubTree(t1.left,t2)||isSubTree(t1.right,t2);
	}

	private boolean isSubTreeUtil(TreeNode t1, TreeNode t2) {
		if(t1==null && t2==null) {
			return true;
		}else if(t1==null) {
			return false;
		}else if( t2==null) {
			return false;
		}
		if(t1.data!=t2.data) {
			return false;
		}
		return isSubTreeUtil(t1.left,t2.left) && isSubTreeUtil(t1.right,t2.right);
	}

	public static void main(String[] args) {
		TreeNode t1=new TreeNode(26);
		t1.addLeftNode(10);
		t1.addRightNode(3);
		t1.left.addLeftNode(4);
		t1.left.addRightNode(6);
		t1.left.left.addRightNode(30);
		t1.right.addRightNode(3);
		
		TreeNode t2=new TreeNode(10);
		t2.addLeftNode(4);
		t2.addRightNode(6);
		t2.left.addRightNode(30);
		IsSubTree obj=new IsSubTree();
		System.out.println(obj.isSubTree(t1, t2));
		

	}

}
