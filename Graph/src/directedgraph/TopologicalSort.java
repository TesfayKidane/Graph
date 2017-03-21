package directedgraph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * This extension of DFS successfully outputs a topological ordering as long as
 * input graph is a DAG. If every vertex is reachable from the starting vertex,
 * the output will be a topological ordering of the entire graph; if not, it
 * will be a topological ordering of all vertices in the graph that are
 * reachable from the starting vertex. (As mentioned in the slides, this
 * approach can be improved so that all vertices are output in topologically
 * sorted order.)
 * 
 * IMPLEMENT
 */
public class TopologicalSort extends DepthFirstSearch {
	private Vertex[] sortedVertices;
	private Vertex topSortStartVertex = null;
	Stack<Vertex> inVertices;
	int currentLabel;
	HashMap<Integer, Vertex> topSortVisited;

	/**
	 * Assumption: g is a DAG. If not, there is no guarantee concerning the
	 * nature of the output.
	 */
	public TopologicalSort(Digraph g) {
		super(g);
		currentLabel = g.getVertices().size();
		topSortVisited = new HashMap<>();
		inVertices = new Stack<>();
		computeTopStartVertex();
	}
	
	public Vertex getTopSortStartVertex() {
		inVertices.pop();
		return topSortStartVertex;
	}
	
	protected void mainLoop() {

		while (!stack.isEmpty()) {
			Vertex v = null;
			v = nextUnvisitedAdjacent(stack.peek());
			if (v == null) {
				// no unvisited vertices adjacent to v
				v = stack.pop();
				processVertex(v);
			} else {
				setHasBeenVisited(v);
				processEdge(new DirectedEdge(stack.peek(), v));
				stack.push(v);
			}
		}
	}
	
	protected void handleInitialVertex() {
		if(startVertex != null){
			setHasBeenVisited(startVertex);
			stack.push(startVertex);
		}
	}
	
	protected void processVertex(Vertex w){		
		topSortVisited.put(currentLabel--, w);
	}
	
	public List<Vertex> getTopologicalOrdering() {
		// warning: will return null until this class has been implemented!
		int n = topSortVisited.size();
		sortedVertices = new Vertex[n];
		for(int i = 0; i < n; i++)
			sortedVertices[i] = topSortVisited.get(i + 1);
		return Arrays.asList(sortedVertices);
	}
	
	public Vertex nextUnvisited() {
		return inVertices.pop();
	}

	/**
	 * Finds, if possible, a vertex that has no in-vertices and sets this value
	 * in topSortStartVertex If not found, throws an IllegalStateException,
	 * indicating that the input graph is not a DAG.
	 */
	public void computeTopStartVertex() {
		// implement
		for (Vertex v : vertices) {
			if (graph.getInVertices(v).size() == 0) {
				inVertices.push(v);
			}
		}
		if(!inVertices.isEmpty())
			topSortStartVertex = inVertices.peek();
		else
			throw new IllegalStateException();
	}

}
