import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Game extends JPanel
{
    //default SCALE = 1, HEIGHT = 720 and WIDTH = 1280
    public static int SCALE;
    public static int HEIGHT;
    public static int WIDTH;

    private Window window;
    private BufferStrategy bufferStrat;
    private boolean running;
    private GameStateManager stateManager;
    private InputHandler input;

    public Game(int height, int scale)
    {
        SCALE = scale;
        HEIGHT = height * SCALE;
        WIDTH = HEIGHT * 16 / 9 * SCALE;

        initialize();
        running = true;
        startGame();
    }

    public Game(int height)
    {
        this(height, 1);
    }

    public Game()
    {
        this(720, 1);
    }

    public void initialize()
    {
        if (running) return;

        window = new Window(this);
        window.createBufferStrategy(2);
        bufferStrat = window.getBufferStrategy();
        stateManager = new GameStateManager();
        input = new InputHandler(this);
    }

    public void startGame()
    {
        final int FPS = 30;
        double delta = 0;
        final double TICK_INTERVAL = 1E9D / FPS;
        long currentTime;
        int frames = 0;
        long tickTimer = System.nanoTime();
        long fpsTimer = System.currentTimeMillis();

        while (running)
        {
            currentTime = System.nanoTime();
            delta += (currentTime - tickTimer) / TICK_INTERVAL;
            tickTimer = currentTime;
            boolean toRender = false;

            while (delta >= 1)
            {
                stateManager.tick();
                delta--;
                toRender = true;
            }

            if (toRender)
            {
                render();
                frames++;
            } else
            {
                try
                {
                    Thread.sleep(1);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            if (System.currentTimeMillis() - fpsTimer >= 1000)
            {
                fpsTimer += 1000;
                frames = 0;
            }
        }

    }


    public Window getWindow()
    {
        return window;
    }

    public void render()
    {

        do
        {
            do
            {
                Graphics2D brush = (Graphics2D) bufferStrat.getDrawGraphics();
                brush.setColor(getBackground());
                brush.fillRect(0, 0, WIDTH, HEIGHT);
                brush.setColor(Color.BLACK);
                stateManager.draw(brush);

                brush.dispose();
            } while (bufferStrat.contentsRestored());

            bufferStrat.show();
        } while (bufferStrat.contentsLost());

    }

    public static void main(String[] args)
    {
        new Game();
    }
}
