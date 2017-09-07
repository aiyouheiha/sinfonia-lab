package com.heiha.sinfonia.lab.util;

import java.util.*;

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
