package Splay;

public class SplayTree<T extends Comparable<T>> {
    private Node<T> root;
    private int count;


    /**
     * Create splay tree with root node
     *
     * @param data
     */
    public SplayTree(T data) {
        this.root = new Node<T>(data);
        this.count++;
    }

    /**
     * Create splay tree without root node
     */
    public SplayTree() {
        this.root = null;
        this.count = 0;
    }

    public boolean insert(T data) {
        Node<T> insertNode = new Node(data);
        if (isEmpty()) {
            root = insertNode;
            count++;
            return true;
        }

        Node<T> current = root;
        while (!current.isLeaf()) {

        }

        splay(current);
        count++;
        return true;
    }

    public void splay(Node<T> node) {
        while (node.getData().compareTo(root.getData()) != 0) {
            if (node.getParent().isRoot()) {
                zig(node);
            }
        }
    }

    private void zig(Node<T> node) {
        if (node.isLeftSon()) {
            rightRotation(node);
        } else {
            leftRotation(node);
        }
    }

    private void leftRotation(Node<T> node) {
        root.setRightSon(node.getLeftSon());
        node.setLeftSon(root);
        root.setParent(node);
        setNewRoot(node);
    }

    private void rightRotation(Node<T> node) {
        root.setLeftSon(node.getRightSon());
        node.setRightSon(root);
        root.setParent(node);
        setNewRoot(node);
    }

    private void setNewRoot(Node<T> node) {
        this.root = node;
        this.root.setParent(null);
    }

    public boolean isEmpty() {
        return root == null;
    }
}
