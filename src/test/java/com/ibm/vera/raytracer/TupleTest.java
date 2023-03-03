package com.ibm.vera.raytracer;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ibm.vera.raytracer.entities.Point;
import com.ibm.vera.raytracer.entities.Tuple;
import com.ibm.vera.raytracer.entities.Vector;
import com.ibm.vera.raytracer.helpers.Helper;

public class TupleTest {


	@Test
	public void isPointTest() {
		Tuple a = new Point(4.3, -4.2, 3.1);
		assertTrue("a is a point", Tuple.isPoint(a));
		assertFalse("a is not a vector", Tuple.isVector(a));
	}
	
	@Test
	public void isVectorTest() {
		Tuple a = new Vector(4.3, -4.2, 3.1);
		assertFalse("a is not a point", Tuple.isPoint(a));
		assertTrue("a is a vector", Tuple.isVector(a));
	}
	
	@Test
	public void addTwoTuplesTest() {
		Tuple a1 = new Tuple(3, -2, 5, 1);
		Tuple a2 = new Tuple(-2, 3, 1, 0);
		Tuple result = Tuple.add(a1, a2);
		assertTrue(result.toString(), result.equals(new Tuple(1, 1, 6, 1)));
	}
	
	@Test
	public void subtractTwoPointsTest() {
		Tuple a1 = new Point(3, 2, 1);
		Tuple a2 = new Point(5, 6, 7);
		Tuple result = Tuple.subtract(a1, a2);
		assertTrue(result.toString(), result.equals(Tuple.vector(-2, -4, -6)));
	}
	
	@Test
	public void subtractVectorFromPointsTest() {
		Tuple a1 = new Point(3, 2, 1);
		Tuple a2 = new Vector(5, 6, 7);
		Tuple result = Tuple.subtract(a1, a2);
		assertTrue(result.toString(), result.equals(new Point(-2, -4, -6)));
	}
	
	@Test
	public void subtractTwoVectorsTest() {
		Tuple a1 = new Vector(3, 2, 1);
		Tuple a2 = new Vector(5, 6, 7);
		Tuple result = Tuple.subtract(a1, a2);
		assertTrue(result.toString(), result.equals(new Vector(-2, -4, -6)));
	}
	
	@Test
	public void subtractVectorFromZeroTest() {
		Tuple zero = new Vector(0, 0, 0);
		Tuple v = new Vector(1, -2, 3);
		Tuple result = Tuple.subtract(zero, v);
		assertTrue(result.toString(), result.equals(new Vector(-1, 2, -3)));
	}
	
	@Test
	public void negateTupleTest() {
		Tuple a = new Tuple(1, -2, 3, -4);
		Tuple result = Tuple.negate(a);
		assertTrue(result.toString(), result.equals(new Tuple(-1, 2, -3, 4)));
	}
	
	@Test
	public void multiplyTupleByScalarTest() {
		Tuple a = new Tuple(1, -2, 3, -4);
		Tuple result = Tuple.multiply(a, 3.5);
		assertTrue(result.toString(), result.equals(new Tuple(3.5, -7, 10.5, -14)));
	}
	
	@Test
	public void multiplyTupleByFractionTest() {
		Tuple a = new Tuple(1, -2, 3, -4);
		Tuple result = Tuple.multiply(a, 0.5);
		assertTrue(result.toString(), result.equals(new Tuple(0.5, -1, 1.5, -2)));
	}
	
	@Test
	public void divideTupleByScalarTest() {
		Tuple a = new Tuple(1, -2, 3, -4);
		Tuple result = Tuple.divide(a, 2);
		assertTrue(result.toString(), result.equals(new Tuple(0.5, -1, 1.5, -2)));
	}
	
	@Test
	public void magnitudeTest1() {
		Double result = Tuple.magnitude(new Vector(1, 0, 0));
		assertTrue(result.toString(), Helper.equal(result, 1));
	}

	@Test
	public void magnitudeTest2() {
		Double result = Tuple.magnitude(new Vector(0, 1, 0));
		assertTrue(result.toString(), Helper.equal(result, 1));
	}
	
	@Test
	public void magnitudeTest3() {
		Double result = Tuple.magnitude(new Vector(0, 0, 1));
		assertTrue(result.toString(), Helper.equal(result, 1));
	}
	
	@Test
	public void magnitudeTest4() {
		Double result = Tuple.magnitude(new Vector(1, 2, 3));
		assertTrue(result.toString(), Helper.equal(result, Math.sqrt(14)));
	}
	
	@Test
	public void magnitudeTest5() {
		Double result = Tuple.magnitude(new Vector(-1, -2, -3));
		assertTrue(result.toString(), Helper.equal(result, Math.sqrt(14)));
	}
	
	@Test
	public void normaliseTest1() {
		Tuple v = new Vector(4, 0, 0);
		Tuple result = Tuple.normalise(v);
		assertTrue(result.equals(new Vector(1, 0, 0)));
	}
	
	@Test
	public void normaliseTest2() {
		Tuple v = new Vector(1, 2, 3);
		Tuple result = Tuple.normalise(v);
		assertTrue(result.equals(new Vector(1/Math.sqrt(14), 2/Math.sqrt(14), 3/Math.sqrt(14))));
	}
	
	@Test
	public void normaliseAndMagnitudeTest() {
		Tuple v = new Vector(1, 2, 3);
		Tuple norm = Tuple.normalise(v);
		assertTrue(Helper.equal(Tuple.magnitude(norm), 1));
	}
	
	@Test
	public void dotProductTest() {
		Tuple v1 = new Vector(1, 2, 3);
		Tuple v2 = new Vector(2, 3, 4);
		Double result = Tuple.dot(v1, v2);
		assertTrue(Helper.equal(result, 20));
	}
	
	@Test
	public void crossProductTest() {
		Tuple a = new Vector(1, 2, 3);
		Tuple b = new Vector(2, 3, 4);
		Tuple resultA = Tuple.cross(a, b);
		Tuple resultB = Tuple.cross(b, a);
		assertTrue(resultA.equals(new Vector(-1, 2, -1)));
		assertTrue(resultB.equals(new Vector(1, -2, 1)));
	}
}
