import java.awt.*;
import java.util.*;
import java.util.Timer;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Main extends JPanel implements KeyListener
{
    public static final int CELL_SIZE = 20;
    private static int width = 400;
    private static int height = 400;
    public static int row = height / CELL_SIZE;
    public static int column = width / CELL_SIZE;
    private static String direcetion;
    private Snake snake;
    private Fruit food;
    private Timer timer;
    private int speed;
    private boolean allowKeyPress;
    private int score;
    private int highestScore;
    public Main()
    {
        readHighestScore();
        speed = 100;
        addKeyListener(this);
        reset();
    }
    @Override
    protected void paintComponent(Graphics g) 
    {
        writeHighestScore(score);
        gameoverLogic(snake);
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, width, height);
        food.drawFood(g);
        snake.drawSnake(g);
        moveSnake();
        requestFocusInWindow();
    }
    public static void main(String[] args) 
    {
        JFrame window = new JFrame("snake");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Main());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) 
    {
        if(allowKeyPress == true)
        {
            if(e.getKeyCode() == 37 && !direcetion.equals("right"))
            {
                direcetion = "left";
                allowKeyPress = false;
            }
            else if(e.getKeyCode() == 38 && !direcetion.equals("down"))
            {
                direcetion = "up";
                allowKeyPress = false;
            }
            else if(e.getKeyCode() == 39 && !direcetion.equals("left"))
            {
                allowKeyPress = false;
                direcetion = "right";
            }
            else if(e.getKeyCode() == 40 && !direcetion.equals("up"))
            {
                allowKeyPress = false;
                direcetion = "down";
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public Dimension getPreferredSize() 
    {
        return new Dimension(width, height);
    }
    public void moveSnake()
    {
        int snakeX = snake.getSnakeBody().get(0).x;
        int snakeY = snake.getSnakeBody().get(0).y;
        switch(direcetion)
        {
            case "right":
                snakeX += CELL_SIZE;
                break;
            case "left":
                snakeX -= CELL_SIZE;
                break;
            case "up":
                snakeY -= CELL_SIZE;
                break;
            case "down":
                snakeY += CELL_SIZE;
                break;
        }
        Node newHead = new Node(snakeX, snakeY);
        if(newHead.x == food.getX() && newHead.y == food.getY())
        {
            food.setNewLocation(snake);
            score++;
        }
        else
        {
            snake.getSnakeBody().remove(snake.getSnakeBody().size() - 1);
        }
        snake.getSnakeBody().add(0, newHead);
    }
    public void gameoverLogic(Snake s)
    {
        ArrayList<Node> snakeBody = s.getSnakeBody();
        for(int i = 1; i < s.getSnakeBody().size(); i++)
        {
            if(s.getSnakeBody().get(0).x == s.getSnakeBody().get(i).x && s.getSnakeBody().get(0).y == s.getSnakeBody().get(i).y)
            {
                gameover();
            }
        }
        
        if(snakeBody.get(0).x < 0 || snakeBody.get(0).y < 0 || snakeBody.get(0).x > width || snakeBody.get(0).y > height)
        {
            gameover();
        }
    }
    public void reset()
    {
        score = 0;
        snake = new Snake();
        direcetion = "right";
        food = new Fruit();
        allowKeyPress = true;
        setTimer();
    }
    public void setTimer()
    {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run()
            {
                repaint();
                allowKeyPress = true;
            }
        }, 0, speed);
    }
    public void gameover()
    {
        System.out.println("gameover");
        allowKeyPress = false;
        timer.cancel();
        timer.purge();
        int reponse = JOptionPane.showOptionDialog(this, "play again?"+ '\n' + "your score: "+ score + '\n' + "your highest score: " + highestScore, "gameover", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, JOptionPane.YES_OPTION);
        switch(reponse)
        {
            case JOptionPane.CLOSED_OPTION:
                System.exit(0);
                break;
            case JOptionPane.NO_OPTION:
                System.exit(0);
            case JOptionPane.YES_OPTION:
                reset();
                return;
        }
    }
    public void readHighestScore()
    {
        try
        {
            File myObj = new File("score.txt");
            Scanner scanner = new Scanner(myObj);
            highestScore = scanner.nextInt();
            scanner.close();
        }
        catch(FileNotFoundException e)
        {
            highestScore = 0;
            try
            {
                File myObj = new File("score.txt");
                if(myObj.createNewFile())
                {
                    System.out.println("file created "+myObj.getName());
                }
                FileWriter fileWriter = new FileWriter(myObj);
                fileWriter.write("0");
                fileWriter.close();
            }
            catch(IOException err)
            {
                err.printStackTrace();
            }
        }
    }
    public void writeHighestScore(int score)
    {
        try
        {
            if(score > highestScore)
            {
                FileWriter fileWriter = new FileWriter("score.txt");
                fileWriter.write(""+score);
                highestScore = score;
                fileWriter.close();
            }
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
