import java.util.List;
import java.util.Stack;

public class DirectedCycle {

    private int [] marked;

    private int[] used;
    /**
     * Циклы
     */
    private Stack<Integer> cycle;

    private Dependencies d;
    /**
     * Списки списков ( т.е. для каждой сущности есть список сущностей,
     * от которых она зависит)
     */
    private List<List<Integer>>  adj;

    public  DirectedCycle(Dependencies d)
    {
        this.d = d;
        adj = d.getAdj();
        used = new int[d.getMaxIdEntity()];
        marked = new int[d.getMaxIdEntity()];
        for (int i = 0; i < d.getMaxIdEntity(); ++i) {
           if (marked[i] == 0) {
               dfs(i);
           }
        }
    }
    /**
     * Рекурсивный метод нахождения цикла
     * @param v -  индентификатор
     */
    private  void dfs(int v)
    {
        marked[v] = 1;
        for ( int i = 0; i < adj.get(v).size();i++)
        {
            int to = adj.get(v).get(i);
            if (marked[to] == 0) {
                used[to] = v;
                dfs(to);
            } else if (marked[to] == 1) {
                int endCycle = v;
                int startCycle = to;
                findCycle(startCycle, endCycle);
            }
        }
        marked[v] = 2;
    }

    /**
     * Метод обработки найденных циклов
     * @param startCycle - начало цикла
     * @param endCycle - конец цикла
     */
    private void findCycle(int startCycle, int endCycle)
    {
        cycle = new Stack<Integer>();
        cycle.push(startCycle);
        for (int v=endCycle; v!=startCycle; v=used[v])
            cycle.push(v);
        cycle.push(startCycle);
            for (int i = cycle.size() - 1; i >= 0; --i) {
                System.out.print(cycle.get(i) + " ");
            }
        System.out.println();

    }
}
