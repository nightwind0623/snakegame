import java.awt.*;

public class Fruit 
{ 
    private int x; 
    private int y;
    public Fruit()
    {
        this.x = (int)(Math.floor(Math.random() * Main.row) * Main.CELL_SIZE);
        this.y = (int)(Math.floor(Math.random() * Main.column) * Main.CELL_SIZE);
    }
    public void drawFood(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(this.x, this.y, Main.CELL_SIZE, Main.CELL_SIZE);
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
    public void setNewLocation(Snake s)
    {
        int newX;
        int newY;
        boolean overlapping;
        do 
        {
            newX = (int)(Math.floor(Math.random() * Main.row) * Main.CELL_SIZE);
            newY = (int)(Math.floor(Math.random() * Main.column) * Main.CELL_SIZE);
            overlapping = checkOverlapping(newX, newY, s);
        } while (overlapping);

        x = newX;
        y = newY;
    }
    private boolean checkOverlapping(int x, int y, Snake s)
    {
        for(int i = 0; i < s.getSnakeBody().size(); i++)
        {
            if(x == s.getSnakeBody().get(i).x || y == s.getSnakeBody().get(i).y )
            {
                return true;
            }
        }
        return false;
    }
}
