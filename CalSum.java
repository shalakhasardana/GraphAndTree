
public class CalSum {
	
	public void calSum(TreeNode node,int sum) {
		TreeFunctions obj=new TreeFunctions();
		int height=obj.getHeight(node);
		int[] array=new int[height];
		calSumHelper(node,sum,height,array,0);
		
	}

	private void calSumHelper(TreeNode node, int sum, int height, int[] array, int level) {
		if(height<level||node==null) {
			return;
		}
		array[level]=node.data;
		int count=0;
			for(int i=level;i>=0;i--) {
				count=count+array[i];
				if(count==sum) {
					print(array,i,level);
				}
			}
			
			calSumHelper(node.left,sum,height,array,level+1);
			calSumHelper(node.right,sum,height,array,level+1);
		
	}

	private void print(int[] array, int start, int end) {
		for(int i=start;i<=end;i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		node.addLeftNode(3);
		node.addRightNode(-1);
		node.left.addLeftNode(2);
		node.left.addRightNode(1);
		node.left.right.addLeftNode(1);
		node.right.addLeftNode(4);
		node.right.addRightNode(5);
		node.right.left.addLeftNode(1);
		node.right.left.addRightNode(2);
		node.right.addRightNode(5);
		node.right.right.addRightNode(6);
		CalSum obj=new CalSum();
		obj.calSum(node,5);

	}

}
