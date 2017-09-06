# 并查集

> Union Find

------------------------------------------------------

```
/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/9/6 9:52<br>
 * <b>Author:</b> heiha<br>
 */
public class SimpleUnionFind {
    /**
     * Record subset id of each element under union find set.
     */
    private final int[] recorder;

    /**
     * Union find set size.
     */
    private final int setSize;

    /**
     * Subset number of union find set.
     */
    private int subsetNum;

    /**
     * A set of numbers from <code>0</code> to <code>size - 1</code>. <br>
     * Part of these numbers have relations, and wanna separate same relations into same subset. <br>
     * {@link SimpleUnionFind#recorder} will be initialized into each element has its id self as subset id. <br>
     * {@link SimpleUnionFind#setSize} will be initialized to be size.
     * {@link SimpleUnionFind#subsetNum} will be initialized to be size.
     *
     * @param size Union Find Set Size
     */
    public SimpleUnionFind(int size) {
        setSize = size;
        subsetNum = size;
        recorder = new int[size];
        for (int i = 0; i < size; i++) {
            recorder[i] = i;
        }
    }

    /**
     * Find group id of <code>target</code>
     * @param target element under union find set
     * @return
     */
    public int find(int target) {
        return recorder[target];
    }

    /**
     * Union <code>source</code> into subset of <code>target</code>
     *
     * @param source element under union find set
     * @param target element under union find set
     */
    public void union(int source, int target) {
        int sourceId = find(source);
        int targetId = find(target);
        if (sourceId == targetId)
            return;
        for (int i = 0; i < setSize; i++) {
            if (recorder[i] == sourceId)
                recorder[i] = targetId;
        }
        subsetNum--;
    }

    public int getSetSize() {
        return setSize;
    }

    public int getSubsetNum() {
        return subsetNum;
    }
}
```