package OtherClassesPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WriterResult {
    private FileOutputStream fos;

    public WriterResult(String path) {
        try {
            fos = new FileOutputStream(path);
        } catch (IOException e){
        	System.out.println("Eroare la crearea fisierului de iesire: " + e.getMessage());
        	}
    }
    public void write(FormatPixel image) {
        try {
            ImageIO.write(image.getImage(), "jpg", fos);
        } catch (IOException e) {
            System.out.println("Eroare la scrierea imaginii in fisier: " + e.getMessage());
        }
    }

    public void close() {
        try {
            fos.close();
        } catch (IOException e) {
            System.out.println("Eroare la inchiderea fisierului de iesire: " + e.getMessage());
        }
    }
}

