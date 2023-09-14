package org.example;

//class BinaryTree{
//    Node root;
//    class Node{
//        int value;
//        Node left;
//        Node right;
//        // color
//    }
//
//    public boolean insert(int value){
//        if(root == null){
//            root = new Node();
//            root.value = value;
//            return true;
//        }else{
//            insert(root, value);
//            //root = rebalance(root);
//        }
//        // root.color = BLACK
//    }
//
//    private boolean insert(Node node, int value){
//        if(node.value == value){
//            return false;
//        }else{
//            if(node.value < value){
//                if(node.right != null){
//                    insert(node.right, value);
//                    // node.right = Rebalance(node.right);
//                }else{
//                    node.right = new Node();
//                    node.right.value = value;
//                    // node.color = RED
//                    return true;
//                }
//            }else{
//                if(node.left != null){
//                    return insert(node.left, value);
//                    // Rebalance();
//                }else{
//                    node.left = new Node();
//                    node.left.value = value;
//                    // node.color = RED
//                    return true;
//                }
//            }
//        }
//    }
//
//    public boolean find(int value){
//        return find(root, value);
//    }
//
//    private boolean find(Node node, int value){
//        if(node == null){
//            return false;
//        }
//        if(node.value == value){
//            return true;
//        }
//
//        if(node.value < value){
//            return find(node.right, value);
//        }else{
//            return find(node.left, value);
//        }
//    }
//}
