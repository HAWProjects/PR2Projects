package haw.pr2.test;

import static org.junit.Assert.*;
import haw.pr2.OldStuff.Car;
import haw.pr2.OldStuff.Porsche911GT2RS;

import org.junit.Before;
import org.junit.Test;

public class PorscheTest {

	private Car _p;
	
	@Before
	public void setUp() {
		_p = new Porsche911GT2RS(0.0,0.0,0.0,0.0);
	}

	@Test
	public void testset() {
		_p.set(2.0, 3, 23.9, 0.6);

		assertEquals(2.0, _p.getTime(), 0);
		assertEquals(3.0, _p.getPos(), 0);
		assertEquals(23.9, _p.getSpeed(), 0);
		assertEquals(0.6, _p.getProplevel(), 0);
	}
	
	
	@Test
	public void testreset()
	{
		_p.set(2.0, 3, 23.9, 0.6);
		_p.reset();
		assertEquals(0, _p.getTime(), 0);
		assertEquals(0, _p.getPos(), 0);
		assertEquals(0.0, _p.getSpeed(), 0);
		assertEquals(0, _p.getProplevel(), 0);
	}
	
	@Test
	public void teststep()
	{
		for(int i = 0 ; i < 100; ++i)
		{
			_p.step(0.1, 1.5);
			System.out.println("Speed: " + _p.getSpeed() * 3.6
					+ "\tPosition: " + _p.getPos() + "\tTime: "
					+ _p.getTime());
		}
		assertEquals(9.9999, _p.getTime(), 0.001);
		assertEquals(400.804749, _p.getPos(), 0.001);
		assertEquals(1.0, _p.getProplevel(), 0.1);
		assertEquals(239.0507, _p.getSpeed() * 3.6 , 0.001);
	}
	
	@Test(expected = Exception.class)
	public void testStepFail()
	{
		_p.set(-2.5, 2, 1, 1.6);
		
	}

}
