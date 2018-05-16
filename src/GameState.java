import java.awt.Graphics2D;

public abstract class GameState
{
    public abstract void init();

    public abstract void tick();

    public abstract void draw(Graphics2D brush);
}
