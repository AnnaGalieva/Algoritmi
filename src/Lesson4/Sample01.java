package Lesson4;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

    public class Sample01 {

        public static void main(String[] args) {

            ArrayList<Employee> list1 = new ArrayList<>();
            list1.add(new Employee());
            list1.add(new Employee());
            list1.add(new Employee());
            HashMap<Integer, String> list2 = new HashMap<>();

            list2.put(1, "Hello!");
            list2.put(2, "Hello!");
            list2.put(3, "Hello!");
            list2.put(1, "Hello!");

            MyHashTable<Integer, String> myHashTable = new MyHashTable<>();
            myHashTable.put(1, "Value 1");
            myHashTable.put(2, "Value 2");
            myHashTable.put(3, "Value 3");
            myHashTable.put(1, "Value 123456");
            myHashTable.remove(12);
            myHashTable.remove(2);
            myHashTable.remove(2);
            String value1 = myHashTable.get(3);
            String value2 = myHashTable.get(33);
        }

    }

    class Employee{

        public String Name;
}
