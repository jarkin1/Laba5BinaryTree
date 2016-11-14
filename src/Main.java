import BinaryTree.Node;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Node<Integer, String> node = new Node<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть речення по елементно:");
        for(int i = 1; i < 6; i++){
            node.insert(i, sc.next());
        }


        System.out.println(node);
        System.out.println();
        System.out.println("Підмет: " + node.find(2));
        System.out.println("Присудок: " + node.find(3));

        System.out.println("Піддерево підмета: " + node.showNode(2));
        System.out.println("Піддерево присудка: " + node.showNode(3));
    }
}
