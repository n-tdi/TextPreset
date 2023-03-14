package world.ntdi.textpreset;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public final class TextPreset {
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("src/main/resources/Ntdi_world_1200px-01.png"));

        String text = "Ntdi loves cheese, but it doesn't love him.";
        int fontSize = 100 - (int) (text.length() * 1.5);

        Font font = new Font("Hubot-Sans", Font.BOLD, fontSize);
        Graphics g = image.getGraphics();

        FontMetrics metrics = g.getFontMetrics(font);

        int positionX = (image.getWidth() - metrics.stringWidth(text)) / 2;
        int positionY = (image.getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();

        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(text, 50, positionY);

        ImageSerializer imageSerializer = new ImageSerializer(text, fontSize, 50, positionY, image);
    }
}
