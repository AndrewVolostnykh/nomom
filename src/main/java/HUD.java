import jdk.vm.ci.hotspot.HotSpotVMEventListener;

import java.awt.*;
import java.util.HashMap;

public class HUD {

    public static int HEALTH = 100;

    public void tick() {
        HEALTH = NomomGame.clamp(HEALTH, 0, 100);
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, HEALTH * 2, 32);
    }
}
