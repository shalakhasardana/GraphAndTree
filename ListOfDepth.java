import java.util.ArrayList;

public class ListOfDepth {

	public static void main(String[] args) {
		TreeNode node=TreeFunctions.createTree();
		 ArrayList<ArrayList<TreeNode>> alist=new ArrayList<ArrayList<TreeNode>>();
		 ListOfDepth obj=new ListOfDepth();
		 ArrayList<ArrayList<TreeNode>> a=obj.cal(alist,node,0);
		for(int i=0;i<a.size();i++) {
			for(int j=0;j<a.get(i).size();j++) {
				System.out.print(a.get(i).get(j).data + "   ");
			}
			System.out.println("");
		}

	}

	private ArrayList<ArrayList<TreeNode>> cal(ArrayList<ArrayList<TreeNode>> alist, TreeNode node, int level) {
		if(node==null) {
			return null;
		}
		if(level==alist.size()) {
			ArrayList<TreeNode> list=new ArrayList<TreeNode>();
			TreeNode temp=node;
			list.add(temp);
			alist.add(list);
		}else {
			alist.get(level).add(node);
		}
		cal(alist,node.left,level+1);
		cal(alist,node.right,level+1);
		return alist;
	}

}
