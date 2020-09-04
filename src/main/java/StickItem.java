import java.awt.*;

public class StickItem extends NomomObject {

    public boolean picked = false;
    private Player player;

    public StickItem(int x, int y, ID id) {
        super(x, y, id);
    }

    public void tick() {
        if(picked && player != null) {
            x += player.getVelX();
            y += player.getVelY();

            x = NomomGame.clamp(x, 0, NomomGame.WIDTH - 48);
            y = NomomGame.clamp(y, 0, NomomGame.HEIGHT - 69);
        }
    }

    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.green);
        g2d.draw(getBounds());

        g.setColor(new Color(153, 102, 0));
        g.drawLine(x, y, x + 30, y + 30);
        g.drawLine(x + 1, y + 1, x + 31, y + 31);
        g.drawLine(x + 2, y + 2, x + 32, y + 32);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 30, 30);
    }

    public void pickElement(Player player) {
        this.player = player;
        picked = true;
    }

    public void dropElement() {
        player = null;
        picked = false;
    }
}
