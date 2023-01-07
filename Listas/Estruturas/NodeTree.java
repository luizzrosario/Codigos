package Estruturas;

public class NodeTree<T extends Comparable<T>> implements Comparable<T>  {
    public NodeTree(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.father = null;
    }

    public T data;
    public NodeTree<T> left;
    public NodeTree<T> right;
    public NodeTree<T> father;

    public NodeTree(T data, NodeTree<T> left, NodeTree<T> right, NodeTree<T> father) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.father = father;
    }

    @Override
    public int compareTo(T o) {
        return this.data.compareTo(o);
    }
}
