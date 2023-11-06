package org.example;

import java.util.List;

public class Tree<T extends  Comparable<T>> {
    private Node<T> root;
    public Tree() {
        root = null;
    }
    public Tree(T data) {
        root = new Node<T>(data);
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void Insert(T data)
    {
        setRoot(InsertRec(root, data));
    }

    public void Insert(List<T> data)
    {
        for (T item:data) {
            setRoot(InsertRec(root, item));
        }
    }

    public Node<T> InsertRec(Node currentNode, T data)
    {
        if(currentNode == null)
        {
            currentNode = new Node<>(data);
        }
        else {
            //Value inserted is less than current node data
            if(currentNode.getData().compareTo(data) > 0)
            {
                //set the left
                currentNode.setLeft(InsertRec(currentNode.getLeft(), data));
            }
            //Value inserted is greater than current node data
            else if (currentNode.getData().compareTo(data) < 0) {
                // set the right
                currentNode.setRight(InsertRec(currentNode.getRight(), data));
            }
        }
        return currentNode;
    }
}
