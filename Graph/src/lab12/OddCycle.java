package lab12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * This class determines whether a given Graph contains an odd cycle. It does
 * this by keeping track of the levels to which vertices belong in the BFS
 * rooted tree -- if any vertex is examined that has already been visited and is
 * at same level as the current vertex, there must be an odd cycle; otherwise
 * not.
 *
 */
public class OddCycle extends BreadthFirstSearch {
	
	HashMap<Integer, List<Vertex>> vertexLevel = new HashMap<>();
	boolean isOddCycle = false;
	int currentLevel = 0;
	
	public OddCycle(Graph g) {
		super(g);
	}

	@Override
	protected void handleInitialVertex() {
		Vertex v = nextUnvisited();
		if(v != null){
			setHasBeenVisited(v);
			queue.enqueue(v);
			List<Vertex> l = new ArrayList<>();
			l.add(v);
			vertexLevel.put(0, l);
		}		
	}
	
	@Override
	protected void singleComponentLoop() {
		while(!queue.isEmpty()){
			Vertex currV = null;
			try {
				currV = queue.dequeue();
				currentLevel++;
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			Vertex v = nextUnvisitedAdjacent(currV); 
			while(v != null) {				
				setHasBeenVisited(v);				
				queue.enqueue(v);
				List<Vertex> vs = vertexLevel.get(currentLevel);
				if(vs != null && !isOddCycle)
					checkOddCycle(v, vs);
				if(vs == null)
					vs = new ArrayList<>();
				vs.add(v);
				vertexLevel.put(currentLevel, vs);
				v = nextUnvisitedAdjacent(currV); 
			}
		}
	}
		
	public void checkOddCycle(Vertex v, List<Vertex> vs) {
		HashMap<Vertex, LinkedList<Vertex>> adjacencyList = graph.getAdjacencyList();
		List<Vertex> listOfAdjacent = adjacencyList.get(v);
		listOfAdjacent.forEach(u -> {
			vs.forEach(w -> {
				if(u.equals(w))
					isOddCycle = true;
			});
		});
	}
	
	public boolean hasOddCycle() {
		start();
		return isOddCycle;
	}
}