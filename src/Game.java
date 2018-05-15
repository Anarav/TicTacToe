import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Game extends JPanel
{
    //TODO add options to modify height and width and scale through constructor
    public static final int SCALE = 1;
    public static final int HEIGHT = 720 * SCALE;
    public static final int WIDTH = HEIGHT * 16 / 9 * SCALE;

    public Game()
    {
        initializeWindow();
    }

    public void initializeWindow()
    {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //preliminary testing to see how the board looks. box size = 50, top-left of board at (100,100)
        g.drawLine(150, 100, 150, 250);
        g.drawLine(200, 100, 200, 250);
        g.drawLine(100, 150, 250, 150);
        g.drawLine(100, 200, 250, 200);

        this.repaint();
    }

    public static void main(String[] args)
    {
        new Game();
    }
}
