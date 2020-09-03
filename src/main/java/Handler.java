import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<NomomObject> objects = new LinkedList<NomomObject>();

    public void tick() {
        for(int i = 0; i < objects.size(); i++) {
            NomomObject tempObject = objects.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for(int i = 0; i < objects.size(); i++) {
            NomomObject tempObject = objects.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(NomomObject object) {
        this.objects.add(object);
    }

    public void removeObject(NomomObject object) {
        this.objects.remove(object);
    }

}
