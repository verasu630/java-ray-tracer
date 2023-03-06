package com.ibm.vera.raytracer.entities;

public class Colour extends Tuple {

	public Colour(double red, double green, double blue) {
		super(red, green, blue, 0);
	}
	
	public static Colour hadamard_product(Colour c1, Colour c2) {
		Colour result = new Colour(
				c1.getX() * c2.getX(),
				c1.getY() * c2.getY(),
				c1.getZ() * c2.getZ()
				);
		
		return result;
	}

	@Override
	public String toString() {
		return super.getX() + " " + super.getY() + " " + super.getZ() + "\n";
	}
}
