import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {
        Node nodeOne = new Node(31);
        Node nodeTwo = new Node(16);
        Node nodeThree = new Node(7);
        Node nodeFour = new Node(24);
        Node nodeFive = new Node(19);
        Node nodeSix = new Node(29);
        Node nodeSeven = new Node(45);

        addNode(nodeOne, nodeTwo);
        addNode(nodeOne, nodeThree);
        addNode(nodeOne, nodeFour);
        addNode(nodeOne, nodeFive);
        addNode(nodeOne, nodeSix);
        addNode(nodeOne, nodeSeven);

        printBreadthOrder(nodeOne);
        printPostOrder(nodeOne);

    }

    public static void addNode(Node root, Node newNode) {
        Node currentNode = root;
        boolean flag = false;
        do {
            if (newNode.getValue() < currentNode.getValue()) {
                if (currentNode.getLeftNode() == null) {
                    currentNode.setLeftNode(newNode);
                    flag = true;
                } else {
                    currentNode = currentNode.getLeftNode();
                }
            } else {
                if (currentNode.getRightNode() == null) {
                    currentNode.setRightNode(newNode);
                    flag = true;
                } else {
                    currentNode = currentNode.getRightNode();
                }
            }
        } while (flag == false);
    }

    public static void printBreadthOrder(Node root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            System.out.print(queue.peek().getValue() + " ");

            if (queue.peek().getLeftNode() != null) {
                queue.add(queue.peek().getLeftNode());
            }
            if (queue.peek().getRightNode() != null) {
                queue.add(queue.peek().getRightNode());
            }
            queue.remove();
        }
        System.out.println("");
    }

    public static void printPostOrder(Node node) {
        if (node == null) {
            return;
        }
        //left node
        printPostOrder(node.getLeftNode());
        //right node
        printPostOrder(node.getRightNode());
        //print node value
        System.out.print(node.getValue() + " ");
        System.out.println("");
    }
}
