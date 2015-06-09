package haw.pr2.jgame.test;

import static org.junit.Assert.*;
import haw.pr2.jgame.impl.Factory;
import haw.pr2.jgame.interfaces.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PowerTest {
	
	private static Speed speed1;
	private static Force force1;
	private static Power power1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		speed1 = Factory.speedInMeterProSeKunde(10.0);
		force1 = Factory.forceInNewton(10.0);
		power1= Factory.powerInWatt(100.0);
	}

	@Test
	public void testPowerDivOther() {
		assertEquals(Factory.powerInWatt(50.0), power1.div(2));
		assertEquals(50.0, power1.div(2).value(),0);
		assertTrue(power1.checkInstance(power1.div(2)));
	}
	
	
	@Test
	public void testPowerMulOther() {
		assertEquals(Factory.powerInWatt(200.0),power1.mul(2));
		assertEquals(200.0, power1.mul(2).value(),0);
		assertTrue(power1.checkInstance(power1.mul(2)));
	}
	
	@Test
	public void testPowerDivForce() {
		assertEquals(Factory.speedInMeterProSeKunde(10.0), power1.div(force1));
		assertEquals(10.0, power1.div(force1).value(),0);
		assertTrue(speed1.checkInstance(power1.div(force1)));
	
	}
	
	@Test
	public void testPowerDivSpeed() {
		assertEquals(Factory.forceInNewton(10.0), power1.div(speed1));
		assertEquals(10.0, power1.div(speed1).value(),0);
		assertTrue(force1.checkInstance(power1.div(speed1)));
	}
	
}
