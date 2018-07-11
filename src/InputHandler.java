import java.awt.event.*;

public class InputHandler implements KeyListener, MouseMotionListener, MouseListener
{
    public static int mouseX;
    public static int mouseY;
    public static CollisionBox mouseCB;
    public static boolean clicked;
    public static final int CURSOR_SIZE = 2;

    public InputHandler(Game game)
    {
        mouseCB = new CollisionBox(0, 0, CURSOR_SIZE, CURSOR_SIZE);
        game.getWindow().addKeyListener(this);
        game.getWindow().addMouseListener(this);
        game.getWindow().addMouseMotionListener(this);
    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void keyPressed(KeyEvent e)
    {

    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void mouseClicked(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();
        mouseCB.setX(mouseX);
        mouseCB.setY(mouseY);
    }

    public void mousePressed(MouseEvent e)
    {
        clicked = true;
    }

    public void mouseReleased(MouseEvent e)
    {
        clicked = false;
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {

    }

    public void mouseDragged(MouseEvent e)
    {
    }

    public void mouseMoved(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();
        mouseCB.setX(mouseX);
        mouseCB.setY(mouseY);
    }
}
