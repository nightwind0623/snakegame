import java.util.Scanner;

public class Sao
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(re(10, 100));
        System.out.println(Math.pow(5, 4));
    public static int re(int a, int b)
    {
        if(a % b == 0)
        {
            return b;
        }
        else 
        {
            return re(b, a % b);
        }
    }
}