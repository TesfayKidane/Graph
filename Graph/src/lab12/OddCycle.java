package lab12;

/**
 * This class determines whether a given Graph contains an odd cycle. It does
 * this by keeping track of the levels to which vertices belong in the BFS
 * rooted tree -- if any vertex is examined that has already been visited and is
 * at same level as the current vertex, there must be an odd cycle; otherwise
 * not.
 *
 */
public class OddCycle extends BreadthFirstSearch {
	public OddCycle(Graph g) {
            super(g);
	}

	public boolean hasOddCycle() {
		return false;
	}
}
