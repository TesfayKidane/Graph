package lab12;

//implement
import java.util.List;

public class ConnectedComponentSearch extends DepthFirstSearch {

    List<Graph> conGrap;
    private int componentNum = 0;

    public ConnectedComponentSearch(Graph graph) {
        super(graph);
    }

    List<Graph> computeConnnectedComponents() {
        //implement here
        return conGrap;
    }

    public int getComponentNum() {
        return componentNum;
    }
}
