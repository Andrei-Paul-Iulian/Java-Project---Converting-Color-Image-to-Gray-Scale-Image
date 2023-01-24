package OtherClassesPackage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.Thread;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Producer extends Thread {
    private FormatPixel image;
    private String path;
    private PipedOutputStream out;

    public Producer(FormatPixel image, String path, PipedOutputStream out) {
        this.image = image;
        this.path = path;
        this.out = out;
    }

    public void run() {
        try {
            BufferedImage img = Citire.citire(path);
            image.setImage(img);
            image.verificare();
            int width = image.getImage().getWidth();
            int height = image.getImage().getHeight();
            int totalPixels = width * height;
            int quarterPixels = totalPixels / 4;

            for (int i = 0; i < totalPixels; i++) {
                // citirea informatiei de imagine
                if (i % quarterPixels == 0) {
                    System.out.println("Sending segment " + (i / quarterPixels + 1));
                }
                out.write(image.getImage().getRGB(i % width, i / width));
                if (i % quarterPixels == quarterPixels - 1) {
                    out.flush();
                }
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Eroare la citirea imaginii: " + e.getMessage());
        }
    }
}
