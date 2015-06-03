package haw.pr2.jgame.test;

import static org.junit.Assert.*;
import haw.pr2.jgame.Factory;
import haw.pr2.jgame.interfaces.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class WorkTest {


	private static Work work1;
	private static Force force1;
	private static Length length1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		work1 = Factory.workInNewtonMeter(10.0);
		force1 = Factory.forceInNewton(2.0);
		length1 = Factory.lengthInMeter(5.0);
	}

	@Test
	public void testWorkDivOther() {
		assertEquals(Factory.workInNewtonMeter(5.0), work1.div(2));
		assertEquals(5.0, work1.div(2).value(),0);
		assertTrue(work1.checkInstance(work1.div(2)));
	}
	
	
	@Test
	public void testWorkMulOther() {
		assertEquals(Factory.workInNewtonMeter(20.0), work1.mul(2));
		assertEquals(20.0, work1.mul(2).value(),0);
		assertTrue(work1.checkInstance(work1.mul(2)));
	}
	
	@Test
	public void testWorkdDivForce() {
		assertEquals(Factory.lengthInMeter(5.0), work1.div(force1));
		assertEquals(5.0, work1.div(force1).value(),0);
		assertTrue(length1.checkInstance(work1.div(force1)));
	
	}
	
	@Test
	public void testWorkDivLength() {
		assertEquals(Factory.forceInNewton(2.0), work1.div(length1));
		assertEquals(2.0, work1.div(length1).value(),0);
		assertTrue(force1.checkInstance(work1.div(length1)));
	}
}
