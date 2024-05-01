import java.util.Scanner;

public class G310 
{
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
        {
            int[] xDounts = new int[scanner.nextInt()];
            int[] yDounts = new int[xDounts.length];
            for(int i = 0; i < xDounts.length; i++)
            {
                xDounts[i] = scanner.nextInt();
            }
            for(int i = 0; i < xDounts.length; i++)
            {
                yDounts[i] = scanner.nextInt();
            }

            for(int i : yDounts)
            {
                System.out.println(i);
            }
            for(int i : xDounts)
            {
                System.out.println(i);
            }

        }     
    }
}
