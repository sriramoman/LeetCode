package Session1;

import java.util.Arrays;

class GraphNode {
    int id;
    int[] adjacency;

    GraphNode(int id, int[] adjacent) {
        this.id = id;
        this.adjacency = Arrays.copyOf(adjacent, adjacent.length);
    }
}

public class GraphSearchDriver {
    public static void main(String[] args) {
        //code

    }
}
