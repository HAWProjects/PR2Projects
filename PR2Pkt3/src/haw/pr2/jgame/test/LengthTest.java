package haw.pr2.jgame.test;

import static org.junit.Assert.*;
import haw.pr2.jgame.impl.Factory;
import haw.pr2.jgame.interfaces.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class LengthTest {

	private static Length length1;
	private static Speed speed1;
	private static TimeDiff timeDiff1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		length1 = Factory.lengthInMeter(5.0);
		speed1 = Factory.speedInMeterProSeKunde(10.0);
		timeDiff1 = Factory.timeInSec(2.0);
	}

	@Test
	public void testLengthDivOther() {
		assertEquals(Factory.lengthInMeter(2.5), length1.div(2));
		assertTrue(length1.checkInstance(length1.div(2)));
	}
	
	
	@Test
	public void testLengthMulOther() {
		assertEquals(Factory.lengthInMeter(10.0), length1.mul(2));
		assertTrue(length1.checkInstance(length1.mul(2)));
	}
	
	@Test
	public void testLengthDivSpeed() {
		assertEquals(Factory.timeInSec(0.5), length1.div(speed1));
		assertTrue(timeDiff1.checkInstance(length1.div(speed1)));
	}
	
	@Test
	public void testLengthDivTimeDiff() {
		assertEquals(Factory.speedInMeterProSeKunde(2.5), length1.div(timeDiff1));
		assertTrue(speed1.checkInstance(length1.div(timeDiff1)));
	}

}
