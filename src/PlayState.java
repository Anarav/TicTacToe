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
        brush.drawLine(board.getTopLeftX() + board.getBlockSize(), board.getTopLeftY(), board.getTopLeftX() + board.getBlockSize(), board.getTopLeftY() + board.getBlockSize() * 3);
        brush.drawLine(board.getTopLeftX() + board.getBlockSize() * 2, board.getTopLeftY(), board.getTopLeftX() + board.getBlockSize() * 2, board.getTopLeftY() + board.getBlockSize() * 3);
        brush.drawLine(board.getTopLeftX(), board.getTopLeftY() + board.getBlockSize(), board.getTopLeftX() + board.getBlockSize() * 3, board.getTopLeftY() + board.getBlockSize());
        brush.drawLine(board.getTopLeftX(), board.getTopLeftY() + board.getBlockSize() * 2, board.getTopLeftX() + board.getBlockSize() * 3, board.getTopLeftY() + board.getBlockSize() * 2);

        char[] blocks = board.getBlocks();
        for (int i = 0; i < blocks.length; i++)
        {
            char value = blocks[i];
            int toDrawX = board.getTopLeftX() + board.getBlockSize() * (i / 3);
            int toDrawY = board.getTopLeftY() + board.getBlockSize() * (i % 3);

            if (value == Board.PLAYER_O)
                board.drawO(toDrawX, toDrawY, brush);
            else if (value == Board.PLAYER_X)
                board.drawX(toDrawX, toDrawY, brush);
        }

    }

}
