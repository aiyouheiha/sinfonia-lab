package com.heiha.sinfonia.lab.util;

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
