
public class Minimal_Tree {
	static TreeNode root;
	public TreeNode createMinimalTree(int a[],int start,int end) {
		if(start>end) {
			return null;
		}
		int size=(start+end)/2;
		TreeNode node =new TreeNode(a[size]);
		node.left=createMinimalTree(a,start,size-1);
		node.right=createMinimalTree(a,size+1,end);
		return node;
		
	}
	public static void main(String[] args) {
		int arr[] = new int[]{1, 2, 3, 4};
		int n=arr.length-1;
		Minimal_Tree obj=new Minimal_Tree();
		root=obj.createMinimalTree(arr, 0, n);
		TreeFunctions obj1=new TreeFunctions();
		obj1.printInOrderTraversal(root);
		
		
	}

}
