package haw.pr2.jgame.test;

import static org.junit.Assert.*;
import haw.pr2.jgame.impl.Factory;
import haw.pr2.jgame.interfaces.Acc;
import haw.pr2.jgame.interfaces.Force;
import haw.pr2.jgame.interfaces.Mass;
import haw.pr2.jgame.interfaces.Speed;

import org.junit.BeforeClass;
import org.junit.Test;

public class MassTest {

	private static Acc acc1;
	private static Mass mass1;
	private static Force force1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		acc1 = Factory.accInMeterProSeKundeQuadrat(2.0);
		mass1 = Factory.massInKilogramm(10);
		force1 = Factory.forceInNewton(10);
	}

	@Test
	public void testMassDivOther() {
		assertEquals(Factory.massInKilogramm(5.0), mass1.div(2));
		assertEquals(5.0, mass1.div(2).value(),0);
		assertTrue(mass1.checkInstance(mass1.div(2)));
	}
	
	
	@Test
	public void testMassMulOther() {
		assertEquals(Factory.massInKilogramm(20.0), mass1.mul(2));
		assertEquals(20.0, mass1.mul(2).value(),0);
		assertTrue(mass1.checkInstance(mass1.mul(2)));
	}
	
	@Test
	public void testMasseMulAcc() {
		assertEquals(Factory.forceInNewton(20.0), mass1.mul(acc1));
		assertEquals(20.0, mass1.mul(acc1).value(),0);
		assertTrue(force1.checkInstance(mass1.mul(acc1)));
	
	}
	
}
