import javax.swing.JFrame;

public class Window extends JFrame
{
    public Window(Game game)
    {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Game.WIDTH, Game.HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        add(game);
        setVisible(true);
    }
}
