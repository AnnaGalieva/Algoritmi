package Lesson1;
//ханойская башня
public class Hanoy {

    public static void main(String args[])
    {
        int n = 3;
        towers(n, 'A', 'C', 'B');
    }
    static void towers(int n, char from, char to, char aux)
    {
        if (n == 1)
        {
            System.out.println("Move disk 1 from " +  from + " to  " + to);
            return;
        }
        towers(n-1, from, aux, to);
        System.out.println("Move disk " + n + " from " +  from + " to  " + to);
        towers(n-1, aux, to, from);
    }


}
