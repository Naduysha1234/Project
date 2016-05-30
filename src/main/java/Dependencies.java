import java.util.ArrayList;
import java.util.List;


public class Dependencies {

    private  int maxIdEntity;
    private  int count;
    private List<List<Integer>>  adj;
    public Dependencies(int maxIdEntity)
    {
        this.maxIdEntity = maxIdEntity;
        this.count = 0;
        adj = new ArrayList<List<Integer>>();
        for (int v = 0; v < maxIdEntity; v++) {
            adj.add(v,new ArrayList<Integer>());
        }
    }

    public int getMaxIdEntity() {
        return maxIdEntity;
    }

    public int getCount() {
        return count;
    }

    public void addEdge( int v, int w) {
        adj.get(v).add(w);
        count++;
    }

    public List<List<Integer>> getAdj() {
        return adj;
    }

    public Iterable<Integer> adj(int index)
    {
        return adj.get(index);
    }

}
