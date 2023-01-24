package OtherClassesPackage;

import java.awt.image.BufferedImage;

public class Greyscale extends FormatPixel{
	// metoda ce converteste o imagine color in Greyscale
	public void greey() {
	    // daca imaginea este color, o converteste in Greyscale
		if(this.getFormat() == 0)
		{	
			BufferedImage image = this.getImage();
			// se citesc latimea si inaltimea
		    int width = image.getWidth(); 
		    int height = image.getHeight();
		    
		    for(int y = 0; y < height; y++){
		      for(int x = 0; x < width; x++){
		        int p = image.getRGB(x,y); // se citeste valoarea rgb a pixeului 
	
		        int a = (p>>24)&0xff; // variabila ce stocheaza transparenta pixelului, nu este folosita
		        int r = (p>>16)&0xff; // variabila ce stocheaza valoarea culorii rosii a pixelului 
		        int g = (p>>8)&0xff; // variabila ce stocheaza valoarea culorii verzi a pixelului 
		        int b = p&0xff;	// variabila ce stocheaza valoarea culorii albastre a pixelului 
	
		        // se calculeaza media celor 3 valori
		        int avg = (r+g+b)/3;
	
		        // se inlocuiesc valorile rgb ale pixelului cu media calculata anterior
		        p = (a<<24) | (avg<<16) | (avg<<8) | avg;
		        image.setRGB(x, y, p);
		      }
		    }
		}
		// daca imaginea este deja Greyscale, asta duce la afisarea unui mesaj de avertisment si terminarea programului
		else {
			System.out.println("Imaginea este deja Greyscale!");
			System.exit(0);
		}
	}
	public int greey(BufferedImage img) {
		int width = img.getWidth(); 
	    int height = img.getHeight();
		return width*height; //returneaza numarul de pixeli ai imaginii
	}
}
