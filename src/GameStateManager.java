import java.awt.Graphics2D;

public class GameStateManager
{
    private GameState runningState;

    public GameStateManager()
    {
        runningState = new PlayState();
        runningState.init();
    }

    public void switchState(GameState runningState)
    {
        this.runningState = runningState;
    }

    public void tick()
    {
        runningState.tick();
    }

    public void draw(Graphics2D brush)
    {
        runningState.draw(brush);
    }
}
