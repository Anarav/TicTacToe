import java.awt.Graphics2D;

public class Board
{
    private int topLeftX;
    private int topLeftY;
    private int blockSize;
    public char blocks[];
    private int drawOffset;
    private CollisionBox boardCB;
    private CollisionBox blocksCB[];
    public static final char BLANK = 0, PLAYER_X = 1, PLAYER_O = 2;

    public Board(int blockSize)
    {
        topLeftX = Game.WIDTH / 2 - blockSize - blockSize / 2;
        topLeftY = Game.HEIGHT / 2 - blockSize - blockSize / 2;
        this.blockSize = blockSize;
        drawOffset = blockSize / 5;
        boardCB = new CollisionBox(topLeftX, topLeftY, blockSize * 3, blockSize * 3);
        blocks = new char[9];
        blocksCB = new CollisionBox[9];
        for (int i = 0; i < 9; i++)
        {
            blocks[i] = BLANK;
            blocksCB[i] = new CollisionBox(topLeftX + blockSize * (i / 3), topLeftY + blockSize * (i % 3), blockSize, blockSize);
        }
    }

    public boolean hasWon()
    {
        return (checkDiagonals() || checkHorizontals() || checkVerticals());
    }

    public int getTopLeftX()
    {
        return topLeftX;
    }

    public int getTopLeftY()
    {
        return topLeftY;
    }

    public int getBlockSize()
    {
        return blockSize;
    }

    public char[] getBlocks()
    {
        return blocks;
    }

    public void setBlock(int blockIndex, char value)
    {
        //assign the block within the board to a value as long as value is a valid one
        if (value == BLANK || value == PLAYER_X || value == PLAYER_O)
            blocks[blockIndex] = value;
    }

    public void drawX(int topLeftX, int topLeftY, Graphics2D brush)
    {
        brush.drawLine(topLeftX + drawOffset, topLeftY + drawOffset, topLeftX + blockSize - drawOffset, topLeftY + blockSize - drawOffset);
        brush.drawLine(topLeftX + blockSize - drawOffset, topLeftY + drawOffset, topLeftX + drawOffset, topLeftY + blockSize - drawOffset);
    }

    public void drawO(int topLeftX, int topLeftY, Graphics2D brush)
    {
        //twice the drawOffset here to create the same rectangle as in drawX
        brush.drawOval(topLeftX + drawOffset, topLeftY + drawOffset, blockSize - 2 * drawOffset, blockSize - 2 * drawOffset);
    }

    private boolean checkDiagonals()
    {
        if (blocks[0] != BLANK && blocks[0] == blocks[4] && blocks[4] == blocks[8])
            return true;

        if (blocks[2] != BLANK && blocks[2] == blocks[4] && blocks[4] == blocks[6])
            return true;

        return false;
    }

    private boolean checkHorizontals()
    {
        for (int i = 0; i < 9; i += 3)
            if (blocks[i] != BLANK && (blocks[i] == blocks[i + 1] && blocks[i + 3] == blocks[i + 2]))
                return true;

        return false;
    }

    private boolean checkVerticals()
    {
        for (int i = 0; i < 3; i++)
            if (blocks[i] != BLANK && (blocks[i] == blocks[i + 3] && blocks[i + 3] == blocks[i + 6]))
                return true;

        return false;
    }

    public CollisionBox getBoardCB()
    {
        return boardCB;
    }

    public CollisionBox[] getBlocksCB()
    {
        return blocksCB;
    }
}
