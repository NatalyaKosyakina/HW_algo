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
            rebalance(root);
            root.red = false;
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
                    rebalance(root);
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

    private void rebalance(Node node){
        Node result = node;
        boolean imbalanced = true;
        while (imbalanced) {
            imbalanced = false;
            if (result.rightchild != null && result.rightchild.red &&
                    (result.leftchild == null || !result.red)) {
                imbalanced = true;
                result = rigthturn(result);
            }
            if (result.leftchild != null && result.red &&
                    result.leftchild.leftchild != null && result.leftchild.leftchild.red) {
                imbalanced = true;
                result = leftturn(result);
            }
            if (result.leftchild != null && result.red && result.rightchild != null && result.rightchild.red) {
                imbalanced = true;
                colorswap(result);
            }
        }
    }

    private Node leftturn(Node node){
        Node leftch = node.leftchild;
        Node middle = leftch.rightchild;
        leftch.rightchild = node;
        node.leftchild = middle;
        leftch.red = node.red;
        node.red = true;
        return leftch;
    }

    private Node rigthturn(Node node){
        Node rightch = node.rightchild;
        Node middle = rightch.leftchild;
        rightch.leftchild = node;
        node.rightchild = middle;
        rightch.red = node.red;
        node.red = true;
        return rightch;
    }

    private void colorswap(Node node){
        node.leftchild.red = false;
        node.rightchild.red = false;
        node.red = true;
    }
}
