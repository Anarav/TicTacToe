import javax.swing.JPanel;
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

    public Game()
    {
        initialize();
        running = true;
        startGame();
    }

    public void initialize()
    {
        window = new Window(this);
        window.createBufferStrategy(2);
        bufferStrat = window.getBufferStrategy();
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
                tick();
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


    public void tick()
    {
    }

    public void render()
    {

        do
        {
            do
            {
                Graphics2D brush = (Graphics2D) bufferStrat.getDrawGraphics();

                draw(brush);

                brush.dispose();
            } while (bufferStrat.contentsRestored());

            bufferStrat.show();
        } while (bufferStrat.contentsLost());

    }

    public void draw(Graphics2D brush)
    {
        brush.drawLine(150, 100, 150, 250);
        brush.drawLine(200, 100, 200, 250);
        brush.drawLine(100, 150, 250, 150);
        brush.drawLine(100, 200, 250, 200);
    }

    public static void main(String[] args)
    {
        new Game();
    }
}
