package OtherClassesPackage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.Thread;
import java.io.PipedInputStream;

public class Consumer extends Thread {
	private FormatPixel image;
	private PipedInputStream in;
	private WriterResult writer;

	public Consumer(FormatPixel image, PipedInputStream in, WriterResult writer) {
	    this.image = image;
	    this.in = in;
	    this.writer = writer;
	}

	public void run() {
	    try {
	        BufferedImage img = new BufferedImage(image.getImage().getWidth(), image.getImage().getHeight(), BufferedImage.TYPE_INT_RGB);
	        int width = img.getWidth();
	        int height = img.getHeight();
	        int totalPixels = width * height;
	        int quarterPixels = totalPixels / 4;

	        for (int i = 0; i < totalPixels; i++) {
	            // receptia informatiei de imagine
	            if (i % quarterPixels == 0) {
	                System.out.println("Receiving segment " + (i / quarterPixels + 1));
	            }
	            img.setRGB(i % width, i / width, in.read());
	            if (i % quarterPixels == quarterPixels - 1) {
	                image.setImage(img);
	                image.greey();
	                writer.write(image);
	            }
	        }
	        in.close();
	        writer.close();
	    } catch (IOException e) {
	        System.out.println("Eroare la receptia imaginii: " + e.getMessage());
	    }
	}
}