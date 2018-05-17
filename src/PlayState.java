import java.awt.Graphics2D;

public class PlayState extends GameState
{
    private Board board;

    public void init()
    {
        //TODO add option to change blockSize
        board = new Board(100);
    }

    public void tick()
    {
    }

    public void draw(Graphics2D brush)
    {
        int topLeftX = board.getCenterX() - board.getBlockSize() / 2 - board.getBlockSize();
        int topLeftY = board.getCenterY() - board.getBlockSize() / 2 - board.getBlockSize();

        brush.drawLine(topLeftX + board.getBlockSize(), topLeftY, topLeftX + board.getBlockSize(), topLeftY + board.getBlockSize() * 3);
        brush.drawLine(topLeftX + board.getBlockSize() * 2, topLeftY, topLeftX + board.getBlockSize() * 2, topLeftY + board.getBlockSize() * 3);
        brush.drawLine(topLeftX, topLeftY + board.getBlockSize(), topLeftX + board.getBlockSize() * 3, topLeftY + board.getBlockSize());
        brush.drawLine(topLeftX, topLeftY + board.getBlockSize() * 2, topLeftX + board.getBlockSize() * 3, topLeftY + board.getBlockSize() * 2);

        char[] blocks = board.getBlocks();
        for (int i = 0; i < blocks.length; i++)
        {
            char value = blocks[i];
            int toDrawX = topLeftX + board.getBlockSize() * (i / 3);
            int toDrawY = topLeftY + board.getBlockSize() * (i % 3);

            if (value == Board.PLAYER_O)
                board.drawO(toDrawX, toDrawY, brush);
            else if (value == Board.PLAYER_X)
                board.drawX(toDrawX, toDrawY, brush);
        }
    }

}
