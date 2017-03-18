package lab12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import sun.misc.Queue;

//implement
public class BreadthFirstSearch extends AbstractGraphSearch {

	protected HashMap<Vertex, Vertex> visitedVertices = 
			new HashMap<Vertex, Vertex>();
		Graph graph;
		Queue<Vertex> queue;
		List<Vertex> vertices = null;
		Iterator<Vertex> iterator = null;	
		HashMap<Vertex,LinkedList<Vertex>> adjacencyList;
		protected int numVertices;
		public BreadthFirstSearch(Graph graph){
			queue = new Queue<Vertex>();
			this.graph=graph;
			vertices =graph.vertices;
			iterator = vertices.iterator();
			numVertices = vertices.size();
			//this is a copy, so we can modify it - O(n+m) to acquire this
			adjacencyList = graph.getAdjacencyList();
		}
		
	@Override
	protected boolean someVertexUnvisited() {
		return visitedVertices.size() < numVertices;
	}

	@Override
	protected void handleInitialVertex() {
		Vertex v = nextUnvisited();
		if(v != null){
			setHasBeenVisited(v);
			queue.enqueue(v);
		}
		
	}
	
	public boolean getHasBeenVisited(Vertex v) {
		return visitedVertices.containsKey(v);
	}
	public void setHasBeenVisited(Vertex v) {
		visitedVertices.put(v,v);
	}
	
	public Vertex nextUnvisited() {
		while(iterator.hasNext()){
			Vertex next = iterator.next();
			if(!visitedVertices.containsKey(next)){
				return next;
				
			}
		}
		return null;
	}

	@Override
	protected void singleComponentLoop() {
		while(!queue.isEmpty()){
			Vertex currV = null;
			try {
				currV = queue.dequeue();
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Vertex v = nextUnvisitedAdjacent(currV); 
			while(v != null) {				
				setHasBeenVisited(v);
				queue.enqueue(v);
				v = nextUnvisitedAdjacent(currV); 
			}
		}
	}

	@Override
	protected void additionalProcessing() {
		// TODO Auto-generated method stub
		
	}
	
	public Vertex nextUnvisitedAdjacent(Vertex v) {
		List<Vertex> listOfAdjacent = adjacencyList.get(v);
		Iterator<Vertex> it = listOfAdjacent.iterator();
		Vertex retVert = null;
		//this loop will visit each element matched with v in the adjacency list
		//ONLY ONCE, since whenever a list element is encountered, 
		//it is removed after processing 
		while(it.hasNext()) {
			Vertex u = it.next();
			if(visitedVertices.containsKey(u)) {
				it.remove();
			}
			if(!visitedVertices.containsKey(u)) {
				retVert = u;
				it.remove();
				return retVert;				
			}	
		}
		//unvisited adjacent vertex not found
		return retVert;  //returning null
	}

}
