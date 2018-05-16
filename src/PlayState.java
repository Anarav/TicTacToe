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
        int topleftX = board.getCenterX() - (board.getBlockSize() / 2) - board.getBlockSize();
        int topleftY = board.getCenterY() - (board.getBlockSize() / 2) - board.getBlockSize();

        brush.drawLine(topleftX + board.getBlockSize(), topleftY, topleftX + board.getBlockSize(), topleftY + board.getBlockSize() * 3);
        brush.drawLine(topleftX + board.getBlockSize() * 2, topleftY, topleftX + board.getBlockSize() * 2, topleftY + board.getBlockSize() * 3);
        brush.drawLine(topleftX, topleftY + board.getBlockSize(), topleftX + board.getBlockSize() * 3, topleftY + board.getBlockSize());
        brush.drawLine(topleftX, topleftY + board.getBlockSize() * 2, topleftX + board.getBlockSize() * 3, topleftY + board.getBlockSize() * 2);
    }
}
