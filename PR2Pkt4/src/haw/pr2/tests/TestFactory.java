package haw.pr2.tests;

import static org.junit.Assert.assertTrue;
import haw.pr2.impl.container.ContainerFactory;
import haw.pr2.impl.container.ContainerImpl;
import haw.pr2.impl.container.ContainerStowageImpl;
import haw.pr2.impl.container.NonContainerImpl;
import haw.pr2.impl.container.NullContainerImpl;
import haw.pr2.interfaces.physicObjects.cargo.Container;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestFactory {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testContainerFactory() {
		Stowage<Container> stowage = ContainerStowageImpl.valueOf(15, 15, 15);
		Container container = ContainerFactory.container20ftDryLoad(stowage);
		assertTrue(container instanceof ContainerImpl);
	}
	
	@Test
	public void testNullContainerFactory() {
		Container container = ContainerFactory.NULLContainer();
		assertTrue(container instanceof NullContainerImpl);
	}
	
	@Test
	public void testNonContainerFactory() {
		Container container = ContainerFactory.NONContainer();
		assertTrue(container instanceof NonContainerImpl);
	}
}
