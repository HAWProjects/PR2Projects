package haw.pr2.jgame.test;

import static org.junit.Assert.*;
import haw.pr2.jgame.Factory;
import haw.pr2.jgame.interfaces.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ForceTest {

	private static Acc acc1;
	private static Speed speed1;
	private static Mass mass1;
	private static Force force1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		speed1 = Factory.speedInMeterProSeKunde(10.0);
		acc1 = Factory.accInMeterProSeKundeQuadrat(2.0);
		mass1 = Factory.massInKilogramm(10);
		force1 = Factory.forceInNewton(10);
	}

	@Test
	public void testForceDivOther() {
		assertEquals(Factory.forceInNewton(5.0), force1.div(2));
		assertEquals(5.0, force1.div(2).value(),0);
		assertTrue(force1.checkInstance(force1.div(2)));
	}
	
	
	@Test
	public void testForceMulOther() {
		assertEquals(Factory.forceInNewton(20.0), force1.mul(2));
		assertEquals(20.0, force1.mul(2).value(),0);
		assertTrue(force1.checkInstance(force1.mul(2)));
	}
	
	@Test
	public void testForceDivMass() {
		assertEquals(Factory.accInMeterProSeKundeQuadrat(1.0), force1.div(mass1));
		assertEquals(1.0, force1.div(mass1).value(),0);
		assertTrue(acc1.checkInstance(force1.div(mass1)));
	
	}
	
	@Test
	public void testForceDivAcc() {
		assertEquals(Factory.massInKilogramm(5.0), force1.div(acc1));
		assertEquals(5.0, force1.div(acc1).value(),0);
		assertTrue(mass1.checkInstance(force1.div(acc1)));
	}
	
	@Test
	public void testForceMulSpeed() {
		assertEquals(Factory.forceInNewton(100.0), force1.mul(speed1));
		assertEquals(100.0, force1.mul(speed1).value(),0);
		assertTrue(force1.checkInstance(force1.mul(speed1)));
	}
}
