import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.*;
public class Snake 
{
    private static ArrayList<Node> snakeBody;
    public Snake()
    {
        snakeBody = new ArrayList<>();
        snakeBody.add(new Node(80, 40));
        snakeBody.add(new Node(60, 40));
        snakeBody.add(new Node(40, 40));
        snakeBody.add(new Node(20, 40));
    }

    public void drawSnake(Graphics g)
    {
        g.setColor(Color.white);
        for(Node i : snakeBody)
        {
            g.fillRect(i.x, i.y, Main.CELL_SIZE, Main.CELL_SIZE);
        }
    }
    public ArrayList<Node> getSnakeBody()
    {
        return snakeBody;
    }
}
