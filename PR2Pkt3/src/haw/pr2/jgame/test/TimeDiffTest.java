package haw.pr2.jgame.test;

import static org.junit.Assert.*;
import haw.pr2.jgame.Factory;
import haw.pr2.jgame.interfaces.Acc;
import haw.pr2.jgame.interfaces.Force;
import haw.pr2.jgame.interfaces.Length;
import haw.pr2.jgame.interfaces.Mass;
import haw.pr2.jgame.interfaces.Power;
import haw.pr2.jgame.interfaces.Speed;
import haw.pr2.jgame.interfaces.TimeDiff;

import org.junit.BeforeClass;
import org.junit.Test;

public class TimeDiffTest {

	private static Acc acc1;
	private static Speed speed1;
	private static Length length1;
	private static TimeDiff timeDiff1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		speed1 = Factory.speedInMeterProSeKunde(10.0);
		acc1 = Factory.accInMeterProSeKundeQuadrat(2.0);
		timeDiff1 = Factory.timeInSec(2.0);
		length1 = Factory.lengthInMeter(5.0);
	}

	@Test
	public void testTimeDiffDivOther() {
		assertEquals(Factory.timeInSec(1.0), timeDiff1.div(2));
		assertEquals(1.0, timeDiff1.div(2).value(),0);
		assertTrue(timeDiff1.checkInstance(timeDiff1.div(2)));
	}
	
	
	@Test
	public void testTimeDiffMulOther() {
		assertEquals(Factory.timeInSec(4.0), timeDiff1.mul(2));
		assertEquals(4.0, timeDiff1.mul(2).value(),0);
		assertTrue(timeDiff1.checkInstance(timeDiff1.mul(2)));
	}
	
	@Test
	public void testTimeDiffdMulSpeed() {
		assertEquals(Factory.lengthInMeter(20.0), timeDiff1.mul(speed1));
		assertEquals(20.0, timeDiff1.mul(speed1).value(),0);
		assertTrue(length1.checkInstance(timeDiff1.mul(speed1)));
	
	}
	
	@Test
	public void testTimeDiffMulAcc() {
		assertEquals(Factory.speedInMeterProSeKunde(4.0), timeDiff1.mul(acc1));
		assertEquals(4.0, timeDiff1.mul(acc1).value(),0);
		assertTrue(speed1.checkInstance(timeDiff1.mul(acc1)));
	}
}
