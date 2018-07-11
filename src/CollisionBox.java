import java.awt.Rectangle;

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

        return this.collisionBox.intersects(testCB.collisionBox);
    }

    public int isColliding(CollisionBox[] testCBs)
    {
        for (int i = 0; i < testCBs.length; i++)
        {
            if (this.isColliding(testCBs[i]))
                return i;
        }

        return -1;
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

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }
}
