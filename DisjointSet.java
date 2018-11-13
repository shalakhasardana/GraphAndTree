import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
	Map<Integer,DisjointNode> aMap=new HashMap<Integer,DisjointNode>();
	public void makeSet(int data) {
		DisjointNode obj=new DisjointNode();
		obj.data=data;
		obj.rank=0;
		obj.parent=obj;
		aMap.put(obj.data, obj);
	}
	
	public DisjointNode findSet(DisjointNode node) {
		if(node.parent.data==node.data) {
		return node;
		}
		DisjointNode x=findSet(node.parent);
		return x;
	}
	
	public void union(int vertex,int vertex2) {
		DisjointNode node1=aMap.get(vertex);
		DisjointNode node2=aMap.get(vertex2);	
		DisjointNode parent1=findSet(node1);
		DisjointNode parent2=findSet(node2);
		if(parent1==parent2) {
			return;
		}
		if(parent1.rank==parent2.rank) {
			parent1.rank=parent1.rank+1;
			parent2.parent=parent1;
		}else if(parent1.rank>parent2.rank) {
			parent2.parent=parent1;
		}else {
			parent1.parent=parent2;
		}
	}
	 public long findSet(int data) {
		 return findSet(aMap.get(data)).data;
	 }
	 
	 public static void main(String[] args) {
		 DisjointSet obj=new DisjointSet();
		 for(int i=1;i<8;i++) {
		 obj.makeSet(i);
		 }
		 obj.union(1,2);
		 obj.union(2,3);
		 obj.union(4,5);
		 obj.union(6,7);
		 obj.union(5,6);
	//	 obj.union(3,7);
		 for(int i=1;i<8;i++) {
			 System.out.println(obj.findSet(i));
			 }
		 
	 }
	
	
}
