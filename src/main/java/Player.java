import java.awt.*;
import java.util.Random;

public class Player extends NomomObject {

    private Random r = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = NomomGame.clamp(x, 0, NomomGame.WIDTH - 48);
        y = NomomGame.clamp(y, 0, NomomGame.HEIGHT - 69);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
