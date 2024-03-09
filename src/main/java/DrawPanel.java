import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel  extends JPanel {
    BufferedImage background;

    Zombie zombie2 = new Zombie(300, 300, 0.5);
    Zombie zombie = new Zombie(500, 500, 1);
    List<Sprite> sprites = new ArrayList<>();

    DrawPanel(URL backgroundImagageURL) {
        try {
            background = ImageIO.read(backgroundImagageURL);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        sprites.add(zombie);
        sprites.add(zombie2);
        AnimationThread thread = new AnimationThread();
        thread.start();

    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        for (Sprite sprite : sprites){
            sprite.draw(g, this);
        }
    }


    class AnimationThread extends Thread {
        public void run() {
            for (int i=0; ; i++) {
                for (Sprite sprite : sprites) {
                    sprite.next();
                }
                repaint();
                try {
                    sleep(1000 / 10);  // 30 klatek na sekundę
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}