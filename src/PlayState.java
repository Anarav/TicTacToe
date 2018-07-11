import java.awt.Graphics2D;

public class PlayState extends GameState
{
    private Board board;
    private char currentTurn;
    private String winData;

    public void init()
    {
        //TODO add option to change blockSize
        board = new Board(100);
        currentTurn = (char) (Math.random() * 2 + 1);
    }

    public void tick()
    {
        if (winData == null)
            winData = board.hasWon();

        if (InputHandler.clicked)
        {
            if (InputHandler.mouseCB.isColliding(board.getResetCB()))
            {
                winData = null;
                currentTurn = (char) (Math.random() * 2 + 1);
                board.resetBoard();
            }

            if (winData == null)
            {
                int collision = InputHandler.mouseCB.isColliding(board.getBlocksCB());
                if (collision >= 0)
                {
                    if (board.getBlocks()[collision] == Board.BLANK)
                    {
                        board.setBlock(collision, currentTurn);
                        if (currentTurn == Board.PLAYER_O)
                            currentTurn = Board.PLAYER_X;
                        else
                            currentTurn = Board.PLAYER_O;
                    }
                }
            }
        }
    }

    public void draw(Graphics2D brush)
    {
        brush.drawLine(board.getTopLeftX() + board.getBlockSize(), board.getTopLeftY(), board.getTopLeftX() + board.getBlockSize(), board.getTopLeftY() + board.getBlockSize() * 3);
        brush.drawLine(board.getTopLeftX() + board.getBlockSize() * 2, board.getTopLeftY(), board.getTopLeftX() + board.getBlockSize() * 2, board.getTopLeftY() + board.getBlockSize() * 3);
        brush.drawLine(board.getTopLeftX(), board.getTopLeftY() + board.getBlockSize(), board.getTopLeftX() + board.getBlockSize() * 3, board.getTopLeftY() + board.getBlockSize());
        brush.drawLine(board.getTopLeftX(), board.getTopLeftY() + board.getBlockSize() * 2, board.getTopLeftX() + board.getBlockSize() * 3, board.getTopLeftY() + board.getBlockSize() * 2);
        brush.setFont(brush.getFont().deriveFont(board.getBlockSize() * 0.5f));
        board.getResetCB().setWidth(brush.getFontMetrics().stringWidth("Reset"));
        brush.drawString("Reset", board.getResetCB().getX(), board.getResetCB().getY() + board.getResetCB().getHeight());

        char[] blocks = board.getBlocks();
        for (int i = 0; i < blocks.length; i++)
        {
            char value = blocks[i];
            int toDrawX = board.getTopLeftX() + board.getBlockSize() * (i % 3);
            int toDrawY = board.getTopLeftY() + board.getBlockSize() * (i / 3);

            if (value == Board.PLAYER_O)
                board.drawO(toDrawX, toDrawY, brush);
            else if (value == Board.PLAYER_X)
                board.drawX(toDrawX, toDrawY, brush);
        }

        //TODO add display of who won
        if (winData != null)
        {
            int index = Character.getNumericValue(winData.charAt(1));
            int temp = 0;
            switch (winData.charAt(0))
            {
                case 'H':
                    temp = board.getTopLeftY() + index / 3 * board.getBlockSize() + board.getBlockSize() / 2; //get top left y, adjust to the appropriate top left of the "won" cell and then bring it to the middle of the cell
                    brush.drawLine(board.getTopLeftX(), temp, board.getTopLeftX() + board.getBlockSize() * 3, temp);
                    break;
                case 'V':
                    temp = board.getTopLeftX() + index % 3 * board.getBlockSize() + board.getBlockSize() / 2; //get the top left x, adjust to the appropriate horizontal "won" cell and then bring it to the middle of the cell
                    brush.drawLine(temp, board.getTopLeftY(), temp, board.getTopLeftY() + board.getBlockSize() * 3);
                    break;
                case 'D':
                    break;

                default:
                    System.out.println("There was an unexpected error in win condition!");
                    break;
            }
        }

    }

}
