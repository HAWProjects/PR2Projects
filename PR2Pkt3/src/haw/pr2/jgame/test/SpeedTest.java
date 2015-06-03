package haw.pr2.jgame.test;

import static org.junit.Assert.*;
import haw.pr2.jgame.Factory;
import haw.pr2.jgame.interfaces.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class SpeedTest {

	private static Acc acc1;
	private static Speed speed1;
	private static Mass mass1;
	private static Force force1;
	private static Power power1;
	private static Length length1;
	private static TimeDiff timeDiff1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		speed1 = Factory.speedInMeterProSeKunde(10.0);
		acc1 = Factory.accInMeterProSeKundeQuadrat(2.0);
		mass1 = Factory.massInKilogramm(10);
		force1 = Factory.forceInNewton(10);
		timeDiff1 = Factory.timeInSec(2.0);
		length1 = Factory.lengthInMeter(5.0);
		power1= Factory.powerInWatt(100.0);
	}

	@Test
	public void testSpeedDivOther() {
		assertEquals(Factory.speedInMeterProSeKunde(5.0), speed1.div(2));
		assertEquals(5.0, speed1.div(2).value(),0);
		assertTrue(speed1.checkInstance(speed1.div(2)));
	}
	
	
	@Test
	public void testSpeedMulOther() {
		assertEquals(Factory.speedInMeterProSeKunde(20.0), speed1.mul(2));
		assertEquals(20.0, speed1.mul(2).value(),0);
		assertTrue(speed1.checkInstance(speed1.mul(2)));
	}
	
	@Test
	public void testSpeedMulSpeed() {
		assertEquals(Factory.speedInMeterProSeKunde(100.0), speed1.mul(speed1));
		assertEquals(100.0, speed1.mul(speed1).value(),0);
		assertTrue(speed1.checkInstance(speed1.mul(speed1)));
	
	}
	
	@Test
	public void testSpeedMulTimeDiff() {
		assertEquals(Factory.lengthInMeter(20.0), speed1.mul(timeDiff1));
		assertEquals(20.0, speed1.mul(timeDiff1).value(),0);
		assertTrue(length1.checkInstance(speed1.mul(timeDiff1)));
	}
	
	@Test
	public void testDragForce() {
		assertEquals(Factory.forceInNewton(10000.0), speed1.dragForce(speed1, power1));
		assertEquals(10000.0, speed1.dragForce(speed1, power1).value(),0);
		assertTrue(force1.checkInstance(speed1.dragForce(speed1, power1)));
	}
	
	@Test
	public void testCurveAcc() {
		assertEquals(Factory.accInMeterProSeKundeQuadrat(20.0), speed1.curveAcc(length1));
		assertEquals(20.0, speed1.curveAcc(length1).value(),0);
		assertTrue(acc1.checkInstance(speed1.curveAcc(length1)));
	}

}
