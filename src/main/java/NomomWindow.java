import javax.swing.*;
import java.awt.*;

public class NomomWindow extends Canvas {
    private static final long serialVersionUID = -3518231192373568183L;

    public NomomWindow(int width, int height, String title, NomomGame game) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }





}
