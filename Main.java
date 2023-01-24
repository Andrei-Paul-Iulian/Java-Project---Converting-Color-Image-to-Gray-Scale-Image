package MainClassPackage;

import OtherClassesPackage.Citire;
import OtherClassesPackage.Consumer;
import OtherClassesPackage.FormatPixel;
import OtherClassesPackage.Greyscale;
import OtherClassesPackage.Image;
import OtherClassesPackage.Interfata;
import OtherClassesPackage.Producer;
import OtherClassesPackage.Scriere;
import OtherClassesPackage.WriterResult;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class Main{
	// args, argumente din linia de comanda,
	public static void main(String[] args) throws IOException {
		BufferedImage img;
		Greyscale grey = new Greyscale();
		long start; // variabila folosita pt inregistrarea timpilor de executie

		// citirea path-ului fisierului sursa din linia de comanda
		System.out.println("Introduceti path-ul fisierului sursa: ");
		String path;
		Scanner scan = new Scanner(System.in);
        path = scan.nextLine();

		// citirea efectiva a fisierului sursa
		start = System.nanoTime(); // se memoreaza momentul de inainte de citire
        img = Citire.citire(path);
        //img = Citire.citire(args[0]);
	    grey.setImage(img);
		System.out.println("Timp citire: " + (System.nanoTime() - start) + " nanosecunde"); // se scrie diferenta dintre momentul inceputului citirii si finalului citirii

		// verificare daca imaginea este deja Greyscale
	    start = System.nanoTime(); // se memoreaza momentul de inainte de verificare
		grey.verificare();
		System.out.println("Timp verificare: " + (System.nanoTime() - start) + " nanosecunde"); // se scrie diferenta dintre momentul inceputului verificarii si finalului verificarii

		// daca se trece de verificare, incepe procesarea imaginii
		start = System.nanoTime(); // se memoreaza momentul de inainte de procesare
		grey.greey();
		System.out.println("Timp procesare: " + (System.nanoTime() - start) + " nanosecunde"); // se scrie diferenta dintre momentul inceputului procesarii si finalului acesteia

		// scrierea imaginii convertita in fisierul destinatie
		start = System.nanoTime(); // se memoreaza momentul de inainte de scriere
		System.out.println("Introduceti path-ul fisierului destinatie: ");
		path = scan.nextLine();
        Scriere.scriere(grey.getImage(),path);
        //Scriere.scriere(grey.getImage(),args[1]);
		System.out.println("Timp scriere: " + (System.nanoTime() - start) + " nanosecunde"); // se scrie in consola diferenta dintre momentul de inceput al scrierii si finalul acesteia
		
		int nrpixeli = grey.greey(img);
		System.out.println("Numarul de pixeli ai imaginii este: " + nrpixeli);
		
	}
}

