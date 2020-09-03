import java.awt.*;
import java.util.Random;

public class Player extends NomomObject {

    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = NomomGame.clamp(x, 0, NomomGame.WIDTH - 48);
        y = NomomGame.clamp(y, 0, NomomGame.HEIGHT - 69);

        collision();
    }

    private void collision() {
        for(int i = 0; i < handler.objects.size(); i++) {
            NomomObject tempObject = handler.objects.get(i);

            if(tempObject.getId() == ID.BasicMob) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 2;
                }
            }

        }
    }

    @Override
    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.red);
        g2d.draw(getBounds());

        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
