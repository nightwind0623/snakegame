import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel 
{
    public static void main(String[] args) 
    {
        JFrame window = new JFrame("snake");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 1000);
        window.pack();
        window.setContentPane(new Main());
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
    }
    @Override
    public Dimension getPreferredSize() 
    {
        return new Dimension();
    }
}
