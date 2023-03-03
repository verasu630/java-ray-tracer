package com.ibm.vera.raytracer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ibm.vera.raytracer.entities.Colour;
import com.ibm.vera.raytracer.helpers.Helper;

public class CanvasTest {
	
	private Colour c1, c2;

	
	@Before
	public void initColours() {
		c1 = new Colour(0.9, 0.6, 0.75);
		c2 = new Colour(0.7, 0.1, 0.25);
	}
	
	@Test
	public void colourTest() {
		Colour  c = new Colour(-0.5, 0.4, 1.7);
		
		assertTrue(Helper.equal(c.getX(), -0.5));
		assertTrue(Helper.equal(c.getY(), 0.4));
		assertTrue(Helper.equal(c.getZ(), 1.7));
	}
	
	@Test
	public void addColoursTest() {
		assertTrue(Colour.add(c1, c2).equals(new Colour(1.6, 0.7, 1.0)));
	}
	
	@Test
	public void subtractColoursTest() {
		assertTrue(Colour.subtract(c1, c2).equals(new Colour(0.2, 0.5, 0.5)));
	}
	
	@Test
	public void multiplyColourByScalarTest() {
		Colour c = new Colour(0.2, 0.3, 0.4);
		assertTrue(Colour.multiply(c, 2).equals(new Colour(0.4, 0.6, 0.8)));
	}
	
	@Test
	public void hadamardTest() {
		c1 = new Colour(1, 0.2, 0.4);
		c2 = new Colour(0.9, 1, 0.1);
		assertTrue(Colour.hadamard_product(c1, c2).equals(new Colour(0.9, 0.2, 0.04)));
	}

}
