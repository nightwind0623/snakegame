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
            int ans = 0;
            for(int i = 0; i < xDounts.length; i++)
            {
                xDounts[i] = scanner.nextInt();
            }
            for(int i = 0; i < yDounts.length; i++)
            {
                yDounts[i] = scanner.nextInt();
            }

            for(int i = 0; i < xDounts.length; i++)
            {
                for(int j = 0; i < yDounts.length; j++)
                {
                    if(yDounts[j] > xDounts[i])
                    {
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }     
    }
}
