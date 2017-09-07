# 并查集

> Union Find

------------------------------------------------------

- [简单实现](#简单实现)
- [进阶](#进阶)
    - [并查集接口](#并查集接口)
    - [实现：树](#实现：树)

------------------------------------------------------

## 简单实现

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

------------------------------------------------------

## 进阶

### 并查集接口

```
/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/9/6 13:47<br>
 * <b>Author:</b> heiha<br>
 */
public interface UnionFind<E> {
    /**
     * If not under one subset, make element <code>e</code> a new subset
     * @param e element to be made set
     */
    void makeSet(E e);

    /**
     * Find element <code>e</code> from set, return its subset id (which is one element represent current subset).
     * @param e element to be found
     * @return subset id
     */
    E find(E e);

    /**
     * Merge subset of element <code>from</code> into subset of <code>to</code>
     * @param from element <code>from</code>
     * @param to element <code>to</code>
     */
    void union(E from, E to);
}
```

### 实现：树

```
/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/9/6 14:06<br>
 * <b>Author:</b> heiha<br>
 */
public class UnionFindImpl<E> implements UnionFind<E> {
    private final Map<E, ElementInfo<E>> recorder;
    private final int size;
    private int subsetNum;

    public UnionFindImpl(Set<E> set) {
        size = set.size();
        subsetNum = size;
        recorder = new HashMap<>(size);
        Iterator<E> iterator = set.iterator();
        while (iterator.hasNext()) {
            E e = iterator.next();
            makeSet(e);
        }
    }

    @Override
    public void makeSet(E e) {
        if (e != null && !recorder.containsKey(e)) {
            ElementInfo<E> elementInfo = new ElementInfo<>();
            elementInfo.parent = e;
            recorder.put(e, elementInfo);
        }
    }

    @Override
    public E find(E e) {
        if (recorder.containsKey(e)) {
            if (recorder.get(e).parent.equals(e))
                return e;
            return find(recorder.get(e).parent);
        }
        return null;
    }

    @Override
    public void union(E from, E to) {
        E fromRoot = find(from);
        E toRoot = find(to);
        ElementInfo<E> fromElementInfo = recorder.get(fromRoot);
        if (fromElementInfo.parent.equals(toRoot))
            return;
        recorder.get(fromRoot).parent = toRoot;
        subsetNum--;
    }

    public int getSubsetNum() {
        return subsetNum;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<E, ElementInfo<E>> entry: recorder.entrySet()) {
            sb.append(entry.getKey()).append(": ")
                    .append(entry.getValue().parent).append("\n");
        }
        return sb.toString();
    }

    public static class ElementInfo<E> {
        protected E parent;
    }
}
```

