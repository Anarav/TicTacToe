import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Game extends JPanel
{
    //TODO add options to modify height and width and scale through constructor
    public static final int SCALE = 1;
    public static final int HEIGHT = 720 * SCALE;
    public static final int WIDTH = HEIGHT * 16 / 9 * SCALE;
    private Window window;
    private BufferStrategy bufferStrat;
    private boolean running;
    private GameStateManager stateManager;
    private InputHandler input;

    public Game()
    {
        initialize();
        running = true;
        startGame();
    }

    public void initialize()
    {
        if (running) return;

        window = new Window(this);
        window.createBufferStrategy(2);
        bufferStrat = window.getBufferStrategy();
        stateManager = new GameStateManager();
        input = new InputHandler();
        window.addKeyListener(input);
        window.addMouseListener(input);
        window.addMouseMotionListener(input);
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
            //TODO add option to have unlimited frames for games that require frequent renders
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
