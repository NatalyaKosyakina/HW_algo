package org.example;

public class RedBlackTree<T extends Comparable<T>>{
    private Node root;
    private class Node<T extends Comparable<T>> {
        private T value;
        private boolean red = true;
        private Node leftchild;
        private Node rightchild;
    }
    public void insert(T value){
        if (root == null) {
            root = new Node();
            root.value = value;
            root.red = false;
        }
        else {
            add(value, root);
        }
    }
    private boolean add(T value, Node node){
        if (node.value.compareTo(value) == 0){
            return false;
        } else {
            if (node.value.compareTo(value) > 0) {
                if (node.leftchild == null) {
                    node.leftchild = new Node();
                    node.leftchild.value = value;
                    return true;
                } else {
                    add(value, node.leftchild);
                }
            } else {
                if (node.rightchild != null) {
                    add(value, node.rightchild);
                    // Rebalance();
                } else {
                    node.rightchild = new Node();
                    node.rightchild.value = value;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(T value){
        return find(value, root);
    }

    private boolean find(T value, Node node){
        if (node == null){
            return false;
        }
        if (node.value.compareTo(value) == 0){
            return true;
        }
        if (node.value.compareTo(value) > 0){ // если искомое значение меньше значения текущего узла
            return find(value, node.leftchild);
        } else {return find(value, node.rightchild);}
    }
}
