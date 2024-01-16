import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.io.Arr

public class DrawPanel  extends JPanel {
    BufferedImage background;
    List<Sprite> sprites = new ArrayList<>();

    DrawPanel(URL backgroundImagageURL) {
        try {
            background = ImageIO.read(backgroundImagageURL);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        for (Sprite sprite : sprites)
            sprite.draw();
    }
}