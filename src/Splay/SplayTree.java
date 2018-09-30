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
        boolean result = false;
        Node<T> insertNode = new Node(data);
        if (isEmpty()) {
            root = insertNode;
            count++;
            return true;
        }

        Node<T> current = root;
        while (!current.isLeaf()|| current.isRoot()) {
            if (current.getData().compareTo(insertNode.getData()) == 0) {
                result = false;
                break;
            }
            // vkladany prvok je "mensi"
            if (current.getData().compareTo(insertNode.getData()) == -1) {
                // ak nema laveho syna tak mu ho nastav na vkladany prvok
                if (current.getLeftSon() == null) {
                    current.setLeftSon(insertNode);
                    insertNode.setParent(current);
                    current = insertNode;
                    count++;
                    result = true;
                } else {
                    current = current.getLeftSon();
                }
            } else {
                // ak nema praveho syna tak mu ho nastav na vkladany prvok
                if (current.getRightSon() == null) {
                    current.setRightSon(insertNode);
                    insertNode.setParent(current);
                    current = insertNode;
                    count++;
                    result = true;
                } else {
                    current = current.getRightSon();
                }
            }
        }
        splay(current);
        return result;
    }

    public void splay(Node<T> node) {
        while (node.getData().compareTo(root.getData()) != 0) {
            if (node.getParent().isRoot()) {
                if (node.isLeftSon()) {
                    zig(node);
                } else {
                    zag(node);
                }
            }
        }
    }

    private void zig(Node<T> node) {
        rightRotation(node);
    }

    private void zag(Node<T> node) {
        leftRotation(node);
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
