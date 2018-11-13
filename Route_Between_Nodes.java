import java.util.ArrayList;

public class Route_Between_Nodes {
	public Boolean routeExists(GraphNode node1,GraphNode node2) {
		if(dfsUtil(node1,node2)) {return true;}
		return false;
	}

	private boolean dfsUtil(GraphNode node1, GraphNode node2) {
		node1.visit=true;
		ArrayList<GraphNode> graph=node1.neighbour;
		for(GraphNode g:graph) {
			if(g==node2) {
				return true;
			}
			if(g.visit) {
				continue;
			}
			if(!g.visit) {
				Boolean bool=dfsUtil(g,node2);
				if(bool==true) {
					return true;
				}
			}
		}
		return false;
	}
  
	
	public static void main(String[] args) {
		GraphNode g0=new GraphNode(0);
		GraphNode g1=new GraphNode(1);
		GraphNode g2=new GraphNode(2);
		GraphNode g3=new GraphNode(3);
        g0.addNeighbour(g2);
        g0.addDirectedNeighbour(g1);
        g1.addDirectedNeighbour(g2);
		g3.addDirectedNeighbour(g2);
		g3.addDirectedNeighbour(g3);
		Route_Between_Nodes obj=new Route_Between_Nodes();
		System.out.println(obj.routeExists(g2, g3));
	}
}
