package com.ibm.vera.raytracer;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ibm.vera.raytracer.entities.Canvas;
import com.ibm.vera.raytracer.entities.Colour;

public class CanvasTest {
	
	private Canvas c;
	
	@Before
	public void initCanvas() {
		c = new Canvas(10, 20);
	}
	
	@Test
	public void createCanvasTest() {
		assertTrue(c.getPixels().length == 20);
		assertTrue(c.getPixels()[0].length == 10);
		
		for (Colour[] row : c.getPixels()) {
	        for (Colour colour : row) {
	        	assertTrue(colour.equals(new Colour(0, 0, 0)));
	        }
	    }
	}
	
	@Test
	public void setColourTest() {
		Colour red = new Colour(1, 0, 0);
		c.writePixel(2, 3, red);
		assertTrue(c.pixelAt(2, 3).equals(new Colour(1, 0, 0)));
	}
	
	@Test
	public void ppmHeaderTest() throws IOException {
		c = new Canvas(5, 3);
		
		BufferedReader reader = new BufferedReader(new StringReader(c.toPPM()));

		assertTrue(reader.readLine().equals("P3"));
		assertTrue(reader.readLine().equals("5 3"));
		assertTrue(reader.readLine().equals("255"));
	}
	
	@Test
	public void ppmDataTest() throws IOException {
		c = new Canvas(5, 3);
		Colour c1 = new Colour(1.5, 0 ,0);
		Colour c2 = new Colour(0, 0.5, 0);
		Colour c3 = new Colour(-0.5, 0, 1);
		
		c.writePixel(0, 0, c1);
		c.writePixel(2, 1, c2);
		c.writePixel(4, 2, c3);
		
		BufferedReader reader = new BufferedReader(new StringReader(c.toPPM()));
		reader.readLine();
		reader.readLine();
		reader.readLine();
		
		assertTrue(reader.readLine().equals("255 0 0 0 0 0 0 0 0 0 0 0 0 0 0"));
		assertTrue(reader.readLine().equals("0 0 0 0 0 0 0 128 0 0 0 0 0 0 0"));
		assertTrue(reader.readLine().equals("0 0 0 0 0 0 0 0 0 0 0 0 0 0 255"));
	}
	
	@Test
	public void ppmLongLineTest() throws IOException {
		c = new Canvas(10, 2);
		for (Colour[] p : c.getPixels()) {
	        Arrays.fill(p, new Colour(1, 0.8, 0.6));
	    }
		
		System.out.println(c.toPPM());
		
		BufferedReader reader = new BufferedReader(new StringReader(c.toPPM()));
		reader.readLine();
		reader.readLine();
		reader.readLine();
		
		assertTrue(reader.readLine().equals("255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204"));
		assertTrue(reader.readLine().equals("153 255 204 153 255 204 153 255 204 153 255 204 153"));
		
		assertTrue(reader.readLine().equals("255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204"));
		assertTrue(reader.readLine().equals("153 255 204 153 255 204 153 255 204 153 255 204 153"));
	}

	@Test
	public void ppmNewLineTest() {
		String ppm = c.toPPM();
		assertTrue(ppm.endsWith("\n"));
	}
}
