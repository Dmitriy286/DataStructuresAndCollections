package weightedGraphs.floyd;

public class DistanceParent {

    public int parentVert;
    public int distance;

    public DistanceParent(int parentVert, int distance) {
        this.distance = distance;
        this.parentVert = parentVert;
    }
}
