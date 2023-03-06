package com.ibm.vera.raytracer.helpers;

public class Helper {
	
	private static final double EPSILON = 0.00001;
	
	public static boolean equal(double a, double b) {
		return (Math.abs(a - b) < EPSILON);
	}
	
	public static int clamp(int value, int min, int max) {
		return Math.max(min, Math.min(max, value));
	}

}
