package Lesson3.dz;

public class Sample01 {
}
// Узел двусвязного списка
class Node
{
    int data;
    Node next, prev;

    public Node(int data)
    {
        this.data = data;
        this.next = this.prev = null;
    }
}

class Main
{
    // Вспомогательная функция для помещения узла в начало двусвязного списка
    public static Node push(Node head, int key)
    {
        Node node = new Node(key);
        node.next = head;

        // изменить `prev` существующего головного узла, чтобы он указывал на новый узел
        if (head != null) {
            head.prev = node;
        }

        // обновить голову и вернуться
        head = node;
        return head;
    }

    // Вспомогательная функция для вывода узлов двусвязного списка
    public static void printDDL(String msg, Node head)
    {
        System.out.print(msg);
        while (head != null)
        {
            System.out.printf("%d —> ", head.data);
            head = head.next;
        }

        System.out.println("null");
    }

    // Функция для замены указателей `next` и `prev` данного узла
    public static void swap(Node node)
    {
        Node prev = node.prev;
        node.prev = node.next;
        node.next = prev;
    }

    // Рекурсивная функция для обращения двусвязного списка
    public static Node reverse(Node head, Node curr)
    {
        // последний узел
        if (curr.next == null)
        {
            // поменять местами указатели `next` и `prev` для текущего узла
            swap(curr);

            // обновить заголовок
            head = curr;
            return head;
        }

        // поменять местами указатели `next` и `prev` для текущего узла
        swap(curr);

        // повторяем со следующим узлом
        head = reverse(head, curr.prev);
        return head;
    }

    // Функция для реверсирования двусвязного списка
    public static Node reverseDDL(Node head)
    {
        // базовый вариант
        if (head == null) {
            return head;
        }

        // сохраняет предыдущий узел и текущий узел
        Node curr = head;

        // передать текущую и предыдущую информацию об узле в самой рекурсии
        head = reverse(head, curr);
        return head;
    }

    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3, 4, 5 };

        Node head = null;
        for (int key: keys) {
            head = push(head, key);
        }

        printDDL("Original list: ", head);
        head = reverseDDL(head);
        printDDL("Reversed list: ", head);
    }
}