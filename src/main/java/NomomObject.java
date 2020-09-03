import java.awt.*;

public abstract class NomomObject {

    protected int x, y;
    protected ID id;
    protected int velX, velY;

     public NomomObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
     }

     public abstract void tick();
     public abstract void render(Graphics g);
     public abstract Rectangle getBounds();

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setVelX(int vx) {
        this.velX = vx;
    }

    public void setVelY(int vy) {
        this.velY = vy;
    }

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return velY;
    }
}
