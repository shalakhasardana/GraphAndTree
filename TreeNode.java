
public class TreeNode {
	int data;
	TreeNode left=null;
	TreeNode right=null;
	TreeNode parent=null;
	TreeNode(int data){
		this.data=data;
	}
	
	public void addLeftNode(int data) {
		TreeNode temp=new TreeNode(data);
		left=temp;
		left.parent=this;
	}
	public void addRightNode(int data) {
		TreeNode temp=new TreeNode(data);
		right=temp;
		right.parent=this;
	}
	
	

}
