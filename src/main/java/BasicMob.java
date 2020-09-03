import java.awt.*;
import java.util.Random;

public class BasicMob extends NomomObject {

    public BasicMob(int x, int y, ID id) {
        super(x, y, id);

        velX = 5;
        velY = 5;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= NomomGame.HEIGHT - 56) velY *= -1;
        if(x <= 0 || x >= NomomGame.WIDTH - 25) velX *= -1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }
}
