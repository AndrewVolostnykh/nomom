import java.awt.*;
import java.util.Random;

public class BasicMob extends NomomObject {

    Random random = new Random();
    private boolean isAggressive;

    int stepCounter = random.nextInt(350) + 100;
    int sleepTime = 0;

    public BasicMob(int x, int y, ID id) {
        super(x, y, id);

        isAggressive = random.nextBoolean();

        velX = random.nextInt(4);
        velY = random.nextInt(4);
    }

    @Override
    public void tick() {

        if(stepCounter <= 0 && sleepTime == 0) {
            sleepTime = random.nextInt(70) + 10;
            stepCounter = random.nextInt(350) + 100;

            velX = (-2 + random.nextInt(7));
            velY = (-2 + random.nextInt(7));
        }

        if(sleepTime == 0) {
            x += velX;
            y += velY;
        } else {
            x += 0;
            y += 0;
            sleepTime--;
        }

        if(y <= 0 || y >= NomomGame.HEIGHT - 56) velY *= -1;
        if(x <= 0 || x >= NomomGame.WIDTH - 25) velX *= -1;

        stepCounter--;
    }

    @Override
    public void render(Graphics g) {
        if(isAggressive) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.gray);
        }
        g.fillRect(x, y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

    public boolean getIsAggressive() {
        return this.isAggressive;
    }
}
