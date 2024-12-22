package org.example;

import java.util.ArrayList;
import java.util.List;

public class BPlusTree {
    private Node root;
    private int degree;

    public BPlusTree(int degree) {
        this.degree = degree;
        this.root = new LeafNode();
    }

    public void insert(int key, Data data) {
        root.insert(key, data);
        if (root.isOverflow()) {
            root = root.split();
        }
    }

    public Data search(int key) {
        return root.search(key);
    }

    private abstract class Node {
        List<Integer> keys;

        Node() {
            this.keys = new ArrayList<>();
        }

        abstract void insert(int key, Data data);
        abstract Data search(int key);
        abstract boolean isOverflow();
        abstract Node split();
    }

    private class InternalNode extends Node {
        List<Node> children;
        InternalNode parent;

        InternalNode() {
            super();
            this.children = new ArrayList<>();
        }

        @Override
        void insert(int key, Data data) {
            int index = 0;
            while (index < keys.size() && key > keys.get(index)) {
                index++;
            }

            Node child = children.get(index);
            child.insert(key, data);

            if (child.isOverflow()) {
                Node splitNode = child.split();
                keys.add(index, splitNode.keys.get(0));
                children.add(index + 1, splitNode);
            }
        }

        @Override
        Data search(int key) {
            int index = 0;
            while (index < keys.size() && key > keys.get(index)) {
                index++;
            }

            Node child = children.get(index);
            return child.search(key);
        }

        @Override
        boolean isOverflow() {
            return keys.size() > degree;
        }

        @Override
        Node split() {
            InternalNode newInternalNode = new InternalNode();
            int mid = keys.size() / 2;

            newInternalNode.keys.addAll(keys.subList(mid, keys.size()));
            newInternalNode.children.addAll(children.subList(mid + 1, children.size()));
            keys.subList(mid, keys.size()).clear();
            children.subList(mid + 1, children.size()).clear();

            for (Node child : newInternalNode.children) {
                ((InternalNode) child).parent = newInternalNode;
            }

            return newInternalNode;
        }
    }

    private class LeafNode extends Node {
        List<Data> values;

        LeafNode() {
            super();
            this.values = new ArrayList<>();
        }

        @Override
        void insert(int key, Data data) {
            keys.add(key);
            values.add(data);
        }

        @Override
        Data search(int key) {
            int index = keys.indexOf(key);
            if (index != -1) {
                return values.get(index);
            } else {
                return null;
            }
        }

        @Override
        boolean isOverflow() {
            return keys.size() > degree;
        }

        @Override
        Node split() {
            LeafNode newLeafNode = new LeafNode();
            int mid = keys.size() / 2;
            newLeafNode.keys.addAll(keys.subList(mid, keys.size()));
            newLeafNode.values.addAll(values.subList(mid, values.size()));
            keys.subList(mid, keys.size()).clear();
            values.subList(mid, values.size()).clear();
            return newLeafNode;
        }
    }
}