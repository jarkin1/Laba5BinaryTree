package BinaryTree;

public class Node<K extends Comparable, V> {
    private K key;
    private V value;
    private Node root;
    private Node left;
    private Node right;
    private StringBuilder inString;

    public Node() {
    }

    @Override
    public String toString() {
        inString = new StringBuilder();
        return walk(root);
    }

    private Node findNode(K k){
        Node temp = root;
        while (true) {
            if (temp == null) {
                return null;
            }
            if (temp.key.compareTo(k) == 0) {
                return temp;
            }
            if (temp.key.compareTo(k) < 0) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }

    }

    public String showNode(K k){
        inString = new StringBuilder();
        return walk(findNode(k));
    }

    public String find(K x) {
        Node temp = root;
        while (true) {
            if (temp == null) {
                return null;
            }
            if (temp.key.compareTo(x) == 0) {
                return temp.value.toString();
            }
            if (temp.key.compareTo(x) < 0) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
    }

    public void insert(K key, V value) {
        Node temp = root;
        while (true) {
            if (root == null) {
                Node newNode = new Node();
                newNode.key = key;
                newNode.value = value;
                root = newNode;
                return;
            }
            if (temp.key.compareTo(key) < 0) {
                if (temp.right == null) {
                    Node newNode = new Node();
                    newNode.key = key;
                    newNode.value = value;
                    temp.right = newNode;
                    return;
                } else {
                    temp = temp.right;
                }
            } if (temp.key.compareTo(key) > 0) {
                if (temp.left == null) {
                    Node newNode = new Node();
                    newNode.key = key;
                    newNode.value = value;
                    temp.left = newNode;
                    return;
                } else {
                    temp = temp.left;
                }
            }if (temp.key.compareTo(key) == 0){
                temp.value = value;
                return;
            }
        }
    }

    public void delete(K key){
        Node searchTemp = root;
        Node prevNode = null;
        while (true){
            if(root == null){
                return;
            }
            if(searchTemp.key.compareTo(key) == 0){
                break;
            }else{
                prevNode = searchTemp;
                if(searchTemp.key.compareTo(key) < 0){
                    searchTemp = searchTemp.right;
                } else {
                    searchTemp = searchTemp.left;
                }
            }

        }
        if(searchTemp == null){
            System.out.println("Not found");
            return;
        }
        if(searchTemp.right == null){
            if(prevNode == null){
                root = searchTemp.left;
            } else {
                if(searchTemp == prevNode.left){
                    prevNode.left = searchTemp.left;
                } else {
                    prevNode.right = searchTemp.right;
                }
            }
        }else {
            Node leftBridge = searchTemp.right;
            prevNode = null;
            while (leftBridge.left != null){
                prevNode = leftBridge;
                leftBridge = leftBridge.left;
            }
            if(prevNode != null){
                prevNode.left = leftBridge.right;
            } else {
                searchTemp.right = leftBridge.right;
            }
            searchTemp.key = leftBridge.key;
            searchTemp.value = leftBridge.value;
        }
    }

    private String walk(Node node){
        if (node!=null){
            walk(node.left);
            inString.append(node.value + " ");
            walk(node.right);
        }
        return inString.toString();
    }



}
