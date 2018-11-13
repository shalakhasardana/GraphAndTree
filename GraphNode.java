import java.util.ArrayList;

public class GraphNode {
	int vertex;
	ArrayList<GraphNode> neighbour;
	Boolean visit;
	GraphNode(int data){
		vertex=data;
		neighbour=new ArrayList<GraphNode>();
		visit=false;
	}
	
	public void visited() {
		visit=true;
	}
	public void addNeighbour(GraphNode graph) {
		neighbour.add(graph);
		graph.neighbour.add(this);
	}
	public void addDirectedNeighbour(GraphNode graph) {
		neighbour.add(graph);
	}

}
