package world.ntdi.textpreset;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSerializer {
    private final String name;
    private final File file;

    public ImageSerializer(String text, int fontSize, int x, int y, BufferedImage image) throws IOException {
        text = text.trim().replaceAll(" ", "_");
        this.name = "size-" + fontSize + "-x-" + x + "-y-" + y + "-text-" + text + ".png";

        this.file = new File("CI/" + this.name);
        this.file.mkdirs();
        ImageIO.write(image, "png", this.file);
    }

    public void delete() {
        this.file.delete();
    }
}
