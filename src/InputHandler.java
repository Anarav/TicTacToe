import java.awt.event.*;

public class InputHandler implements KeyListener, MouseMotionListener, MouseListener
{
    public static int mouseX;
    public static int mouseY;
    public static CollisionBox mouseCB;
    public static final int CURSOR_SIZE = 2;

    public InputHandler()
    {
        mouseCB = new CollisionBox(0, 0, CURSOR_SIZE, CURSOR_SIZE);
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
    }

    public void mouseReleased(MouseEvent e)
    {
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
