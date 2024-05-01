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
            for(int i : xDounts)
            {
                xDounts[i] = scanner.nextInt();
            }
            for(int i : yDounts)
            {
                yDounts[i] = scanner.nextInt();
            }
            
        }     
    }
}
