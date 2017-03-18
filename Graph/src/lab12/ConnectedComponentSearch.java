package lab12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ConnectedComponentSearch extends DepthFirstSearch {

    List<Graph> components;
    private int componentNum = 0;
    HashMap<Integer, List<Vertex>> vertexComps = new HashMap<>();

    public ConnectedComponentSearch(Graph graph) {
        super(graph);
    }
    
    @Override
	protected void singleComponentLoop() {
    	List<Vertex> vers = vertexComps.get(componentNum);
    	if(vers == null)
    		vers = new ArrayList<>();
    	vers.add(stack.peek());
    	while(!stack.isEmpty()){
			Vertex v = nextUnvisitedAdjacent(stack.peek());
			
			if(v==null) stack.pop();
			else {
				setHasBeenVisited(v);
				processEdge(new Edge(stack.peek(),v));
				processVertex(v);
				stack.push(v);
				vers.add(v);
			}
		}
    	vertexComps.put(componentNum, vers);		
		componentNum++;
	}
    
    List<Graph> computeConnnectedComponents(){
    	start();
    	components = new ArrayList<>();
    	HashMap<Vertex, LinkedList<Vertex>> adjacencyList = graph.getAdjacencyList();
    	for(int i = 0; i < vertexComps.size(); i++) {
        	List<Edge> edges = new ArrayList<>();
        	List<Vertex> vs = vertexComps.get(i);
    		vs.forEach(u -> {
    			List<Vertex> listOfAdjacent = adjacencyList.get(u);
        		listOfAdjacent.forEach(v -> {
        			Edge edge = new Edge(u, v);
        			edges.add(edge);
        		});
    		});
    		Edge[] edgesArr = new Edge[edges.size()];
    		Graph gr = new Graph(edges.toArray(edgesArr));
    		components.add(gr);	
    	}
    	return components;
	}
    
	public int getComponentNum(){
		start();
    	return componentNum;
	}
}
