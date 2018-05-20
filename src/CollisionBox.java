import java.awt.Rectangle;
import java.util.ArrayList;

public class CollisionBox
{
    private int x, y, width, height;
    private Rectangle collisionBox;

    public CollisionBox(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isColliding(CollisionBox testCB)
    {
        makeBox();
        testCB.makeBox();
        if (this.collisionBox.intersects(testCB.collisionBox))
            return true;

        return false;
    }

    public CollisionBox isColliding(ArrayList<CollisionBox> testCBs)
    {
        for (CollisionBox cb : testCBs)
        {
            if (this.isColliding(cb))
                return cb;
        }

        return null;
    }

    public void makeBox()
    {
        collisionBox = new Rectangle(x, y, width, height);
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

}
