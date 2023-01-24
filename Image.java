package OtherClassesPackage;

import java.awt.image.BufferedImage;

abstract public class Image implements Interfata{
	private BufferedImage img;
	private String path;
	// setter pentru path-ul fisierului 
	public void setPath(String pth) {
		this.path = pth;
	}
	// getter pentru path-ul fisierului
	public String getPath() {
		return this.path;
	}
	// setter pentru imagine
	public void setImage(BufferedImage image) {
		this.img = image;
	}
	// getter pentru imagine
	public BufferedImage getImage() {
		return img;
	}
	public void greey() {	
	}
}

