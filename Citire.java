package OtherClassesPackage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
// metoda folosita pentru citirea imaginii de la adresa specificata
public class Citire {
	public static BufferedImage citire(String path) {
	    BufferedImage img = null;
		try{
	    	File f = new File(path);
	        img = ImageIO.read(f);
	      }catch(IOException e){ 
	        System.out.println("Citire imagine nereusita!"); // tratare eroare de citire
	        System.exit(0);
	      }
	    return img;
	}
	
	
}
