package lab12;

import java.util.List;

import junit.framework.TestCase;

public class Tests extends TestCase {
	public void testConnectedComponents1() {
		List<Pair> edges = TestData.getTestData1();
		Graph g = new Graph(edges);
		//Expect two connected components
		List<Graph> components = g.getConnectedComponents();
		assertEquals("Expected two components", 2, components.size());
		List<Graph> components0 = components.get(0).getConnectedComponents();
		assertEquals("Expected this component is itself connected", 1, components0.size());
	}
	public void testConnectedComponents2() {
		List<Pair> edges = TestData.getTestData2();
		Graph g = new Graph(edges);
		//Expect one connected component
		List<Graph> components = g.getConnectedComponents();
		assertEquals("Expected one component", 1, components.size());
    }
	public void testConnectedComponents3() {
		List<Pair> edges = TestData.getTestData3();
		Graph g = new Graph(edges);
		//Expect one connected component
		List<Graph> components = g.getConnectedComponents();
		assertEquals("Expected one component", 1, components.size());	
	}
	public void testConnectedComponents4() {
		List<Pair> edges = TestData.getTestData4();
		Graph g = new Graph(edges);
		//Expect one connected component
		List<Graph> components = g.getConnectedComponents();
		assertEquals("Expected one component", 1, components.size());
	}
	public void testConnectedComponents5() {
		List<Pair> edges = TestData.getTestData5();
		Graph g = new Graph(edges);
		//Expect one connected component
		List<Graph> components = g.getConnectedComponents();
		assertEquals("Expected two components", 2, components.size());
	}
	
	////////// Odd Cycle Tests
	
	public void testOddCycle1() {
		//Two connected components, with odd cycle
		List<Pair> edges = TestData.getTestData1();
		Graph g = new Graph(edges);
		OddCycle oc = new OddCycle(g);
		assertTrue(oc.hasOddCycle());
		
		
	}
	public void testOddCycle2() {
		//One connected component, a tree
		List<Pair> edges = TestData.getTestData2();
		Graph g = new Graph(edges);
		OddCycle oc = new OddCycle(g);
		assertFalse(oc.hasOddCycle());
    }
	public void testOddCycle3() {
		//One connected component, an even cycle
		List<Pair> edges = TestData.getTestData3();
		Graph g = new Graph(edges);
		OddCycle oc = new OddCycle(g);
		assertFalse(oc.hasOddCycle());	
	}
	public void testOddCycle4() {
		//Single edge -- so no odd cycle, one connected component
		List<Pair> edges = TestData.getTestData4();
		Graph g = new Graph(edges);
		OddCycle oc = new OddCycle(g);
		assertFalse(oc.hasOddCycle());	
	}
	public void testOddCycle5() {
		//Two connected components, with odd cycle
		List<Pair> edges = TestData.getTestData5();
		Graph g = new Graph(edges);
		OddCycle oc = new OddCycle(g);
		assertTrue(oc.hasOddCycle());	
	}
}
