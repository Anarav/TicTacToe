public class Board
{
    public int centerX;
    private int centerY;
    private int blockSize;

    public Board(int blockSize)
    {
        centerX = Game.WIDTH / 2;
        centerY = Game.HEIGHT / 2;
        this.blockSize = blockSize;
    }


    public int getCenterX()
    {
        return centerX;
    }

    public int getCenterY()
    {
        return centerY;
    }

    public int getBlockSize()
    {
        return blockSize;
    }
}
