import java.lang.reflect.Array;
import java.util.Arrays;
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
            Arrays.parallelSort(yDounts);
            int j = 0;
            int k = 0;
            //for(int i : yDounts)
            //{
            //    System.out.print(i+" ");
            //}
            while(j < xDounts.length && k < yDounts.length)
            {
                if(yDounts[k] > xDounts[j])
                {
                    ans++;
                    k++;
                    j++;
                }
                else
                {
                    k++;
                }
            }
            System.out.println(ans);

        }     
    }
}
