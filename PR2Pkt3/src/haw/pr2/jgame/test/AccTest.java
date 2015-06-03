package haw.pr2.jgame.test;

import static org.junit.Assert.*;
import haw.pr2.jgame.Factory;
import haw.pr2.jgame.impl.ForceImpl;
import haw.pr2.jgame.interfaces.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class AccTest {
	private static Acc acc1;
	private static Force force1;
	private static Speed speed1;
	private static Mass mass1;
	private static TimeDiff timeDiff1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		acc1 = Factory.accInMeterProSeKundeQuadrat(5);
		force1 = Factory.forceInNewton(10.0);
		speed1 = Factory.speedInMeterProSeKunde(10.0);
		mass1 = Factory.massInKilogramm(2.0);
		timeDiff1 = Factory.timeInSec(2.0);
	}

	@Test
	public void testAccDiv() {
		assertEquals(Factory.accInMeterProSeKundeQuadrat(2.5), acc1.div(2));
		assertTrue(acc1.checkInstance(acc1.div(2)));
	}
	
	
	@Test
	public void testAccMulOther() {
		assertEquals(Factory.accInMeterProSeKundeQuadrat(10.0), acc1.mul(2));
		assertTrue(acc1.checkInstance(acc1.mul(2)));
	}
	
	@Test
	public void testAccMulMass() {
		assertEquals(Factory.forceInNewton(10.0), acc1.mul(mass1));
		assertTrue(force1.checkInstance(acc1.mul(mass1)));
	}
	
	@Test
	public void testAccMulTimeDiff() {
		assertEquals(speed1, acc1.mul(timeDiff1));
		assertTrue(speed1.checkInstance(acc1.mul(timeDiff1)));
	}
	
}
