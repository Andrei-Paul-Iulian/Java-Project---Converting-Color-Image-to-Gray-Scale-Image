package OtherClassesPackage;

import OtherClassesPackage.Image;

public class FormatPixel extends Image {
	int format = 1; // 1 = greyscale ; 0 = rgb
	
	// getter pentru atributul format
	public int getFormat() {
		return format;
	}
	// setter pentru atributul format
	public void setFormat(int frmt) {
		this.format = frmt;
	}
	// metoda ce verifica daca imaginea este color sau Grayscale
	// daca este deja Grayscale, aceasta nu mai este convertita
	public void verificare() {
		int width = this.getImage().getWidth();
	    int height = this.getImage().getHeight();

	    //convert to grayscale
	    for(int y = 0; y < height; y++){
	      for(int x = 0; x < width; x++){
	        int p = this.getImage().getRGB(x,y); // variabila in care se stocheaza valoarea rgb a pixelului

	        int r = (p>>16)&0xff; // citeste valoarea culorii rosii a pixelului
	        int g = (p>>8)&0xff; // citeste valoarea culorii verzi a pixelului
	        int b = p&0xff; // citeste valoarea culorii albastre a pixelului
	        if(r == g && g == b) // daca cele 3 culori au valori egale, stim ca pixelul este gri
	        	continue;
	        else {
	        	this.setFormat(0); // daca cel putin un pixel este color, formatul se schimba din Grayscale in imagine color
	        	break;
	        }
	      }
	    }
	}
	
}
