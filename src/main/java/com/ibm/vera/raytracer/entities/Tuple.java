package com.ibm.vera.raytracer.entities;

import java.util.Objects;

import com.ibm.vera.raytracer.helpers.Helper;

public class Tuple {
	private double x, y, z, w;

	public Tuple(double x, double y, double z, double w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public static Point point(double x, double y, double z) {
		return new Point(x, y, z);
	}
	
	public static Vector vector(double x, double y, double z) {
		return new Vector(x, y, z);
	}

	public static boolean isPoint(Tuple t) {
		return Helper.equal(t.w, 1.0);
	}

	public static boolean isVector(Tuple t) {
		return Helper.equal(t.w, 0.0);
	}

	public static Tuple add(Tuple a1, Tuple a2) {
		return new Tuple(a1.x + a2.x, a1.y + a2.y, a1.z + a2.z, a1.w + a2.w);
	}

	public static Tuple subtract(Tuple a1, Tuple a2) {
		return new Tuple(a1.x - a2.x, a1.y - a2.y, a1.z - a2.z, a1.w - a2.w);
	}

	public static Tuple negate(Tuple a1) {
		return new Tuple(-a1.x, -a1.y, -a1.z, -a1.w);
	}

	public static Tuple multiply(Tuple a, double scalar) {
		return new Tuple(scalar * a.x, scalar * a.y, scalar * a.z, scalar * a.w);
	}

	public static Tuple divide(Tuple a, double scalar) {
		return new Tuple(a.x / scalar, a.y / scalar, a.z/ scalar, a.w / scalar);
	}

	public static Double magnitude(Tuple a) {
		return Math.sqrt((Math.pow(a.x, 2) + Math.pow(a.y, 2) + Math.pow(a.z, 2) + Math.pow(a.w, 2)));
	}

	public static Tuple normalise(Tuple a) {
		double mag = Tuple.magnitude(a);
		return Tuple.divide(a, mag);
	}

	public static Double dot(Tuple v1, Tuple v2) {
		return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z + v1.w * v2.w;
	}

	public static Tuple cross(Tuple a, Tuple b) {
		return new Vector(
				a.y * b.z - a.z * b.y,
				a.z * b.x - a.x * b.z,
				a.x * b.y - a.y * b.x);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(w, x, y, z);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != Vector.class && getClass() != Point.class && getClass() != Tuple.class && getClass() != obj.getClass())
			return false;
		Tuple other = (Tuple) obj;
		return Helper.equal(this.x, other.x) && Helper.equal(this.y, other.y)
				&& Helper.equal(this.z, other.z) && Helper.equal(this.w, other.w);
	}

	@Override
	public String toString() {
		return "Tuple [x=" + x + ", y=" + y + ", z=" + z + ", w=" + w + "]";
	}

}
