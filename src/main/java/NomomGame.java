import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class NomomGame extends Canvas implements Runnable {

    private static final long serialVersionUID = -4787108556148621714L;

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;

    private Handler handler;
    private HUD hud;

    public NomomGame() {
        Random random = new Random();
        this.requestFocus();
        handler = new Handler();
        hud = new HUD();
        this.addKeyListener(new KeyInput(handler));
        new NomomWindow(WIDTH, HEIGHT, "Oh shit, here we go again...", this);

        handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler)); // create player
        for(int i = 0; i < 6; i++) { // create mobs
            handler.addObject(new BasicMob(random.nextInt(WIDTH/2), random.nextInt(HEIGHT/2), ID.BasicMob));
        }

        for(int i = 0; i < 4; i++) { // create craft materials
            handler.addObject(new StickItem(random.nextInt(WIDTH - 45), random.nextInt(HEIGHT - 45), ID.StickItem));
        }
    }

    public static void main(String[] args) {
        new NomomGame();
    }

    public void run() {
        long lastTime = System.nanoTime();
        double aboutOfTicks = 60.0;
        double ns = 1000000000 / aboutOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        hud.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bs.getDrawGraphics();

        graphics.setColor(Color.black);
        graphics.fillRect(0,0, WIDTH, HEIGHT);

        handler.render(graphics);
        hud.render(graphics);

        graphics.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max) {
        if(var >= max) return max;
        else if (var <= min) return min;
        else return var;
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
