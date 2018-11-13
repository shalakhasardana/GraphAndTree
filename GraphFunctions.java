import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphFunctions {
	 public static void main(String[] args) {
		 GraphFunctions graph=new GraphFunctions();
		 // GraphNode node=graph.createGraph();
		 //graph.getBFS(node);
		 //graph.getDFS(node);
		 
		 //Test for Tropological sort
		/* graph.createTropologicalGraph();
		 graph.getTropoSort();*/
		 
		 //Test for mother vertex
		 /*graph.createTropologicalGraph();
		 System.out.println("Is mother vertex on the node "+graph.getmotherVertex());*/
		 
/*		 //Test for cycle in directd graph
		 graph.createCyclicDirectedGraph();
		 System.out.println(graph.cycleInDirected());*/
		 
		 //Test for cycle in undirected graph
		 graph.createCyclicUnDirectedGraph();
		 System.out.println(graph.cycleFindingUnDirected());
		 
	 }
	ArrayList<GraphNode> alist=new ArrayList<GraphNode>();	
	
	public ArrayList<GraphNode> createCyclicDirectedGraph(){

		GraphNode g1=new GraphNode(1);
		GraphNode g2=new GraphNode(2);
		GraphNode g3=new GraphNode(3);
		GraphNode g4=new GraphNode(4);
		GraphNode g5=new GraphNode(5);
		GraphNode g6=new GraphNode(6);
		g1.addDirectedNeighbour(g2);
		g2.addDirectedNeighbour(g3);
		g1.addDirectedNeighbour(g3);
		g1.addDirectedNeighbour(g4);
		g4.addDirectedNeighbour(g5);
		g5.addDirectedNeighbour(g6);
		g6.addDirectedNeighbour(g4);
		
		alist.add(g1);
		alist.add(g2);
		alist.add(g3);
		alist.add(g4);
		alist.add(g5);
		alist.add(g6);
		return alist;
	}
	
	
	
	public GraphNode createGraph() {
		GraphNode g1=new GraphNode(1);
		GraphNode g2=new GraphNode(2);
		GraphNode g3=new GraphNode(3);
		GraphNode g4=new GraphNode(4);
		GraphNode g5=new GraphNode(5);
		GraphNode g6=new GraphNode(6);
/*		 Creates and returns this graph:
		 * 3 -- 1  -- 2 -- 5
		 *      |     |
		 *      4     6
		 
		g3.addNeighbour(g1);
		g1.addNeighbour(g4);
		g1.addNeighbour(g2);
		g2.addNeighbour(g6);
		g2.addNeighbour(g5);*/
		//2nd example
		g1.addNeighbour(g2);
		g1.addNeighbour(g5);
		g2.addNeighbour(g3);
		g3.addNeighbour(g4);
		g4.addNeighbour(g6);
		g6.addNeighbour(g5);
		return g1;
	}
	
	public ArrayList<GraphNode> createTropologicalGraph(){
		GraphNode g1=new GraphNode(1);
		GraphNode g2=new GraphNode(2);
		GraphNode g3=new GraphNode(3);
		GraphNode g4=new GraphNode(4);
		GraphNode g5=new GraphNode(5);
		GraphNode g6=new GraphNode(6);
		GraphNode g7=new GraphNode(7);
		g1.addDirectedNeighbour(g3);
		g2.addDirectedNeighbour(g3);
		g2.addDirectedNeighbour(g4);
		g3.addDirectedNeighbour(g5);
		g5.addDirectedNeighbour(g6);
		g6.addDirectedNeighbour(g7);
		g4.addDirectedNeighbour(g6);
		alist.add(g1);
		alist.add(g2);
		alist.add(g3);
		alist.add(g4);
		alist.add(g5);
		alist.add(g6);
		alist.add(g7);
		return alist;
		
	}
	//BFS
	public void getDFS(GraphNode node) {
			System.out.println(node.vertex);
			node.visit=true;
			ArrayList<GraphNode> alist=node.neighbour;
			for(GraphNode graph:alist) {
				if(!graph.visit) {
					getDFS(graph);
				}else {
					continue;
				}
			}
	}
	
    //DFS
	public void getBFS(GraphNode node) {
        ArrayDeque<GraphNode> aqueue=new ArrayDeque<GraphNode>();
        aqueue.add(node);
        getBFSUTIL(aqueue);
		}

	private void getBFSUTIL(ArrayDeque<GraphNode> aqueue) {
		while(!aqueue.isEmpty()) {
			GraphNode node=aqueue.removeFirst();
			node.visit=true;
			System.out.println(node.vertex);
			ArrayList<GraphNode> getNeighbour=node.neighbour;
			for(GraphNode graph:getNeighbour) {
				if(!graph.visit) {
					aqueue.addLast(graph);
					graph.visit=true;
				}
			}
			getBFSUTIL(aqueue);
		}
		
	}
	
	
	//Topological sort
	public void getTropoSort() {
		Set<GraphNode> set=new HashSet<GraphNode>();
		Stack<GraphNode> astack=new Stack<GraphNode>();
		for(GraphNode node:alist) {
			if(!set.contains(node))
			tropUtil(node,set,astack);
		}
		while(!astack.isEmpty()) {
			System.out.println(astack.pop().vertex);
		}
		
	}

	private void tropUtil(GraphNode node, Set<GraphNode> set, Stack<GraphNode> astack) {
			set.add(node);
			ArrayList<GraphNode> alist=node.neighbour;
			for(GraphNode graph:alist) {
				if(!set.contains(graph)) {
					tropUtil(graph,set,astack);
				}
			}
			astack.push(node);
			
	}
	
	//mother vertex
	public Boolean getmotherVertex() {
		Set<GraphNode> set=new HashSet<GraphNode>();
		Stack<GraphNode> astack=new Stack<GraphNode>();
		if(alist.isEmpty()) {
			System.out.println("There is no graph vertex");
			return false;
		}
		for(GraphNode node:alist) {
			if(!set.contains(node))
				tropUtil(node,set,astack);
		}
		
		GraphNode node=astack.pop();
		for(GraphNode graph:alist) {
			graph.visit=false;
		}
		getDFS(node);
	    System.out.println("checking mother vextex on node  "+node.vertex);
		Boolean check=false;
		for(GraphNode graph:alist) {
			if(!graph.visit) {
				return check;
			}
		}
		return true;
	}
    
	public ArrayList<GraphNode> createCyclicUnDirectedGraph(){
		GraphNode g1=new GraphNode(1);
		GraphNode g2=new GraphNode(2);
		GraphNode g3=new GraphNode(3);
		GraphNode g4=new GraphNode(4);
		GraphNode g5=new GraphNode(5);
	    g1.addNeighbour(g4);
	    g4.addNeighbour(g2);
	    g4.addNeighbour(g5);
	    g2.addNeighbour(g5);
	    g3.addNeighbour(g5);
		alist.add(g1);
		alist.add(g2);
		alist.add(g3);
		alist.add(g4);
		alist.add(g5);
		return alist;
	}

	
	//cycle finding in directed graph
	
	public Boolean cycleInDirected() {
		if(alist.isEmpty()) {
			System.out.println("There is no vertex in the graph");
			return false;
		}
		Set<GraphNode> whiteSet=new HashSet<GraphNode>();
		Set<GraphNode> greySet=new HashSet<GraphNode>();
		Set<GraphNode> blackSet=new HashSet<GraphNode>();
		for(GraphNode node:alist) {
			whiteSet.add(node);
		}
		for(GraphNode node:alist) {
			if(dfsUtil(node,whiteSet,greySet,blackSet)==true) {
			return true;
			}
		}
		
		return false;
		
	}

	private Boolean dfsUtil(GraphNode node, Set<GraphNode> whiteSet, Set<GraphNode> greySet, Set<GraphNode> blackSet) {
		moveTo(node,whiteSet,greySet);
		ArrayList<GraphNode> graph=node.neighbour;
		for(GraphNode g:graph) {
		if(blackSet.contains(g)) {
			continue;
		}
		if(greySet.contains(g)) {
			return true;
		}
		if(whiteSet.contains(g)) {
				if(dfsUtil(g,whiteSet,greySet,blackSet)) {
					return true;
				}
		}
		}
		moveTo(node,greySet,blackSet);
	
		return false;
	}

	private void moveTo(GraphNode node, Set<GraphNode> x, Set<GraphNode> y) {
		x.remove(node);
		y.add(node);
		
	}
	//cycle find in undirected graph using dfs
	
	public Boolean cycleFindingUnDirected() {
		DisjointSet obj = new DisjointSet();
		for(GraphNode node:alist) {
			//using dfs
			if(dfsUtilCycle(node,null)) {
				return true;
			}else {
				return false;
			}
		}
			/*//using disjoint
			obj.makeSet(node.vertex);
		}
		for(GraphNode node:alist) {
			if(dfsUtilCycle1(obj,node,null)) {
				return true;
			}else {
				return false;
			}
			return false;
		}*/
		return false;
			
		
		
	}
	private boolean dfsUtilCycle1(DisjointSet obj, GraphNode node,GraphNode parent) {
		  node.visit=true;
          ArrayList<GraphNode> graph=node.neighbour;
          for(GraphNode g:graph) {
        	  if (g.visit==true && g.vertex==parent.vertex) {
        		  continue;
        	  }
        	  if(obj.findSet(obj.aMap.get(node.vertex))==obj.findSet(obj.aMap.get(g.vertex))){
        		  return true;
        	  }
        	  obj.union(node.vertex, g.vertex);
        	  if(dfsUtilCycle1(obj,g,node)) {
        		  return true;
        	  }
        	  
          }
		return false;
	}

	private boolean dfsUtilCycle(GraphNode node, GraphNode parent) {
		node.visit=true;
		ArrayList<GraphNode> graph=node.neighbour;
		for(GraphNode g:graph) {
			if(!g.visit) {
				Boolean x=dfsUtilCycle(g,node);
				if(x) {
					return true;
				}
			}else if (g.visit==true && g.vertex!=parent.vertex) {
				return true;
			}else {
				continue;
			}
		}
		return false;
	}
	//cycle find in undirected graph using disjoint

	
	
	
}




