import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel 
{
    private static int width = 400;
    private static int height = 400;
    @Override
    public Dimension getPreferredSize() 
    {
        return new Dimension(width, height);
    }
    public static void main(String[] args) 
    {
        JFrame window = new JFrame("snake");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setContentPane(new Main());
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
    }
    
}
