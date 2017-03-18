package lab12;
import java.util.Arrays;
import java.util.List;

public class TestData {
	public static List<Pair> getTestData1() {
		//Two connected components, with odd cycle
		Pair[] pairs = new Pair[]{new Pair("A","B"),
				new Pair("B","C"), new Pair("A","C"),
				new Pair("D","E"), new Pair("D","F")};
		return Arrays.asList(pairs);
	}
	public static List<Pair> getTestData2() {
		//One connected component, a tree
		Pair[] pairs = new Pair[]{new Pair("A","B"),
				new Pair("B","C"), new Pair("C","D"),
				new Pair("D","E"), new Pair("A","F")};
		return Arrays.asList(pairs);
	}
	public static List<Pair> getTestData3() {
		//One connected component, an even cycle
		Pair[] pairs = new Pair[]{new Pair("A","B"),
				new Pair("B","C"), new Pair("C","D"),
				new Pair("A","D")};
		return Arrays.asList(pairs);
		
	}
	public static List<Pair> getTestData4() {
		//Single edge -- so no odd cycle, one connected component
		Pair[] pairs = new Pair[]{new Pair("A","B")};
		return Arrays.asList(pairs);	
	}
	
	public static List<Pair> getTestData5() {
		//Two connected components, with odd cycle
		Pair[] pairs = new Pair[]{new Pair("A","B"),
				new Pair("B","D"), new Pair("D","F"),
				new Pair("E","F"),new Pair("B","C"), new Pair("A","C"),
				new Pair("G","H")};
		return Arrays.asList(pairs);
		
	}
}
